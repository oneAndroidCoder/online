package android.video.online.ui.video;

import android.video.online.BasicActivity;
import android.video.online.BasicAdapter;
import android.video.online.BasicViewHolder;
import android.video.online.R;
import android.video.online.model.VideoModel;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Jay on 2017/7/30.
 */

public class VideoAdapter extends BasicAdapter<VideoModel> {

    public VideoAdapter(BasicActivity context, List<VideoModel> mData) {
        super(context, mData);
    }

    @Override
    protected void setDataView(BasicViewHolder holder, final VideoModel videoModel) {

        ImageView ivVideo = (ImageView) holder.getView(R.id.iv_video);
        imageLoader.displayImage(videoModel.getCover(), ivVideo);
        holder.getParentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoPlayerActivity.start(context, videoModel.getId());
            }
        });
    }

    @Override
    public BasicViewHolder createViewHolder() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_course_video, null);
        return new VideoViewHolder(view);
    }
}
