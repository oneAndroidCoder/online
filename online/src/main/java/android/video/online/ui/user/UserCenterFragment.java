package android.video.online.ui.user;

import android.video.online.BasicActivity;
import android.video.online.BasicFragment;
import android.video.online.R;
import android.video.online.core.BasicPresenter;
import android.video.online.manager.UserManager;
import android.view.View;
import android.widget.TextView;

/**
 *
 */
public class UserCenterFragment extends BasicFragment implements View.OnClickListener, UserCenterContract.View {
    private TextView tvUserDisplayName;
    private TextView tvLogout;
    private TextView tvClazzManage;
    private TextView tvVideoManage;
    private TextView tvOwnerClazz;
    private TextView tvMyOrder;
    private TextView tvMyCar;
    private TextView tvMyComment;
    private TextView tvMyScore;

    private UserCenterContract.Presenter presenter;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_user_center;
    }

    @Override
    public void init() {
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        tvLogout.setOnClickListener(this);
        tvClazzManage.setOnClickListener(this);
        tvVideoManage.setOnClickListener(this);
        tvOwnerClazz.setOnClickListener(this);
        tvMyOrder.setOnClickListener(this);
        tvMyCar.setOnClickListener(this);
        tvMyComment.setOnClickListener(this);
        tvMyScore.setOnClickListener(this);
    }

    private void initData() {
        tvUserDisplayName.setText(UserManager.getInstance().getUserModel().getUsername());
        presenter = new UserCenterPresenter(this);
    }

    private void initView() {
        tvUserDisplayName = (TextView) parentLayout.findViewById(R.id.tv_user_display_name);
        tvLogout = (TextView) parentLayout.findViewById(R.id.tv_logout);
        tvClazzManage = (TextView) parentLayout.findViewById(R.id.tv_clazz_manage);
        tvVideoManage = (TextView) parentLayout.findViewById(R.id.tv_video_manage);
        tvOwnerClazz = (TextView) parentLayout.findViewById(R.id.tv_owner_clazz);
        tvMyOrder = (TextView) parentLayout.findViewById(R.id.tv_my_order);
        tvMyCar = (TextView) parentLayout.findViewById(R.id.tv_my_car);
        tvMyComment = (TextView) parentLayout.findViewById(R.id.tv_my_comment);
        tvMyScore = (TextView) parentLayout.findViewById(R.id.tv_my_score);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_logout:
                presenter.logout();

                break;
            case R.id.tv_clazz_manage:
                break;
            case R.id.tv_video_manage:
                break;
            case R.id.tv_owner_clazz:
                break;
            case R.id.tv_my_order:
                break;
            case R.id.tv_my_car:
                break;
            case R.id.tv_my_comment:
                break;
            case R.id.tv_my_score:
                break;
        }
    }

    @Override
    public BasicPresenter getPresenter() {
        return presenter;
    }

    @Override
    public BasicActivity getBasicActivity() {
        return activity;
    }
}