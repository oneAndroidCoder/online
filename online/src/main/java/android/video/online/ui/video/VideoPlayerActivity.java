package android.video.online.ui.video;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.core.BasicPresenter;
import android.video.online.model.VideoPlayerModel;

import com.aliyun.vodplayer.media.AliyunDataSource;
import com.aliyun.vodplayer.media.IAliyunVodPlayer;
import com.aliyun.vodplayerview.widget.AliyunVodPlayerView;

/**
 * Created by Jay on 2017/7/25.
 */

public class VideoPlayerActivity extends BasicActivity implements VideoPlayerContract.View {
    private AliyunVodPlayerView mVideoView;

    private VideoPlayerContract.Presenter presenter;
    private String videoId = "";

    /**
     * http://www.21mmm.com/Course/course_learn/id/91
     */

    @Override
    public int setLayoutId() {
        return R.layout.activity_video_player;
    }

    @Override
    public void init() {
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            videoId = intent.getStringExtra("videoId");
        }
        presenter = new VideoPlayerPresenter(this);
        presenter.loadVideoDetail(videoId);
    }

    private void initView() {
        mVideoView = (AliyunVodPlayerView) findViewById(R.id.video_view);
        mVideoView.setOnPreparedListener(new IAliyunVodPlayer.OnPreparedListener() {
            @Override
            public void onPrepared() {
            }
        });
    }

    @Override
    public void handlerMessage(Message msg) {

    }

    public static void start(Context context) {
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        context.startActivity(intent);
    }

    public static void start(Context context, String videoId) {
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        intent.putExtra("videoId", videoId);
        context.startActivity(intent);
    }

    @Override
    public BasicPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void todoShowVideoView(VideoPlayerModel data) {
        AliyunDataSource.AliyunDataSourceBuilder builder = new AliyunDataSource.AliyunDataSourceBuilder(this);

        String AccessKeyId = "LTAIBBPahuNaJzfu";
        String AccessKeySecret = "EBC4JTdwhtGCWnAHRY5Up6zDufbxuy";
        String VideoId = "b5a7a26c9b4c4022b07167e08ed5a2ad";
        String playKey = "lvhxv6yi55mrkgwnl36yjuawr7lhc1h4aghr2d6efwrfygysjzokv1u31uufai9y";

//        playKey = data.getVod_auth().getPlayAuth();
        VideoId = data.getVod_auth().getVideoMeta().getVideoId();

        builder.setAccessKeyId(AccessKeyId);
        builder.setAccessKeySecret(AccessKeySecret);
        builder.setVideoId(VideoId);
        builder.setPlayKey(playKey);

        builder.setQuality(IAliyunVodPlayer.QualityValue.QUALITY_2K);
        mVideoView.setDataSource(builder.build());
    }
}
