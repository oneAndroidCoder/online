package android.video.online.ui.splash;

import android.os.Message;
import android.text.TextUtils;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.core.AppController;
import android.video.online.core.BasicPresenter;
import android.video.online.gif.GifView;
import android.video.online.ui.home.HomeActivity;
import android.video.online.ui.user.LoginActivity;
import android.view.View;
import android.widget.ImageView;

public class SplashActivity extends BasicActivity implements View.OnClickListener, SplashContract.View {

    private GifView gifView;

    boolean flag = true;

    private SplashPresenter presenter;

    private ImageView iv_ad;

    @Override
    public int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void init() {
        iv_ad = (ImageView) findViewById(R.id.iv_ad);
        gifView = (GifView) findViewById(R.id.gv_splash);
        gifView.setGifImage(R.mipmap.gif);
        findViewById(R.id.tsxt).setOnClickListener(this);
        presenter = new SplashPresenter(this);
        presenter.initAd();
        presenter.enterHome();
    }

    @Override
    public void handlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {
        if (flag) {
            flag = false;
            gifView.showCover();
        } else {
            flag = true;
            gifView.showAnimation();
        }
    }

    @Override
    public BasicPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void initAdView(String adUrl) {
        showToast(adUrl);
        if (!TextUtils.isEmpty(adUrl)) {
//            imageLoader.loadImage(adUrl, new ImageLoadingListener() {
//                @Override
//                public void onLoadingStarted(String imageUri, View view) {
//
//                }
//
//                @Override
//                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
//
//                }
//
//                @Override
//                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    loadedImage.compress(Bitmap.CompressFormat.PNG, 100, baos);
//                    InputStream is = new ByteArrayInputStream(baos.toByteArray());
//                    iv_ad.setImageBitmap(loadedImage);
//                }
//
//                @Override
//                public void onLoadingCancelled(String imageUri, View view) {
//
//                }
//            });
            imageLoader.displayImage(adUrl, iv_ad);
        }
    }

    @Override
    public void enterHome() {
        getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(AppController.BIS_LOGIN) {
                    SplashActivity.this.startActivity(SplashActivity.this, HomeActivity.class);
                } else {
                    LoginActivity.start(SplashActivity.this);
                }
                finish();
            }
        }, 1000);
    }

}
