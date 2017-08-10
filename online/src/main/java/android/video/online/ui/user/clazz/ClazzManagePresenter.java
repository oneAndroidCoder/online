package android.video.online.ui.user.clazz;

import android.video.online.core.BasicView;
import android.video.online.core.HttpCallback;
import android.video.online.http.ServiceManager;
import android.video.online.model.CourseModel;
import android.video.online.widget.LoadingView;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Jay on 2017/8/10.
 */

public class ClazzManagePresenter implements ClazzManageContract.Presenter {
    private ClazzManageContract.View view;

    public ClazzManagePresenter(ClazzManageContract.View view) {
        this.view = view;
    }

    @Override
    public BasicView getView() {
        return view;
    }

    @Override
    public void loadData(LoadingView loadingView) {
        ServiceManager.getInstance().loadCourseList(loadingView, new HttpCallback() {
            @Override
            protected void onFail(Call call, Object... objects) {
                view.onFailed();
            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                if(response.isSuccessful()){
                    try {
                        JSONObject json = new JSONObject(result);
                        if(json.optString("code").equals("1")){
                            List<CourseModel> data = JSON.parseArray(json.optJSONObject("data").optString("list"), CourseModel.class);
                            view.onSuccess(data);
                        } else {
                            view.onFailed();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        view.onFailed();
                    }
                }
            }
        });
    }
}
