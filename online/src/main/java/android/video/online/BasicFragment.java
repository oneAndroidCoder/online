package android.video.online;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Jay on 2017/7/22.
 */
public abstract class BasicFragment extends Fragment implements IBasicActivity {

    protected BasicActivity activity;
    protected View parentLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (BasicActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentLayout = inflater.inflate(setLayoutId(), null);
        return parentLayout;
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }

    @Override
    public void startActivity(Context context, Class clazz) {
        activity.startActivity(context, clazz);
    }

    @Override
    public void startActivity(Context context, Intent intent) {
        activity.startActivity(context, intent);
    }

    @Override
    public void showToast(String adUrl) {
        activity.showToast(adUrl);
    }

    @Override
    public void showToast(String adUrl, int lengthShort) {
        activity.showToast(adUrl, lengthShort);
    }

    @Override
    public void handlerMessage(Message msg) {
        activity.handlerMessage(msg);
    }

    @Override
    public ImageLoader getImageLoader() {
        return activity.getImageLoader();
    }

    @Override
    public Handler getHandler() {
        return activity.getHandler();
    }
}
