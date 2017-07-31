package android.video.online.ui.video;

import android.util.Log;
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
                            String data = resultObj.optString("data");
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
                        JSONObject resultObj = new JSONObject(result);
                        JSONObject dataObj = resultObj.optJSONObject("data");
                        String orderInfo = dataObj.optString("pay_info");
                        Log.e("pay_stutas", Thread.currentThread().getName());
                        if (view.getContext() instanceof CourseDetailActivity) {
                            PayUtils.getInstance().gotoPay(((CourseDetailActivity) view.getContext()), orderInfo, new PayUtils.Callback() {
                                @Override
                                public void callback(Map result) {

                                    if (result.containsKey("resultStatus") && result.get("resultStatus").equals("9000")) {
                                        VideoPlayerActivity.start(view.getContext(), videoId);
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
}
