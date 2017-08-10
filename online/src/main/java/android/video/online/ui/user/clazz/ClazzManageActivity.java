package android.video.online.ui.user.clazz;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.video.online.adapter.ClazzManageAdapter;
import android.video.online.core.BasicPresenter;
import android.video.online.model.CourseModel;
import android.video.online.widget.LoadingView;

import java.util.List;

public class ClazzManageActivity extends BasicActivity implements ClazzManageContract.View {

    private ClazzManageContract.Presenter presenter;
    private RecyclerView lv_clazz_list;
    private LoadingView ld_loading;

    @Override
    public int setLayoutId() {
        return R.layout.activity_clazz_manage;
    }

    @Override
    public void init() {
        initView();
        initData();
    }

    private void initData() {
        presenter = new ClazzManagePresenter(this);
        presenter.loadData(ld_loading);
    }

    private void initView() {
        lv_clazz_list = (RecyclerView) findViewById(R.id.lv_clazz_list);
        ld_loading = (LoadingView) findViewById(R.id.ld_loading);
    }

    @Override
    public void handlerMessage(Message msg) {

    }

    @Override
    public BasicPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onSuccess(List<CourseModel> data) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        lv_clazz_list.setLayoutManager(layoutManager);
        lv_clazz_list.setAdapter(new ClazzManageAdapter(this, data));
    }
}
