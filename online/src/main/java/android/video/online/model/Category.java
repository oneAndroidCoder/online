package android.video.online.model;

import android.video.online.BasicModel;

import java.util.List;

/**
 * Created by Jay on 2017/8/5.
 */

/**
 * "category": [
 * {
 * "id": "6",
 * "name": "美甲",
 * "pid": "0",
 * "path": "0",
 * "status": "1",
 * "children": [
 * {
 * "id": "7",
 * "name": "甲1",
 * "pid": "6",
 * "path": "0-64",
 * "status": "1"
 * },
 * {
 * "id": "8",
 * "name": "甲1",
 * "pid": "6",
 * "path": "0-64",
 * "status": "1"
 * }
 * ]
 * },]
 */
public class Category implements BasicModel {
    private String id;
    private String name;
    private  String pid;
    private String path;
    private String status;
    private List<CategoryChildren> children;

    public List<CategoryChildren> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryChildren> children) {
        this.children = children;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
