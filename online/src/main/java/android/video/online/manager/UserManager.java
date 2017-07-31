package android.video.online.manager;

import android.text.TextUtils;
import android.video.online.OnlineAppLication;
import android.video.online.db.DatabaseAdapter;
import android.video.online.model.UserModel;
import android.video.online.utils.SPUtils;

/**
 * Created by Jay on 2017/7/29.
 */

public class UserManager {
    private static UserManager instance = new UserManager();
    private final String userId = "user_id";

    private UserManager() {

    }

    private UserModel userModel;

    public static UserManager getInstance() {
        return instance;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void saveUserModel(UserModel userModel) {
        this.userModel = userModel;
        SPUtils.saveData(OnlineAppLication.getContext(), userId, userModel.getUser_id());
        DatabaseAdapter databaseAdapter = new DatabaseAdapter(OnlineAppLication.getContext());
        UserModel userModelDb = databaseAdapter.findById(userModel.getUser_id());
        if (userModelDb != null && !TextUtils.isEmpty(userModelDb.getUser_id())) {
            databaseAdapter.update(userModel);
        } else {
            databaseAdapter.create(userModel);
        }
    }
}
