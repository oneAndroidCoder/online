package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/22.
 */

/**
 * "id": "11",
 * "title": "和秋叶一起学职场技能",
 * "content": "       和秋叶一起学职场技能",
 * "ntime": "1450537862"
 */
public class NewsModel implements BasicModel {
    private String id;
    private String title;
    private String content;
    private String ntime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNtime() {
        return ntime;
    }

    public void setNtime(String ntime) {
        this.ntime = ntime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
