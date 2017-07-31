package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/25.
 */

/**
 * "CoverURL": "http://v1.rrbrr.com/snapshot/5c7dd83d68a34d4a8a92ce74091f5f8b00001.jpg",
 * "Status": "Normal",
 * "VideoId": "5c7dd83d68a34d4a8a92ce74091f5f8b",
 * "Duration": 70.06999969482422,
 * "Title": "aaa"
 */

public class VideoMetaModel implements BasicModel {
    private String CoverUrl;
    private String Status;
    private String VideoId;
    private String Duration;
    private String Title;

    public String getCoverUrl() {
        return CoverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        CoverUrl = coverUrl;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getVideoId() {
        return VideoId;
    }

    public void setVideoId(String videoId) {
        VideoId = videoId;
    }
}
