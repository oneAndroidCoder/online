package android.video.online.ui.home;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.video.online.BasicActivity;
import android.video.online.BasicFragment;
import android.video.online.R;
import android.video.online.core.BasicPresenter;
import android.video.online.model.AdModel;
import android.video.online.model.HomeModel;
import android.video.online.widget.LoadingView;
import android.video.online.widget.listener.SimpleLoadingListener;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;

/**
 * Created by Jay on 2017/7/22.
 */

public class HomeFragment extends BasicFragment implements HomeContract.View {

    private HomeAdapter adapter;
    private List<AdModel> mAdData;

    private LoadingView mLoadingView;
    private ViewPager mVpHomeAd;
    private RecyclerView mLvHomeNews;
    private LinearLayout mLlHomeContent;
    private LinearLayout mLlDot;

    private List<View> mDots;
    private HomeContract.Presenter presenter;
    private int currentIndex = 0;
    private int olderIndex = 0;

    private static final int INIT_DOTS = 1011;
    private static final int REFRESH_DOTS = 1012;

    private long delay = 3 * 1000;
    private long period = 2 * 1000;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case INIT_DOTS:
                    getDots();
                    mVpHomeAd.setCurrentItem(currentIndex);
                    mDots.get(olderIndex).setBackgroundResource(R.drawable.shape_dot_normal);
                    mDots.get(currentIndex % mAdData.size()).setBackgroundResource(R.drawable.shape_dot_select);
                    olderIndex = currentIndex % mAdData.size();
                    timer.purge();
                    break;
                case REFRESH_DOTS:
                    adapter.notifyDataSetChanged();
                    getDots();
                    mVpHomeAd.setCurrentItem(currentIndex);
                    mDots.get(olderIndex).setBackgroundResource(R.drawable.shape_dot_normal);
                    mDots.get(currentIndex % mAdData.size()).setBackgroundResource(R.drawable.shape_dot_select);
                    olderIndex = currentIndex % mAdData.size();
                    timer.purge();
                    break;
            }
        }
    };
    private Timer timer;

    @Override
    public int setLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        mLoadingView = (LoadingView) activity.findViewById(R.id.ld_loading);
        mVpHomeAd = (ViewPager) activity.findViewById(R.id.vp_home_ad);
        mLlDot = (LinearLayout) activity.findViewById(R.id.ll_dot);
        mLlHomeContent = (LinearLayout) activity.findViewById(R.id.ll_home_content);

        mDots = new ArrayList<>();

        presenter = new HomePresenter(this);

        initListener();

        presenter.loadData(mLoadingView);
    }

    private void initListener() {
        mLoadingView.setLoadingListener(new SimpleLoadingListener() {
            @Override
            public void loadRefresh() {
                presenter.loadData(mLoadingView);
            }
        });
    }

    @Override
    public void getDots() {
        mDots.clear();
        mLlDot.removeAllViews();
        for (int i = 0; i < mAdData.size(); i++) {
            View view = LayoutInflater.from(activity).inflate(R.layout.dot_layout, null);

            View dot = view.findViewById(R.id.dotView);
            mDots.add(dot);
            mLlDot.addView(view);
        }
    }

    @Override
    public void onSuccess(Call call, HomeModel homeModel) {
        mLlHomeContent.removeAllViews();
        presenter.addClazzType(mLlHomeContent, homeModel);
        presenter.addFreeVideo(mLlHomeContent, homeModel);
        presenter.addHotVideo(mLlHomeContent, homeModel);
        presenter.addCategory(mLlHomeContent, homeModel.getCourse());

        mAdData = homeModel.getAdvs();
        if (mAdData != null && mAdData.size() > 0)
            currentIndex = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % mAdData.size();

        mVpHomeAd.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentIndex = position;
                handler.sendEmptyMessage(REFRESH_DOTS);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                currentIndex = mVpHomeAd.getCurrentItem() + 1;
//                handler.sendEmptyMessage(REFRESH_DOTS);
            }
        }, delay, period);
    }

    @Override
    public void onFail(Call call, IOException e) {
    }

    @Override
    public BasicActivity getContext() {
        return activity;
    }

    @Override
    public BasicPresenter getPresenter() {
        return presenter;
    }
}
