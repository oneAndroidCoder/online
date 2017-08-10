package android.video.online.ui.splash;

import android.video.online.core.BasicView;
import android.video.online.core.HttpCallback;
import android.video.online.http.ServiceManager;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Jay on 2017/7/21.
 */

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View view;

    public SplashPresenter(SplashContract.View view) {
        this.view = view;
    }

    @Override
    public BasicView getView() {
        return view;
    }

    @Override
    public void initAd() {
        ServiceManager.getInstance().loadSplashAd(null, new HttpCallback() {

            @Override
            protected void onFail(Call call, Object... objects) {
                view.initAdView("http://img1.ph.126.net/iVUAqc-tPcFeF7RVmLoALQ==/2165949945888629440.gif");
            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                if (response.isSuccessful()) {
                    view.initAdView("http://img.zcool.cn/community/01ddeb5542e7de0000019ae958da1c.jpg");
                } else {
                    view.initAdView("http://img4.imgtn.bdimg.com/it/u=1475813433,3559561004&fm=214&gp=0.jpg");
                }
            }
        });
    }

    public void enterHome() {
        view.enterHome();
    }
}
