package android.video.online.ui.user;

import android.video.online.core.BasicView;
import android.video.online.manager.UserManager;

/**
 * Created by Jay on 2017/8/6.
 */

public class UserCenterPresenter implements UserCenterContract.Presenter {
    private UserCenterContract.View view;

    public UserCenterPresenter(UserCenterContract.View view) {
        this.view = view;
    }

    @Override
    public BasicView getView() {
        return view;
    }

    @Override
    public void logout() {
        UserManager.getInstance().removeCurrentUser();
        view.getBasicActivity().startActivity(view.getBasicActivity(), LoginActivity.class);
        view.getBasicActivity().finish();
    }
}
