package android.video.online.model;

/**
 * Created by Jay on 2017/8/12.
 */

public class QLoginModel {
    private int rest;
    private String openid;
    private String access_token;
    private String pay_token;
    private String expires_in;
    private String pf;
    private String pfkey;
    private String msg;
    private String login_cost;
    private String query_authority_costd;
    private String authority_cost;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getAuthority_cost() {
        return authority_cost;
    }

    public void setAuthority_cost(String authority_cost) {
        this.authority_cost = authority_cost;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getLogin_cost() {
        return login_cost;
    }

    public void setLogin_cost(String login_cost) {
        this.login_cost = login_cost;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPay_token() {
        return pay_token;
    }

    public void setPay_token(String pay_token) {
        this.pay_token = pay_token;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getPfkey() {
        return pfkey;
    }

    public void setPfkey(String pfkey) {
        this.pfkey = pfkey;
    }

    public String getQuery_authority_costd() {
        return query_authority_costd;
    }

    public void setQuery_authority_costd(String query_authority_costd) {
        this.query_authority_costd = query_authority_costd;
    }

    public int getRest() {
        return rest;
    }

    public void setRest(int rest) {
        this.rest = rest;
    }
}
