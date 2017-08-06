package android.video.online.ui.video;

import android.text.TextUtils;
import android.video.online.core.BasicView;
import android.video.online.core.HttpCallback;
import android.video.online.http.ServiceManager;
import android.video.online.manager.UserManager;
import android.video.online.model.CourseDataModel;
import android.video.online.pay.PayUtils;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Jay on 2017/7/30.
 */

public class CourseDetailPresenter implements CourseDetailContract.Presenter {
    private CourseDetailContract.View view;

    public CourseDetailPresenter(CourseDetailContract.View view) {
        this.view = view;
    }

    @Override
    public BasicView getView() {
        return view;
    }

    @Override
    public void loadData(String id) {

        ServiceManager.getInstance().loadVideoList(id, new HttpCallback() {
            @Override
            protected void onFail(Call call, Object... objects) {

            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {

                if (response.isSuccessful()) {
                    try {
                        JSONObject resultObj = new JSONObject(result);
                        if (resultObj.optString("code").equals("1")) {
                            String          data            = resultObj.optString("data");
                            CourseDataModel courseDataModel = JSON.parseObject(data, CourseDataModel.class);
                            view.todoShowCourseDetail(courseDataModel);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    public void gotoBuyCourse(final String videoId) {
        ServiceManager.getInstance().createOrderInfo(UserManager.getInstance().getUserModel().getUser_id(), videoId, new HttpCallback() {
            @Override
            protected void onFail(Call call, Object... objects) {

            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject   resultObj = new JSONObject(result);
                        JSONObject   dataObj   = resultObj.optJSONObject("data");
                        String       orderInfo = dataObj.optString("pay_info");
                        final String order_no  = dataObj.optString("order_no");
                        if (view.getContext() instanceof CourseDetailActivity) {
                            PayUtils.getInstance().gotoPay(((CourseDetailActivity) view.getContext()), orderInfo, new PayUtils.Callback() {
                                @Override
                                public void callback(Map result) {

                                    if (result.containsKey("resultStatus") && result.get("resultStatus").equals("9000")) {
                                        //VideoPlayerActivity.start(view.getContext(), videoId);
                                        view.onPayFinish(order_no);
                                    }
                                }
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    public void gotoQueryOrder(String order_no) {
        ServiceManager.getInstance().queryOrder(order_no, new HttpCallback() {

            @Override
            protected void onFail(Call call, Object... objects) {

            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                /**
                 * status 订单状态|
                 1:待支付,
                 2:已支付,
                 3:已发货,

                 5:申请退款,6:支付失败,7:退款处理中,8:退款成功,9:退款失败
                 */
                view.onPaySuccess(result);
            }
        });
    }

    @Override
    public void gotoAddShopping(String course_id) {
        ServiceManager.getInstance().addShoppingCart(course_id, UserManager.getInstance().getUserModel().getUser_id(), new HttpCallback() {
            @Override
            protected void onFail(Call call, Object... objects) {

            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                if(response.isSuccessful()){
                    try {
                        JSONObject resultObj = new JSONObject(result);
                        String     code      = resultObj.optString("code");
                        if(!TextUtils.isEmpty(code) &&  code.equals("1")){
                            view.onAddShoppingSuccess();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
