package android.video.online.manager;

import android.support.v4.app.FragmentTransaction;
import android.video.online.BasicActivity;
import android.video.online.BasicFragment;

/**
 * Created by Jay on 2017/8/6.
 */

public class FragmentManager {
    private static FragmentManager instance = new FragmentManager();
    private static android.support.v4.app.FragmentManager supportFragmentManager;

    private FragmentManager() {
    }

    public static FragmentManager getInstance(BasicActivity activity) {
        supportFragmentManager = activity.getSupportFragmentManager();
        return instance;
    }

    public void show(int content, BasicFragment fragment) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(content, fragment);
        transaction.commit();
        transaction.show(fragment);
    }

    public void replace(int content, BasicFragment fragment) {
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.replace(content, fragment);
        transaction.commit();
        transaction.show(fragment);
    }
}
