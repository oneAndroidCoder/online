package android.video.online.ui.user;

import android.app.Activity;
import android.content.Context;
import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;
import android.video.online.other.SimpleQLoginListener;
import android.video.online.widget.LoadingView;

/**
 * Created by Jay on 2017/7/25.
 */

public class LoginContract {
    interface View extends BasicView<Presenter> {
        void jumpRegisterPage();

        void loginSuccess(String result);

        void loginFail(String fail);
    }

    interface Presenter extends BasicPresenter<View> {
        void gotoRegisterPage();

        void gotoLogin(String username, String password);

        void autoLogin();

        void gotoQLogin(Activity activity, Context context, SimpleQLoginListener simpleQLoginListener);

        void gotoLoginToQQ(LoadingView loadingView, String device_id, String open_id, String nickname, String union_id);
    }
}
