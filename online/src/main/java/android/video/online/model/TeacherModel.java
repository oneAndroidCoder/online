package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/22.
 */

/**
 *
 "id": "45",
 "photo": "2015-12-18/56736e6d00000.png",
 "tname": "肖扬",
 "organ": "兄弟连",
 "description": "德育教人"
 */
public class TeacherModel implements BasicModel {
    private String id;
    private String photo;
    private String tname;
    private String organ;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
