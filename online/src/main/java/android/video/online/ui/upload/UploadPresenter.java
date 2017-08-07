package android.video.online.ui.upload;

import android.content.Intent;
import android.util.Log;
import android.video.online.core.BasicView;
import android.video.online.core.HttpCallback;
import android.video.online.http.ServiceManager;
import android.video.online.model.VideoUploadAuthModel;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Jay on 2017/8/6.
 */

public class UploadPresenter implements UploadContract.Presenter {
    private UploadContract.View view;

    public UploadPresenter(UploadContract.View view) {
        this.view = view;
    }

    @Override
    public BasicView getView() {
        return view;
    }

    @Override
    public void openSdCard() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("video/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        view.getBasicActivity().startActivityForResult(intent, 1);
    }

    @Override
    public void loadUploadAuth(String videoTitle, String videoDes, String courseId) {
        ServiceManager.getInstance().createUploadVideo(videoTitle, videoDes, courseId, new HttpCallback() {
            @Override
            protected void onFail(Call call, Object... objects) {
                Log.e("result",call.toString());
            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                Log.e("result",result);
                if(response.isSuccessful()) {
                    try {
                        JSONObject resultObj = new JSONObject(result);
                        if(resultObj.optString("code").equals("1")){
                            VideoUploadAuthModel model = JSON.parseObject(resultObj.optString("data"), VideoUploadAuthModel.class);
                            view.onUploadAuth(model);
                        }else {

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
