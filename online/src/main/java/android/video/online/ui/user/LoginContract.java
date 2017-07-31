package android.video.online.ui.user;

import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;

/**
 * Created by Jay on 2017/7/25.
 */

public class LoginContract {
    interface  View extends BasicView<Presenter>{
        void jumpRegisterPage();

        void loginSuccess(String result);

        void loginFail(String fail);
    }
    interface Presenter extends BasicPresenter<View>{
        void gotoRegisterPage();

        void gotoLogin(String username, String password);
    }
}
