package android.video.online.ui.video;

import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;
import android.video.online.model.VideoPlayerModel;

/**
 * Created by Jay on 2017/7/25.
 */

public class VideoPlayerContract {
    interface View extends BasicView<Presenter> {
        void todoShowVideoView(VideoPlayerModel data);
    }

    interface Presenter extends BasicPresenter<View> {
        void loadVideoDetail(String videoId);
    }
}
