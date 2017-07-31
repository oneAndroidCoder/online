package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/25.
 */

/**
 *
 "id": "97",
 "vid": "187",
 "title": "aaa",
 "description": "aaa",
 "url": "",
 "tid": "0",
 "time": "2017-07-22 20:05:12",
 "course_id": "5c7dd83d68a34d4a8a92ce74091f5f8b",
 "user_id": "0"
 */

public class VideoVoModel implements BasicModel {
    private String id;
    private String vid;
    private String title;
    private String description;
    private String url;
    private String getId;
    private String time;
    private String course_id;
    private String user_id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGetId() {
        return getId;
    }

    public void setGetId(String getId) {
        this.getId = getId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
