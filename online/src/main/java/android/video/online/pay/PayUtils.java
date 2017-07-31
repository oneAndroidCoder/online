package android.video.online.pay;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.alipay.sdk.app.PayTask;

import java.util.Map;

/**
 * Created by Jay on 2017/7/26.
 */

public class PayUtils {

    public static final int PAY_FINISH = 1099;
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private static PayUtils instance;

    private PayUtils() {
        init();
    }

    private void init() {

    }

    public static PayUtils getInstance() {
        if (null == instance) {
            synchronized (PayUtils.class) {
                if (null == instance) {
                    instance = new PayUtils();
                }
            }
        }
        return instance;
    }

    public void gotoPay(final Activity activity, final String orderInfo, final Callback callback) {

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                Log.e("pay_stutas1", Thread.currentThread().getName());
                PayTask alipay = new PayTask(activity);
                final Map result = alipay.payV2(orderInfo, true);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("pay_stutas2", Thread.currentThread().getName());
                        callback.callback(result);
                    }
                });
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    public interface Callback {
        void callback(Map result);
    }

}
