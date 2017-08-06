package android.video.online.model;

import android.video.online.BasicModel;

import java.util.List;

/**
 * Created by Jay on 2017/8/5.
 */

/**
 * "id": "7",
 * "name": "meijia",
 * "title": "美甲",
 * "pid": "0",
 * "sort": "0",
 * "list_row": "10",
 * "meta_title": "",
 * "keywords": "",
 * "description": "",
 * "template_index": "",
 * "template_lists": "",
 * "template_detail": "",
 * "template_edit": "",
 * "model": "",
 * "model_sub": "",
 * "type": "",
 * "link_id": "0",
 * "allow_publish": "0",
 * "display": "0",
 * "reply": "0",
 * "check": "0",
 * "reply_model": "",
 * "extend": null,
 * "create_time": "0",
 * "update_time": "0",
 * "status": "1",
 * "icon": "0",
 * "groups": "",
 */
public class Category implements BasicModel {
    private String id;
    private String name;
    private String title;
    private String pid;
    private String sort;
    private String list_row;
    private String meta_title;
    private String keywords;
    private String description;
    private String template_index;
    private String template_lists;
    private String template_detail;
    private String template_edit;
    private String model;
    private String model_sub;
    private String type;
    private String link_id;
    private String allow_publish;
    private String display;
    private String reply;
    private String check;
    private String reply_model;
    private String extend;
    private String create_time;
    private String update_time;
    private String status;
    private String icon;
    private String groups;
    private List<Category> children;

    public String getAllow_publish() {
        return allow_publish;
    }

    public void setAllow_publish(String allow_publish) {
        this.allow_publish = allow_publish;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLink_id() {
        return link_id;
    }

    public void setLink_id(String link_id) {
        this.link_id = link_id;
    }

    public String getList_row() {
        return list_row;
    }

    public void setList_row(String list_row) {
        this.list_row = list_row;
    }

    public String getMeta_title() {
        return meta_title;
    }

    public void setMeta_title(String meta_title) {
        this.meta_title = meta_title;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel_sub() {
        return model_sub;
    }

    public void setModel_sub(String model_sub) {
        this.model_sub = model_sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getReply_model() {
        return reply_model;
    }

    public void setReply_model(String reply_model) {
        this.reply_model = reply_model;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTemplate_detail() {
        return template_detail;
    }

    public void setTemplate_detail(String template_detail) {
        this.template_detail = template_detail;
    }

    public String getTemplate_edit() {
        return template_edit;
    }

    public void setTemplate_edit(String template_edit) {
        this.template_edit = template_edit;
    }

    public String getTemplate_index() {
        return template_index;
    }

    public void setTemplate_index(String template_index) {
        this.template_index = template_index;
    }

    public String getTemplate_lists() {
        return template_lists;
    }

    public void setTemplate_lists(String template_lists) {
        this.template_lists = template_lists;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
