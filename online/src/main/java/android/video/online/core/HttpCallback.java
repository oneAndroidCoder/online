package android.video.online.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.video.online.widget.LoadingView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Jay on 2017/7/21.
 */

public abstract class HttpCallback implements Callback {
    Handler handler = new Handler(Looper.getMainLooper());
    private LoadingView loadingView;

    public void setLoadingView(LoadingView loadingView) {
        this.loadingView = loadingView;
    }

    @Override
    public void onFailure(final Call call, final IOException e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (loadingView != null) {
                    loadingView.setStatus(LoadingView.STATUS_LOADING_FAILED);
                }
                onFail(call);
            }
        });
    }

    protected abstract void onFail(Call call, final Object... objects);

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {
        try {
            Log.e("outThread", Thread.currentThread().getName());
            final String result = response.body().string();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Log.e("onThread", Thread.currentThread().getName());
                    if (loadingView != null) {
                        loadingView.setStatus(LoadingView.STATUS_LOADING_SUCCESS);
                    }
                    onSuccess(call, response, result);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            onSuccess(call, response, "");
        }

    }

    protected abstract void onSuccess(Call call, Response response, String result, final Object... objects);

}
