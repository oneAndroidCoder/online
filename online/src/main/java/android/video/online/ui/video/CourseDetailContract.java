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

        void onPayFinish(String order_no);

        void onPaySuccess(String status);

        void onAddShoppingSuccess();
    }

    interface Presenter extends BasicPresenter<View> {
        void loadData(String id);

        void gotoBuyCourse(final String videoId);

        void gotoQueryOrder(String order_no);

        void gotoAddShopping(String course_id);
    }
}
