package android.video.online;

import android.content.Context;
import android.support.v4.view.PagerAdapter;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Jay on 2017/7/22.
 */

public abstract class BasicAdapterVp extends PagerAdapter {
    protected ImageLoader imageLoader;
    protected Context context;

    public BasicAdapterVp(Context context) {
        imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(context);
        imageLoader.init(config);
    }
}
