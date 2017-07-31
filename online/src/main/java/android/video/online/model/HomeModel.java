package android.video.online.model;

import android.video.online.BasicModel;

import java.util.List;

/**
 * Created by Jay on 2017/7/24.
 */

public class HomeModel implements BasicModel {

    List<TypeModel> types;
    List<TeacherModel> teachers;
    List<OrganModel> organs;
    List<VideoModel> free;
    List<VideoModel> hot;
    List<VideoModel> videos;
    List<AdModel> advs;
    List<NewsModel> news;

    public List<TypeModel> getTypes() {
        return types;
    }

    public void setTypes(List<TypeModel> types) {
        this.types = types;
    }

    public List<AdModel> getAdvs() {
        return advs;
    }

    public void setAdvs(List<AdModel> advs) {
        this.advs = advs;
    }

    public List<VideoModel> getFree() {
        return free;
    }

    public void setFree(List<VideoModel> free) {
        this.free = free;
    }

    public List<VideoModel> getHot() {
        return hot;
    }

    public void setHot(List<VideoModel> hot) {
        this.hot = hot;
    }

    public List<NewsModel> getNews() {
        return news;
    }

    public void setNews(List<NewsModel> news) {
        this.news = news;
    }

    public List<OrganModel> getOrgans() {
        return organs;
    }

    public void setOrgans(List<OrganModel> organs) {
        this.organs = organs;
    }

    public List<TeacherModel> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherModel> teachers) {
        this.teachers = teachers;
    }

    public List<VideoModel> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoModel> videos) {
        this.videos = videos;
    }
}
