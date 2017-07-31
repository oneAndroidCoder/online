package android.video.online.core;

import java.util.Map;

/**
 * Created by Jay on 2017/7/21.
 */

public interface IHttp {
    void sendGet(String url, HttpCallback httpCallback);

    void sendPost(String url, Map<String, String> map, HttpCallback httpCallback);
}
