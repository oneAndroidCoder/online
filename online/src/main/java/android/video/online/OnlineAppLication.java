package android.video.online;

import android.app.Application;
import android.content.Context;

/**
 * Created by Jay on 2017/7/30.
 */

public class OnlineAppLication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {

        return context;
    }
}
