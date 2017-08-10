package android.video.online.core;

/**
 * Created by Jay on 2017/7/21.
 */

public class HttpUrl {
    private static final String BasicUrl = "http://api.21mmm.com/";
    public static final String LOAD_SPLASH_AD = "xuexi/load_splash_ad";
    public static final String LOAD_HOME_DATA = "";

    /******             user            *************/
    public static final String GOTO_REGISTER = "public/handerRegister";
    public static final String GOTO_LOGIN = "public/handerLogin";

    /*******            course          ***********/
    public static final String COURSE_LISTS = "Course/lists";

    /*******            video             **********/
    public static final String VIDEO_LIST = "Course/index/";
    public static final String VIDEO_SHOW = "video/show/";
    public static final String VIDEO_UPLOAD = "vod/create_upload_video";

    /*******            pay                **********/
    public static final String PAY_CREATE_ORDERINFO = "order/create";
    public static final String ORDER_QUERY    = "order/queryOrder/order_no/";

    /*******            shopping              ***********/
    public static final String SHOPPING_CART_SAVE = "shoppingCart/save/";

    public static final String LOAD_HOME_NEWS = "xuexi/load_home_data";
    public static final String LOAD_HOME_ADS  = "xuexi/load_home_ads";

    public static String createUrl(String url) {
        return (AppController.BIS_DEBUG ? "http://www.21mmm.com/" : BasicUrl) + url + "?ret_format=json&";
    }

    public static String createUserUrl(String url){
        return (AppController.BIS_DEBUG ? "http://u.21mmm.com/" : BasicUrl) + url + "?ret_format=json&";
    }
}
