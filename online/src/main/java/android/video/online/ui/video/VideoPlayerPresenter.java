package android.video.online.ui.video;

import android.util.Log;
import android.video.online.core.BasicView;
import android.video.online.core.HttpCallback;
import android.video.online.http.ServiceManager;
import android.video.online.model.VideoPlayerModel;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Jay on 2017/7/25.
 */

public class VideoPlayerPresenter implements VideoPlayerContract.Presenter {
    private VideoPlayerContract.View view;

    public VideoPlayerPresenter(VideoPlayerContract.View view) {
        this.view = view;
    }

    @Override
    public BasicView getView() {
        return view;
    }

    @Override
    public void loadVideoDetail(String videoId) {
        ServiceManager.getInstance().loadVideoShow(null, videoId, new HttpCallback() {
            @Override
            protected void onFail(Call call, Object... objects) {
                Log.e("error", call.toString());
            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                try {
                    if (response.isSuccessful()) {
                        JSONObject resultJson = new JSONObject(result);
                        if (resultJson.optString("code").equals("1")) {
                            VideoPlayerModel data = JSON.parseObject(resultJson.optString("data"), VideoPlayerModel.class);
                            view.todoShowVideoView(data);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
