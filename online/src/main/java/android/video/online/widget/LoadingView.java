package android.video.online.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.video.online.R;
import android.video.online.widget.listener.SimpleLoadingListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Jay on 2017/8/8.
 */

public class LoadingView extends FrameLayout {

    public static final int STATUS_LOADING = 0;
    public static final int STATUS_LOADING_SUCCESS = 1;
    public static final int STATUS_LOADING_FAILED = 2;
    public static final int STATUS_LOADING_TIMEOUT = 3;

    private int status = STATUS_LOADING;

    FrameLayout parentLayout;
    private RelativeLayout customLayout;
    private TextView tvLoadingStatus;

    LoadingListener loadingListener = new SimpleLoadingListener() {
    };

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.widget_loading, null);
        parentLayout = (FrameLayout) view.findViewById(R.id.parent_layout);
        customLayout = (RelativeLayout) view.findViewById(R.id.null_view);
        tvLoadingStatus = (TextView) view.findViewById(R.id.tv_loading_status);
        LayoutParams params = new LayoutParams(getScreenWidth(context), getScreenHeight(context));
        addView(view, params);
        initListener();
    }

    private void initListener() {
        parentLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (status) {
                    case STATUS_LOADING:
                        break;
                    case STATUS_LOADING_SUCCESS:
                        dismiss();
                        break;
                    case STATUS_LOADING_FAILED:
                        setStatus(STATUS_LOADING);
                        loadingListener.loadRefresh();
                        break;
                    case STATUS_LOADING_TIMEOUT:
                        setStatus(STATUS_LOADING);
                        loadingListener.loadRefresh();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void refreshStatus() {
        switch (status) {
            case STATUS_LOADING:
                tvLoadingStatus.setText(getResources().getString(R.string.loading));
                break;
            case STATUS_LOADING_SUCCESS:
                tvLoadingStatus.setText(getResources().getString(R.string.loading_success));
                dismiss();
                break;
            case STATUS_LOADING_FAILED:
                tvLoadingStatus.setText(getResources().getString(R.string.loading_failed));
                break;
            case STATUS_LOADING_TIMEOUT:
                tvLoadingStatus.setText(getResources().getString(R.string.loading_timeout));
                break;
            default:

                break;
        }
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        refreshStatus();
    }

    public LoadingListener getLoadingListener() {
        return loadingListener;
    }

    public void setLoadingListener(LoadingListener loadingListener) {
        this.loadingListener = loadingListener;
    }

    public void dismiss() {
        setVisibility(GONE);
        tvLoadingStatus.setVisibility(GONE);
        customLayout.setVisibility(GONE);
    }

    public void show() {
        setVisibility(VISIBLE);
        tvLoadingStatus.setVisibility(VISIBLE);
        customLayout.setVisibility(GONE);
    }

    public void showCustomView(View view) {
        setVisibility(VISIBLE);
        tvLoadingStatus.setVisibility(GONE);
        customLayout.removeAllViews();
        customLayout.addView(view);
        customLayout.setVisibility(VISIBLE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

    private int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    public interface LoadingListener {
        void loadFailed();

        void loadSuccess();

        void loadRefresh();

        void loadTimeout();

        void loading();
    }
}