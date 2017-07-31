package android.video.online.ui.splash;

import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;

/**
 * Created by Jay on 2017/7/21.
 */

public class SplashContract {
    interface View extends BasicView<Presenter> {
        void initAdView(String adUrl);

        void enterHome();
    }

    interface Presenter extends BasicPresenter<View> {
        void initAd();
        void enterHome();
    }
}
