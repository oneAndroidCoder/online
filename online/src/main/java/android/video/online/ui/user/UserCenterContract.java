package android.video.online.ui.user;

import android.video.online.BasicActivity;
import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;

/**
 * Created by Jay on 2017/8/6.
 */

public class UserCenterContract {
    interface View extends BasicView<Presenter> {
        BasicActivity getBasicActivity();
    }

    interface Presenter extends BasicPresenter<View> {
        void logout();
    }
}
