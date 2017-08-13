package android.video.online.ui.user;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.video.online.core.BasicView;
import android.video.online.core.HttpCallback;
import android.video.online.http.ServiceManager;
import android.video.online.manager.UserManager;
import android.video.online.model.UserBindModel;
import android.video.online.model.UserModel;
import android.video.online.other.OtherType;
import android.video.online.other.QLoginHelper;
import android.video.online.other.SimpleQLoginListener;
import android.video.online.widget.LoadingView;

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
        ServiceManager.getInstance().gotoLogin(null, username, password, new HttpCallback() {
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

    @Override
    public void gotoQLogin(Activity activity, Context context, SimpleQLoginListener listener) {
        QLoginHelper.getInstance().init(context, listener);
        QLoginHelper.getInstance().login(activity);
    }

    @Override
    public void gotoLoginToQQ(LoadingView loadingView, String device_id, String open_id, String nickname, String union_id) {
        ServiceManager.getInstance().gotoLoginToQQ(loadingView, device_id, open_id, nickname, OtherType.QQ, union_id, new HttpCallback() {
            @Override
            protected void onFail(Call call, Object... objects) {

            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject resultJson = new JSONObject(result);

                        if (resultJson.optString("code").equals("1")) {
                            UserBindModel userBindModel = JSON.parseObject(resultJson.optString("data"), UserBindModel.class);
                            view.loginSuccess("登录成功");
                        } else {
                            view.loginFail(resultJson.optString("msg"));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        view.loginFail("第三方登录失败");
                    }
                }
            }
        });
    }
}
