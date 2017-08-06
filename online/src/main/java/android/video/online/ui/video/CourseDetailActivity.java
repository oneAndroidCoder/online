package android.video.online.ui.video;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.core.BasicPresenter;
import android.video.online.model.CourseDataModel;
import android.video.online.model.VideoModel;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.video.online.R.id.tv_add_shopping;
import static android.video.online.R.id.tv_buy_course;

/**
 * Created by Jay on 2017/7/30.
 */
public class CourseDetailActivity extends BasicActivity implements CourseDetailContract.View {

    private CourseDetailContract.Presenter presenter;
    private TextView                       mTvPrice;
    private TextView                       mTvDes;
    private TextView                       mTvAddShopping;
    private TextView                       mTvTeacher;
    private ImageView                      mIvCourse;
    private RecyclerView                   mLvAllVideo;
    private CourseDataModel                model;
    private View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_buy_course:

                    presenter.gotoBuyCourse(model.getCourse().getId());
                    break;
                case R.id.tv_add_shopping:

                    presenter.gotoAddShopping(model.getCourse().getId());
                    break;
            }
        }
    };

    @Override
    public int setLayoutId() {
        return R.layout.activity_video_list;
    }

    @Override
    public void init() {
        initView();
        initData();
    }

    private void initData() {
        presenter = new CourseDetailPresenter(this);
        Intent intent = getIntent();

        if (intent != null) {
            String id = intent.getStringExtra("id");
            presenter.loadData(id);
        }
    }

    private void initView() {
        mTvDes = (TextView) findViewById(R.id.tv_course_des);
        mTvPrice = (TextView) findViewById(R.id.tv_course_price);
        mTvTeacher = (TextView) findViewById(R.id.tv_course_teacher);
        mTvAddShopping = (TextView) findViewById(R.id.tv_add_shopping);
        mIvCourse = (ImageView) findViewById(R.id.iv_course);
        mLvAllVideo = (RecyclerView) findViewById(R.id.lv_all_video);
        findViewById(tv_buy_course).setOnClickListener(mClickListener);
        findViewById(tv_add_shopping).setOnClickListener(mClickListener);
    }

    @Override
    public void handlerMessage(Message msg) {

    }

    public static void start(Context context, String id) {
        Intent intent = new Intent(context, CourseDetailActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    @Override
    public BasicPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void todoShowCourseDetail(CourseDataModel model) {
        if (model != null) {
            this.model = model;
            mTvTeacher.setText(model.getTeachers().getTname());
            mTvPrice.setText("￥ " + model.getCourse().getPrice());
            mTvDes.setText(model.getCourse().getDes());
            imageLoader.displayImage(model.getCourse().getCover(), mIvCourse);

            List<VideoModel>           videos        = model.getVideos();
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            mLvAllVideo.setLayoutManager(layoutManager);
            mLvAllVideo.setAdapter(new VideoAdapter(this, videos));
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onPayFinish(String order_no) {
        presenter.gotoQueryOrder(order_no);
    }

    @Override
    public void onPaySuccess(String status) {
        switch (status) {
            case "1":
                break;
        }
        showToast(status);
    }

    @Override
    public void onAddShoppingSuccess() {
        showToast("添加成功");
    }
}
