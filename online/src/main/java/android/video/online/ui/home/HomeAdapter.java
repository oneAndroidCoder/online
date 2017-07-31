package android.video.online.ui.home;

import android.video.online.BasicActivity;
import android.video.online.BasicAdapterVp;
import android.video.online.R;
import android.video.online.model.AdModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Jay on 2017/7/22.
 */
public class HomeAdapter extends BasicAdapterVp {
    private BasicActivity activity;
    private List<AdModel> models;

    public HomeAdapter(BasicActivity activity, List<AdModel> mAdData) {
        super(activity);
        this.activity = activity;
        this.models = mAdData;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = LayoutInflater.from(activity).inflate(R.layout.vp_home_ad, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.iv_home_ad);

        activity.getImageLoader().displayImage(models.get(position % models.size()).getPic(), imageView);
        container.addView(view);

        return view;
    }
}
