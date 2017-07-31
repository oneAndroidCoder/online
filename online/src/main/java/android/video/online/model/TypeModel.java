package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/22.
 */

/**
 *
 "id": "60",
 "name": "IT互联网",
 "pid": "0",
 "path": "0"
 */
public class TypeModel implements BasicModel {
    private String id;
    private String name;
    private String pid;
    private String path;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
