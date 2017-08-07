package android.video.online.ui.upload;

import android.video.online.BasicActivity;
import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;
import android.video.online.model.VideoUploadAuthModel;

/**
 * Created by Jay on 2017/8/6.
 */

public class UploadContract {
    interface View extends BasicView<Presenter> {
        BasicActivity getBasicActivity();

        void onUploadAuth(VideoUploadAuthModel model);
    }

    interface Presenter extends BasicPresenter<View> {
        void openSdCard();

        void loadUploadAuth(String videoTitle, String videoDes, String courseId);
    }
}
