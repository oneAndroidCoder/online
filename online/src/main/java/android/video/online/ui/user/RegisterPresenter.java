package android.video.online.ui.user;

import android.video.online.core.BasicView;
import android.video.online.core.HttpCallback;
import android.video.online.http.ServiceManager;
import android.video.online.manager.UserManager;
import android.video.online.model.UserModel;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Jay on 2017/7/24.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void gotoRegister(String username, String password, final String repassword) {

        ServiceManager.getInstance().gotoRegister(username, password, repassword, new HttpCallback() {
            @Override
            protected void onFail(Call call, Object... objects) {
                view.registerFail("网络异常");
            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                if(response.isSuccessful()){
                    try {
                        JSONObject resultJson = new JSONObject(result);
                        String code = resultJson.optString("code");
                        if(code.equals("1")){
                            String data = resultJson.optString("data");
                            UserModel userModel = JSON.parseObject(data, UserModel.class);
                            UserManager.getInstance().saveUserModel(userModel);
                            view.registerSuccess();
                        } else {
                            view.registerFail(resultJson.optString("msg"));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void gotoLoginPage() {
        view.jumpLoginPage();
    }

    @Override
    public BasicView getView() {
        return view;
    }
}
