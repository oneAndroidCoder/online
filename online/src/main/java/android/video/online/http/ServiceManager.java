package android.video.online.http;

import android.video.online.core.BasicHttp;
import android.video.online.core.HttpCallback;
import android.video.online.core.HttpUrl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jay on 2017/7/21.
 */

public class ServiceManager {
    private static ServiceManager instance;
    private BasicHttp mHttp;

    private ServiceManager() {
        mHttp = BasicHttp.getBasicHttp();
    }

    public static ServiceManager getInstance() {
        if (instance == null) {
            synchronized (ServiceManager.class) {
                if (null == instance) {
                    instance = new ServiceManager();
                }
            }
        }
        return instance;
    }

    public void loadSplashAd(HttpCallback httpCallback) {
        mHttp.sendGet(HttpUrl.createUrl(HttpUrl.LOAD_SPLASH_AD), httpCallback);
    }

    public void loadHomeData(HttpCallback httpCallback) {
        mHttp.sendGet(HttpUrl.createUrl(HttpUrl.LOAD_HOME_DATA), httpCallback);
    }

    public void gotoRegister(String username, String password, String repassword, HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("repassword", repassword);
        mHttp.sendPost(HttpUrl.createUserUrl(HttpUrl.GOTO_REGISTER), map, callback);
    }

    public void gotoLogin(String username, String password, HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        mHttp.sendPost(HttpUrl.createUserUrl(HttpUrl.GOTO_LOGIN), map, callback);
    }

    public void loadCourseLearn(String id, HttpCallback callback) {
        mHttp.sendGet(HttpUrl.createUrl(HttpUrl.COURSE_LEARN + id), callback);
    }

    public void createOrderInfo(String userId, String videoId, HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("course_id", videoId);
        map.put("user_id", userId);
        mHttp.sendPost(HttpUrl.createUserUrl(HttpUrl.PAY_CREATE_ORDERINFO), map, callback);
    }

    public void addShoppingCart(String course_id, String userId, HttpCallback callback) {
        Map<String, String> map = new HashMap<>();
        map.put("course_id", course_id);
        map.put("user_id", userId);
        mHttp.sendPost(HttpUrl.createUserUrl(HttpUrl.SHOPPING_CART_SAVE), map, callback);
    }

    public void loadVideoList(String id, HttpCallback callback) {
        mHttp.sendGet(HttpUrl.createUrl(HttpUrl.VIDEO_LIST + id), callback);
    }

    public void queryOrder(String order_no, HttpCallback callback) {
        mHttp.sendGet(HttpUrl.createUserUrl(HttpUrl.ORDER_QUERY + order_no), callback);
    }

    public void createUploadVideo(String videoTitle, String videoDes, String courseId, HttpCallback callback) {
        mHttp.sendGet(HttpUrl.createUserUrl(HttpUrl.VIDEO_UPLOAD) + "&title=" + videoTitle + "&description=" + videoDes + "&course_id=" + courseId, callback);
    }
}
