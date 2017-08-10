package android.video.online.adapter;

import android.video.online.BasicActivity;
import android.video.online.BasicAdapter;
import android.video.online.BasicViewHolder;
import android.video.online.R;
import android.video.online.model.CourseModel;
import android.video.online.viewholder.ClazzManageViewHolder;
import android.view.LayoutInflater;
import android.view.View;

import java.util.List;

/**
 * Created by Jay on 2017/8/10.
 */

public class ClazzManageAdapter extends BasicAdapter<CourseModel> {
    public ClazzManageAdapter(BasicActivity context, List mData) {
        super(context, mData);
    }

    @Override
    protected void setDataView(BasicViewHolder holder, CourseModel courseModel) {

    }

    @Override
    public BasicViewHolder createViewHolder() {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_home_video, null);
        return new ClazzManageViewHolder(inflate);
    }
}
