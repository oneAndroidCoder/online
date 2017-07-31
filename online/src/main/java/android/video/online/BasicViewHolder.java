package android.video.online;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Jay on 2017/7/22.
 */

public abstract class BasicViewHolder extends RecyclerView.ViewHolder {
    private View parentView;
    public BasicViewHolder(View itemView) {
        super(itemView);
        this.parentView = itemView;
    }

    public View getParentView() {
        return parentView;
    }

    public void setParentView(View parentView) {
        this.parentView = parentView;
    }

    public View getView(int id){
        return parentView.findViewById(id);
    }

}
