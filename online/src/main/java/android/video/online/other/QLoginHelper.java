package android.video.online.other;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.video.online.core.Constants;
import android.video.online.model.QLoginModel;

import com.alibaba.fastjson.JSON;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

/**
 * Created by Jay on 2017/8/12.
 */

public class QLoginHelper {
    private static QLoginHelper instance = new QLoginHelper();
    private Tencent tencent;
    private IUiListener listener;
    private SimpleQLoginListener onLoginListener;
    private Context context;

    public SimpleQLoginListener getOnLoginListener() {
        return onLoginListener;
    }

    public void setOnLoginListener(SimpleQLoginListener onLoginListener) {
        this.onLoginListener = onLoginListener;
    }

    public static QLoginHelper getInstance() {
        return instance;
    }

    private QLoginHelper() {
    }

    public void init(Context context, SimpleQLoginListener simpleQLoginListener) {
        this.onLoginListener = simpleQLoginListener;
        this.context = context;
        listener = new IUiListener() {
            @Override
            public void onComplete(Object o) {
                QLoginModel model = JSON.parseObject(o.toString(), QLoginModel.class);
                onLoginListener.onComplete(model);
            }

            @Override
            public void onError(UiError uiError) {
                onLoginListener.onError(uiError.errorMessage);
            }

            @Override
            public void onCancel() {
                onLoginListener.onCancel();
            }
        };
        tencent = Tencent.createInstance(Constants.QQ_APP_ID, context);
    }

    public void login(Activity activity) {
        if (!tencent.isSessionValid()) {
            tencent.login(activity, "all", listener);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        tencent.handleLoginData(data, listener);
    }

    public interface QLoginListener {
        void onComplete(QLoginModel model);

        void onError(String err);

        void onCancel();
    }
}
