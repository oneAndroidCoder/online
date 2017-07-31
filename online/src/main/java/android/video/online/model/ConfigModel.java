package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/22.
 */

/**
 * "title": "123",
 * "keywords": "123",
 * "description": "123",
 * "copyright": "123",
 * "logo": "2015-12-23/5679fc75b34a7.png",
 * "status": "1"
 */
public class ConfigModel implements BasicModel {
    private String id;
    private String title;
    private String keywords;
    private String description;
    private String copyRight;
    private String logo;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
