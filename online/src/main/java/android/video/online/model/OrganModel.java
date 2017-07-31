package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/22.
 */

/**
 *
 "id": "23",
 "organ": "",
 "url": "study/admin.php/Organ/index.html",
 "name": "河南",
 "description": "         教育基地"
 */
public class OrganModel implements BasicModel {
    private String id;
    private String organ;
    private String url;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
