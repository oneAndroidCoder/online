package android.video.online.core;

import android.support.annotation.NonNull;
import android.video.online.widget.LoadingView;

import java.util.Map;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Jay on 2017/7/21.
 */

public class BasicHttp implements IHttp {

    private OkHttpClient client;

    private static BasicHttp http = new BasicHttp();

    private BasicHttp() {
        init();
    }

    public static BasicHttp getBasicHttp() {
        return http;
    }

    @Override
    public void sendGet(LoadingView loadingView, String url, final HttpCallback httpCallback) {
        if (loadingView != null) {
            loadingView.show();
            httpCallback.setLoadingView(loadingView);
        }
        final Request request = new Request.Builder().get().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(httpCallback);
    }

    @NonNull
    private void init() {
        client = new OkHttpClient();
    }

    @Override
    public void sendPost(LoadingView loadingView, String url, Map<String, String> map, final HttpCallback httpCallback) {
        if (loadingView != null) {
            loadingView.show();
            httpCallback.setLoadingView(loadingView);
        }
        MediaType type = MediaType.parse("text/json; charset=utf-8");
        FormBody.Builder builder = new FormBody.Builder();

        if (map != null && map.size() > 0) {
            for (String key : map.keySet()) {
                builder.add(key, map.get(key));
            }
        }
        if (AppController.BIS_DEBUG) {
            builder.add("ret_format", "json");
        }
        Request request = new Request.Builder().post(builder.build()).url(url).build();
        Call call = client.newCall(request);
        call.enqueue(httpCallback);
    }
}
