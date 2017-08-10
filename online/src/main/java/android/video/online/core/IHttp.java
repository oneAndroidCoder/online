package android.video.online.core;

import android.video.online.widget.LoadingView;

import java.util.Map;

/**
 * Created by Jay on 2017/7/21.
 */

public interface IHttp {
    void sendGet(LoadingView loadingView, String url, HttpCallback httpCallback);

    void sendPost(LoadingView loadingView, String url, Map<String, String> map, HttpCallback httpCallback);
}
