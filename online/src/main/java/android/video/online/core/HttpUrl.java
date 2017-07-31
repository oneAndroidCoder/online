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
    public static final String COURSE_LEARN = "Course/course_learn/id/";

    /*******            video             **********/
    public static final String VIDEO_LIST = "Course/index/id/";

    /*******            pay                **********/
    public static final String PAY_CREATE_ORDERINFO = "order/create";

    public static final String LOAD_HOME_NEWS = "xuexi/load_home_data";
    public static final String LOAD_HOME_ADS = "xuexi/load_home_ads";
    public static String createUrl(String url) {
        return (AppController.BIS_DEBUG ? "http://www.21mmm.com/" : BasicUrl) + url + "?ret_format=json";
    }

    public static String createUserUrl(String url){
        return (AppController.BIS_DEBUG ? "http://u.21mmm.com/" : BasicUrl) + url + "?ret_format=json";
    }
}
