package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/8/6.
 */

public class VideoUploadAuthModel implements BasicModel {
    private String UploadAddress;
    private String VideoId;
    private String RequestId;
    private String UploadAuth;

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public String getUploadAddress() {
        return UploadAddress;
    }

    public void setUploadAddress(String uploadAddress) {
        UploadAddress = uploadAddress;
    }

    public String getUploadAuth() {
        return UploadAuth;
    }

    public void setUploadAuth(String uploadAuth) {
        UploadAuth = uploadAuth;
    }

    public String getVideoId() {
        return VideoId;
    }

    public void setVideoId(String videoId) {
        VideoId = videoId;
    }
}
