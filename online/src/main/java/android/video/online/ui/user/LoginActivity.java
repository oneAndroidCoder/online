package android.video.online.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.core.BasicPresenter;
import android.video.online.model.QLoginModel;
import android.video.online.other.QLoginHelper;
import android.video.online.other.SimpleQLoginListener;
import android.video.online.ui.home.HomeActivity;
import android.video.online.utils.CommonUtils;
import android.video.online.widget.LoadingView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jay on 2017/7/24.
 */

public class LoginActivity extends BasicActivity implements LoginContract.View, View.OnClickListener {

    private EditText etAccount, etPassword;
    private TextView tvGotoRegister, tvGotoLogin;
    private View tvQLogin;
    private LoadingView mLoadingView;

    private LoginContract.Presenter presenter;
    private SimpleQLoginListener qLoginListener;

    @Override
    public int setLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {
        initData();
        initView();
        initListener();
    }

    private void initListener() {

        tvGotoRegister.setOnClickListener(this);

        tvQLogin.setOnClickListener(this);
        tvGotoLogin.setOnClickListener(this);

        qLoginListener = new SimpleQLoginListener() {
            @Override
            public void onComplete(QLoginModel model) {
                showToast(model.toString());
                Log.e("err", model.toString());
                presenter.gotoLoginToQQ(mLoadingView, CommonUtils.getDeviceId(LoginActivity.this), model.getOpenid(), "", "");
            }

            @Override
            public void onCancel() {
                super.onCancel();
                showToast("onCancel");
                Log.e("err", "onCancel");
            }

            @Override
            public void onError(String err) {
                super.onError(err);
                showToast(err.toString());
                Log.e("err", err);
            }
        };
    }

    private void initView() {
        etAccount = (EditText) findViewById(R.id.et_account);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvGotoRegister = (TextView) findViewById(R.id.tv_goto_register);
        tvGotoLogin = (TextView) findViewById(R.id.tv_goto_login);
        tvQLogin = findViewById(R.id.tv_q_login);
        mLoadingView = (LoadingView) findViewById(R.id.ld_loading);
        mLoadingView.dismiss();
    }

    private void initData() {
        presenter = new LoginPresenter(this);
        presenter.autoLogin();
    }

    @Override
    public void handlerMessage(Message msg) {

    }

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void jumpRegisterPage() {
        startActivity(this, RegisterActivity.class);
    }

    @Override
    public void loginSuccess(String result) {
        startActivity(this, HomeActivity.class);
        finish();
    }

    @Override
    public void loginFail(String fail) {
        if (TextUtils.isEmpty(fail)) {
            fail = "登陆失败";
        }
        showToast(fail);
    }

    @Override
    public BasicPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_q_login:
                presenter.gotoQLogin(LoginActivity.this, LoginActivity.this.getApplicationContext(), qLoginListener);
                break;
            case R.id.tv_goto_login:
                presenter.gotoLogin(etAccount.getText().toString(), etPassword.getText().toString());
                break;
            case R.id.tv_goto_register:
                presenter.gotoRegisterPage();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QLoginHelper.getInstance().onActivityResult(requestCode, resultCode, data);
    }
}
