package android.video.online.ui.user;

import android.text.TextUtils;
import android.util.Log;
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
 * Created by Jay on 2017/7/25.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public BasicView getView() {
        return view;
    }

    @Override
    public void gotoRegisterPage() {
        view.jumpRegisterPage();
    }

    @Override
    public void gotoLogin(String username, String password) {
        ServiceManager.getInstance().gotoLogin(username, password, new HttpCallback() {
            @Override
            protected void onFail(Call call, Object... objects) {
                view.loginFail("");
            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject resultJson = new JSONObject(result);
                        String code = resultJson.optString("code");
                        if (code.equals("1")) {
                            String data = resultJson.optString("data");
                            UserModel userModel = JSON.parseObject(data, UserModel.class);
                            UserManager.getInstance().saveUserModel(userModel);
                            view.loginSuccess(result);
                        } else {
                            view.loginFail("");
                        }
                        Log.e("thread", Thread.currentThread().getName());
                    } catch (JSONException e) {
                        e.printStackTrace();
                        view.loginFail("");
                    }
                }
            }
        });
    }

    @Override
    public void autoLogin() {
        UserModel userModel = UserManager.getInstance().getUserModel();
        if (userModel != null && !TextUtils.isEmpty(userModel.getUser_id()) && !TextUtils.isEmpty(userModel.getPassword())) {
            view.loginSuccess("auto");
        }
    }
}
