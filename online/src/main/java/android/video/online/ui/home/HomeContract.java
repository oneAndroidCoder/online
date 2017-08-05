package android.video.online.ui.home;

import android.video.online.BasicActivity;
import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;
import android.video.online.model.HomeModel;
import android.widget.LinearLayout;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Jay on 2017/7/22.
 */

public class HomeContract {
    interface View extends BasicView<Presenter> {

        void getDots();

        void onSuccess(Call call, HomeModel homeModel);

        void onFail(Call call, IOException e);

        BasicActivity getContext();
    }

    interface Presenter extends BasicPresenter<View> {
        void loadData();

        void addClazzType(LinearLayout mLlHomeContent, HomeModel homeModel);

        void addFreeVideo(LinearLayout mLlHomeContent, HomeModel homeModel);

        void addHotVideo(LinearLayout mLlHomeContent, HomeModel homeModel);
    }
}
