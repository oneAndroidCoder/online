package android.video.online.ui.home;

import android.os.Message;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.manager.FragmentManager;

public class HomeActivity extends BasicActivity {

    private HomeFragment homeFragment;

    @Override
    public int setLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void init() {
        homeFragment = new HomeFragment();
        FragmentManager.getInstance(this).show(R.id.fl_content, homeFragment);
    }

    @Override
    public void handlerMessage(Message msg) {

    }

    public static void start(BasicActivity activity) {
        activity.startActivity(activity, HomeActivity.class);
    }
}
