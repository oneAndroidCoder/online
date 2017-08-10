package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/7/30.
 */

/**
 * "id": "133",
 * "tid": "61",
 * "nid": "47",
 * "title": " \tC++的应用",
 * "price": "0.00",
 * "cover": "2015-12-18/567374926ea05.png",
 * "number": "0",
 * "des": "新手入门，简单易懂",
 * "pid": "60",
 * "create_time": "2017-07-30 20:45:45",
 * "display_index": "0"
 */
public class CourseModel implements BasicModel {
    private String id;
    private String tid;
    private String nid;
    private String title;
    private String price;
    private String cover;
    private String number;
    private String des;
    private String pid;
    private String createTime;
    private String display_index;
    private String category_id;
    private String position;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDisplay_index() {
        return display_index;
    }

    public void setDisplay_index(String display_index) {
        this.display_index = display_index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
