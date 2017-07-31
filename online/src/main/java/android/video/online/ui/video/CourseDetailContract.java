package android.video.online.ui.video;

import android.content.Context;
import android.video.online.core.BasicPresenter;
import android.video.online.core.BasicView;
import android.video.online.model.CourseDataModel;

/**
 * Created by Jay on 2017/7/30.
 */

public class CourseDetailContract {
    interface View extends BasicView<Presenter> {
        void todoShowCourseDetail(CourseDataModel courseDataModel);

        Context getContext();
    }

    interface Presenter extends BasicPresenter<View> {
        void loadData(String id);

        void gotoBuyCourse(final String videoId);
    }
}
