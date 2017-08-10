package android.video.online.ui.user.clazz;

import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;
import android.video.online.model.CourseModel;
import android.video.online.widget.LoadingView;

import java.util.List;

/**
 * Created by Jay on 2017/8/10.
 */

public class ClazzManageContract {
    interface View extends BasicView<Presenter> {
        void onFailed();

        void onSuccess(List<CourseModel> data);
    }

    interface Presenter extends BasicPresenter<View> {
        void loadData(LoadingView loadingView);
    }
}
