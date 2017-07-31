package android.video.online;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Jay on 2017/7/22.
 */

public interface IBasicActivity {
    void handlerMessage(Message msg);

    int setLayoutId();

    void init();

    void startActivity(Context context, Class clazz);

    void startActivity(Context context, Intent intent);

    void showToast(String adUrl);

    void showToast(String adUrl, int lengthShort);

    ImageLoader getImageLoader();

    Handler getHandler();
}
