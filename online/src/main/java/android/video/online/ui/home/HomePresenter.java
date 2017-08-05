package android.video.online.ui.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.video.online.R;
import android.video.online.core.BasicView;
import android.video.online.core.HttpCallback;
import android.video.online.http.ServiceManager;
import android.video.online.model.Category;
import android.video.online.model.HomeModel;
import android.video.online.model.VideoModel;
import android.video.online.ui.video.CourseDetailActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Jay on 2017/7/22.
 */

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View view;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        ServiceManager.getInstance().loadHomeData(new HttpCallback() {

            @Override
            protected void onFail(Call call, Object... objects) {
                view.onFail(call, null);
            }

            @Override
            protected void onSuccess(Call call, Response response, String result, Object... objects) {
                if (response.isSuccessful()) {

                    if (!TextUtils.isEmpty(result)) {

                        try {
                            JSONObject object = new JSONObject(result.toString());
                            String data = object.optString("data");
                            HomeModel homeModel = JSON.parseObject(data, HomeModel.class);
                            view.onSuccess(call, homeModel);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    view.onFail(call, null);
                }
            }

        });
    }

    public void addHotVideo(LinearLayout mLlHomeContent, HomeModel homeModel) {
        mLlHomeContent.addView(createFreeVideoTitle("热门课程"));
        List<VideoModel> free = homeModel.getHot();
        for (int i = 0; i < free.size(); i++) {
            mLlHomeContent.addView(createFreeVideoItem(free.get(i)));
        }
    }

    public void addClazzType(LinearLayout mLlHomeContent, HomeModel homeModel) {
        List<Category> category = homeModel.getCategory();
        RecyclerView recyclerView = new RecyclerView(view.getContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(view.getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new HomeNewsAdapter(view.getContext(), category));
        mLlHomeContent.addView(recyclerView);
    }

    public void addFreeVideo(LinearLayout mLlHomeContent, HomeModel homeModel) {
        mLlHomeContent.addView(createFreeVideoTitle("免费课堂"));
        List<VideoModel> free = homeModel.getFree();
        for (int i = 0; i < free.size(); i++) {
            mLlHomeContent.addView(createFreeVideoItem(free.get(i)));
        }
    }

    private View createFreeVideoTitle(String 免费课堂) {
        TextView textView = new TextView(view.getContext());
        textView.setText(免费课堂);
        textView.setWidth(-1);
        textView.setHeight(120);
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(32, 10, 0, 10);
        return textView;
    }

    public View createFreeVideoItem(final VideoModel videoModel) {
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.item_home_video, null);
        TextView tvAuthor = (TextView) inflate.findViewById(R.id.tv_author);
        TextView tvDes = (TextView) inflate.findViewById(R.id.tv_des);
        TextView tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        ImageView ivIcon = (ImageView) inflate.findViewById(R.id.iv_icon);
        tvAuthor.setText(videoModel.getTname());
        tvDes.setText(videoModel.getDes());
        tvTitle.setText(videoModel.getTitle());

        view.getContext().getImageLoader().displayImage(videoModel.getCover(), ivIcon);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseDetailActivity.start(view.getContext(), videoModel.getId());
            }
        });
        return inflate;
    }

    @Override
    public BasicView getView() {
        return view;
    }
}
