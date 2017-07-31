package android.video.online.ui.user;

import android.content.Intent;
import android.os.Message;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.core.BasicPresenter;
import android.video.online.ui.home.HomeActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends BasicActivity implements RegisterContract.View {

    private EditText etAccount, etPassword, etPassword2;
    private TextView tvGotoRegister, tvGotoLogin;

    private RegisterContract.Presenter presenter;

    @Override
    public int setLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void init() {
        initData();
        initView();
        initListener();
    }

    @Override
    public void handlerMessage(Message msg) {

    }

    private void initData() {
        presenter = new RegisterPresenter(this);
    }

    private void initListener() {
        tvGotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.gotoRegister(etAccount.getText().toString(), etPassword.getText().toString(), etPassword2.getText().toString());
            }
        });

        tvGotoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.gotoLoginPage();
            }
        });
    }

    private void initView() {
        etAccount = (EditText) findViewById(R.id.et_account);
        etPassword = (EditText) findViewById(R.id.et_password);
        etPassword2 = (EditText) findViewById(R.id.et_password2);
        tvGotoRegister = (TextView) findViewById(R.id.tv_goto_register);
        tvGotoLogin = (TextView) findViewById(R.id.tv_goto_login);
    }

    public static void start(BasicActivity activity) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(activity, intent);
    }

    @Override
    public void registerSuccess() {
        showToast("注册成功");
        HomeActivity.start(RegisterActivity.this);
    }

    @Override
    public void registerFail(String msg) {
        showToast("注册失败");
    }

    @Override
    public void jumpLoginPage() {
        startActivity(this, LoginActivity.class);
    }

    @Override
    public BasicPresenter getPresenter() {
        return presenter;
    }
}
