package android.video.online.ui.home;

import android.video.online.BasicActivity;
import android.video.online.BasicAdapter;
import android.video.online.BasicViewHolder;
import android.video.online.R;
import android.video.online.model.VideoModel;
import android.video.online.ui.video.CourseDetailActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jay on 2017/7/22.
 */
public class HomeNewsAdapter extends BasicAdapter<VideoModel> {

    private TextView tvAuthor;
    private TextView tvDes;
    private TextView tvTitle;
    private ImageView ivIcon;

    public HomeNewsAdapter(BasicActivity context, List mData) {
        super(context, mData);
    }

    @Override
    protected void setDataView(final BasicViewHolder holder, final VideoModel o) {
        tvAuthor.setText(o.getTname());
        tvDes.setText(o.getDes());
        tvTitle.setText(o.getTitle());

        imageLoader.displayImage(o.getCover(), ivIcon);
        holder.getParentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseDetailActivity.start(holder.getParentView().getContext(), o.getId());
            }
        });
    }

    @Override
    public BasicViewHolder createViewHolder() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_news, null);
        tvAuthor = (TextView) view.findViewById(R.id.tv_author);
        tvDes = (TextView) view.findViewById(R.id.tv_des);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        ivIcon = (ImageView) view.findViewById(R.id.iv_icon);


        return new HomeNewsViewHolder(view);
    }

}
