package android.video.online.ui.user;

import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;

/**
 * Created by Jay on 2017/7/24.
 */

public class RegisterContract {
    interface View extends BasicView<Presenter>{
        void registerSuccess();

        void registerFail(String msg);

        void jumpLoginPage();
    }
    interface  Presenter extends BasicPresenter<View>{
        void gotoRegister(String s, String toString, String string);

        void gotoLoginPage();
    }
}
