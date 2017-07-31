package android.video.online;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Jay on 2017/7/22.
 */
public abstract class BasicAdapter<T> extends RecyclerView.Adapter<BasicViewHolder> {
    private List<T> mData;
    protected BasicActivity context;
    protected ImageLoader imageLoader;


    public BasicAdapter(BasicActivity context, List<T> mData) {
        this.mData = mData;
        this.context = context;
        imageLoader = context.getImageLoader();
    }

    @Override
    public BasicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createViewHolder();
    }

    @Override
    public void onBindViewHolder(BasicViewHolder holder, int position) {
        setDataView(holder, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    protected abstract void setDataView(BasicViewHolder holder, T t);

    public abstract BasicViewHolder createViewHolder();
}
