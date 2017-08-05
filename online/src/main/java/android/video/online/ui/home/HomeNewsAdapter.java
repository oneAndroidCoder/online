package android.video.online.ui.home;

import android.video.online.BasicActivity;
import android.video.online.BasicAdapter;
import android.video.online.BasicViewHolder;
import android.video.online.R;
import android.video.online.model.Category;
import android.video.online.model.CategoryChildren;
import android.video.online.ui.video.CourseDetailActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jay on 2017/7/22.
 */
public class HomeNewsAdapter extends BasicAdapter<Category> {

    private LinearLayout llContent;
    private TextView tvTitle;

    public HomeNewsAdapter(BasicActivity context, List mData) {
        super(context, mData);
    }

    @Override
    protected void setDataView(final BasicViewHolder holder, final Category o) {
        tvTitle.setText(o.getName());
        for (int i = 0; i < o.getChildren().size(); i++) {
            llContent.addView(createClazzTypeChildrenItem(o.getChildren().get(i)));
        }
        holder.getParentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseDetailActivity.start(holder.getParentView().getContext(), o.getId());
            }
        });
    }

    private View createClazzTypeChildrenItem(CategoryChildren categoryChildren) {
        TextView textView = new TextView(context);
        textView.setText(categoryChildren.getName());
        textView.setTextColor(context.getColor(R.color.main_white_a));
        textView.setPadding(6, 6, 6, 6);
        return textView;
    }

    @Override
    public BasicViewHolder createViewHolder() {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_home_type, null);
        llContent = (LinearLayout) inflate.findViewById(R.id.ll_type_content);
        tvTitle = (TextView) inflate.findViewById(R.id.tv_type_title);
        return new HomeNewsViewHolder(inflate);
    }

}
