package android.video.online.model;

import android.video.online.BasicModel;

import java.util.List;

/**
 * Created by Jay on 2017/7/30.
 */

public class CourseDataModel implements BasicModel {
    private ConfigModel configs;
    private List<VideoModel> videos;
    private TeacherModel teachers;
    private CourseModel course;

    public ConfigModel getConfigs() {
        return configs;
    }

    public void setConfigs(ConfigModel configs) {
        this.configs = configs;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    public TeacherModel getTeachers() {
        return teachers;
    }

    public void setTeachers(TeacherModel teachers) {
        this.teachers = teachers;
    }

    public List<VideoModel> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoModel> videos) {
        this.videos = videos;
    }
}
