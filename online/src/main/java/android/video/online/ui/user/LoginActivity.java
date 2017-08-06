package android.video.online.ui.user;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.core.BasicPresenter;
import android.video.online.ui.home.HomeActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jay on 2017/7/24.
 */

public class LoginActivity extends BasicActivity implements LoginContract.View {

    private EditText etAccount, etPassword;
    private TextView tvGotoRegister, tvGotoLogin;

    private LoginContract.Presenter presenter;

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

        tvGotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.gotoRegisterPage();
            }
        });

        tvGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.gotoLogin(etAccount.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    private void initView() {
        etAccount = (EditText) findViewById(R.id.et_account);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvGotoRegister = (TextView) findViewById(R.id.tv_goto_register);
        tvGotoLogin = (TextView) findViewById(R.id.tv_goto_login);
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
}
