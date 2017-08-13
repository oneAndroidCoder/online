package android.video.online.model;

import android.video.online.BasicModel;

/**
 * Created by Jay on 2017/8/13.
 */

public class UserBindModel implements BasicModel {
    private String  id;
    private String  user_id;
    private String  device_id;
    private String  mobile;
    private String  password;
    private String  status;
    private String  level;
    private String  qq_open_id;
    private String  wx_open_id;
    private String  wb_open_id;
    private String  domain;
    private String  vpn_username;
    private String  vpn_passwrod;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQq_open_id() {
        return qq_open_id;
    }

    public void setQq_open_id(String qq_open_id) {
        this.qq_open_id = qq_open_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVpn_passwrod() {
        return vpn_passwrod;
    }

    public void setVpn_passwrod(String vpn_passwrod) {
        this.vpn_passwrod = vpn_passwrod;
    }

    public String getVpn_username() {
        return vpn_username;
    }

    public void setVpn_username(String vpn_username) {
        this.vpn_username = vpn_username;
    }

    public String getWb_open_id() {
        return wb_open_id;
    }

    public void setWb_open_id(String wb_open_id) {
        this.wb_open_id = wb_open_id;
    }

    public String getWx_open_id() {
        return wx_open_id;
    }

    public void setWx_open_id(String wx_open_id) {
        this.wx_open_id = wx_open_id;
    }
}
