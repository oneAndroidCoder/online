package android.video.online.ui.home;

import android.os.Message;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.manager.FragmentManager;
import android.video.online.ui.user.UserCenterFragment;
import android.view.View;

public class HomeActivity extends BasicActivity implements View.OnClickListener {

    private HomeFragment homeFragment;
    private UserCenterFragment userCenterFragment;

    @Override
    public int setLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void init() {
        homeFragment = new HomeFragment();
        userCenterFragment = new UserCenterFragment();
        FragmentManager.getInstance(this).show(R.id.fl_content, homeFragment);
        initListener();
    }

    private void initListener() {
        findViewById(R.id.btn_video).setOnClickListener(this);
        findViewById(R.id.btn_home).setOnClickListener(this);
        findViewById(R.id.btn_me).setOnClickListener(this);
    }

    @Override
    public void handlerMessage(Message msg) {

    }

    public static void start(BasicActivity activity) {
        activity.startActivity(activity, HomeActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_home:
                FragmentManager.getInstance(this).replace(R.id.fl_content, homeFragment);
                break;
            case R.id.btn_video:
                showToast("目前没有特殊资源哦，请等待。。。");
                break;
            case R.id.btn_me:
                FragmentManager.getInstance(this).replace(R.id.fl_content, userCenterFragment);
                break;
        }

    }
}
