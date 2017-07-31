package android.video.online;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Jay on 2017/7/21.
 */
public abstract class BasicActivity extends AppCompatActivity implements IBasicActivity {

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            handlerMessage(msg);
        }
    };

    protected ImageLoader imageLoader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(this);
        imageLoader.init(config);
        init();
    }

    public abstract int setLayoutId();

    public abstract void init();

    public void startActivity(Context context, Class clazz) {
        startActivity(context, new Intent(context, clazz));
    }

    public void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }

    public void showToast(String adUrl) {
        showToast(adUrl, Toast.LENGTH_SHORT);
    }

    public void showToast(String adUrl, int lengthShort) {
        Toast.makeText(this, adUrl, lengthShort).show();
    }

    public abstract void handlerMessage(Message msg);

    public Handler getHandler() {
        return handler;
    }

    @Override
    public ImageLoader getImageLoader() {
        return imageLoader;
    }
}
