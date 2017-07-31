package android.video.online.ui.home;

import android.text.TextUtils;
import android.video.online.core.BasicView;
import android.video.online.core.HttpCallback;
import android.video.online.http.ServiceManager;
import android.video.online.model.HomeModel;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Jay on 2017/7/22.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        ServiceManager.getInstance().loadHomeData(new HttpCallback() {

            @Override
            protected void onFail(Call call, Object... objects) {
                view.onFail(call, null);
            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                if (response.isSuccessful()) {

                    if (!TextUtils.isEmpty(result)) {

                        try {
                            JSONObject object = new JSONObject(result.toString());
                            String data = object.optString("data");
                            HomeModel homeModel = JSON.parseObject(data, HomeModel.class);
                            view.onSuccess(call, homeModel);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    view.onFail(call, null);
                }
            }

        });
    }

    @Override
    public BasicView getView() {
        return view;
    }
}
