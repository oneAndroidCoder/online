package android.video.online.ui.upload;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.core.BasicPresenter;
import android.video.online.model.VideoUploadAuthModel;
import android.video.online.utils.UriUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.sdk.android.vod.upload.VODUploadCallback;
import com.alibaba.sdk.android.vod.upload.VODUploadClient;
import com.alibaba.sdk.android.vod.upload.VODUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.VodInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2017/8/6.
 */

public class UploadActivity extends BasicActivity implements View.OnClickListener, UploadContract.View {
    private TextView tvUpload;
    private EditText etVideoTitle;
    private EditText etVideoDes;
    private EditText etCourseId;

    private String videoTitle;
    private String videoDes;
    private String courseId;


    private VODUploadClient uploader;

    private UploadContract.Presenter presenter;
    private String requestId;
    private String uploadAddress;
    private String uploadAuth;
    private String videoId;

    @Override
    public int setLayoutId() {
        return R.layout.activity_upload;
    }

    @Override
    public void init() {
        initView();
        initData();
        initListener();
    }

    private void initData() {
        presenter = new UploadPresenter(this);
        videoDes = "试试dasf";
        videoTitle = "试试就试试ads";
        courseId = "7";
        presenter.loadUploadAuth(videoTitle, videoDes, courseId);
    }

    private void initListener() {
        tvUpload.setOnClickListener(this);
    }

    private void initView() {
        tvUpload = (TextView) findViewById(R.id.tv_upload);
        etVideoTitle = (EditText) findViewById(R.id.et_video_title);
        etVideoDes = (EditText) findViewById(R.id.et_video_des);
        etCourseId = (EditText) findViewById(R.id.et_video_courseId);
    }

    @Override
    public void handlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_upload:
                preUploadVideoInfo();
                presenter.openSdCard();
                break;
        }
    }

    private void preUploadVideoInfo() {
        String title = etVideoTitle.getText().toString();
        if (!TextUtils.isEmpty(title)) {
            videoTitle = title;
        }
        String des = etVideoDes.getText().toString();
        if (!TextUtils.isEmpty(des)) {
            videoDes = des;
        }
        String id = etVideoDes.getText().toString();
        if (!TextUtils.isEmpty(id)) {
            courseId = id;
        }
    }

    private void initUpload(String path) {
        VODUploadCallback callback = new VODUploadCallback() {
            @Override
            public void onUploadSucceed(UploadFileInfo uploadFileInfo) {
                Log.e("log", "onUploadSucceed");
            }

            @Override
            public void onUploadFailed(UploadFileInfo uploadFileInfo, String s, String s1) {
                Log.e("log", "onUploadFailed");

            }

            @Override
            public void onUploadProgress(UploadFileInfo uploadFileInfo, long l, long l1) {
                Log.e("log", "onUploadProgress");
                Log.e("log", "l0 = " + l + "   l1= " + l1);
            }

            @Override
            public void onUploadTokenExpired() {
                uploader.resumeWithAuth(uploadAuth);
                Log.e("log", "onUploadTokenExpired");
            }

            @Override
            public void onUploadRetry(String s, String s1) {
                Log.e("log", "onUploadRetry");
            }

            @Override
            public void onUploadRetryResume() {
                Log.e("log", "onUploadRetryResume");
            }

            @Override
            public void onUploadStarted(UploadFileInfo uploadFileInfo) {

                Log.e("log", "onUploadStarted");
                uploader.setUploadAuthAndAddress(uploadFileInfo, uploadAuth, uploadAddress);
            }
        };
        uploader = new VODUploadClientImpl(this);
        uploader.init(callback);

        VodInfo vodInfo = new VodInfo();
        vodInfo.setTitle("testVideo");
        vodInfo.setDesc("描述.");
        vodInfo.setCateId(0);
        vodInfo.setIsProcess(true);
        vodInfo.setCoverUrl("http://www.taobao.com/" + 0 + ".jpg");
        List<String> tags = new ArrayList<>();
        tags.add("标签" + 0);
        vodInfo.setTags(tags);
        if (isVodMode()) {
            vodInfo.setIsShowWaterMark(false);
            vodInfo.setPriority(7);
        } else {
            vodInfo.setUserData("自定义数据" + 0);
            vodInfo.setUserData("就不告诉你");
        }

//        /data/local/tmp/android.video.video
//        path = Environment.getExternalStorageDirectory().getPath() + "/data/a.mp4";
        uploader.addFile(path, vodInfo);

//        uploader.addFile(path, vodInfo);

        UploadFileInfo uploadFileInfo = uploader.listFiles().get(0);
        uploader.setUploadAuthAndAddress(uploadFileInfo, uploadAuth, uploadAddress);
//        uploader.setUploadAuthAndAddress(uploadAuth, uploadAddress,s);
        uploader.start();
    }

    private boolean isVodMode() {
        return (null != uploadAuth && uploadAuth.length() > 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1) {
                Uri uri = data.getData();
                Toast.makeText(this, "文件路径：" + uri.getPath().toString(), Toast.LENGTH_SHORT).show();
                String path = "/storage/emulated/0/data/a.mp4";

                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                cursor.moveToFirst();
                String number = cursor.getString(0); // 视频编号
                path = cursor.getString(1); // 视频文件路径
                String name = cursor.getString(2); // 视频文件名
                String size = cursor.getString(3); // 视频大小
                String siz1e = cursor.getString(4); // 视频大小
                String wsiz1e = cursor.getString(5); // 视频大小
                initUpload(UriUtils.getPath(this, uri));
            }
        }
    }

    @Override
    public void onUploadAuth(VideoUploadAuthModel model) {
        requestId = model.getRequestId();
        uploadAddress = model.getUploadAddress();
        uploadAuth = model.getUploadAuth();
        videoId = model.getVideoId();
    }

    @Override
    public BasicPresenter getPresenter() {
        return presenter;
    }

    @Override
    public BasicActivity getBasicActivity() {
        return this;
    }

}
