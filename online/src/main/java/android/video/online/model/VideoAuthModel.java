package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/25.
 */

/**
 * "RequestId": "54060E2A-1545-4A84-9E49-5E8E1FCD7897",
 * "VideoMeta": {
 * "CoverURL": "http://v1.rrbrr.com/snapshot/5c7dd83d68a34d4a8a92ce74091f5f8b00001.jpg",
 * "Status": "Normal",
 * "VideoId": "5c7dd83d68a34d4a8a92ce74091f5f8b",
 * "Duration": 70.06999969482422,
 * "Title": "aaa"
 * },
 * "PlayAuth": "...."
 */
public class VideoAuthModel implements BasicModel {
    private String RequestId;
    private VideoMetaModel VideoMeta;
    private String PlayAuth;

    public String getPlayAuth() {
        return PlayAuth;
    }

    public void setPlayAuth(String playAuth) {
        PlayAuth = playAuth;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }

    public VideoMetaModel getVideoMeta() {
        return VideoMeta;
    }

    public void setVideoMeta(VideoMetaModel videoMeta) {
        VideoMeta = videoMeta;
    }
}
