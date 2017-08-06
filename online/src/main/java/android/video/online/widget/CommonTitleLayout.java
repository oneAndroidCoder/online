package android.video.online.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.video.online.BasicActivity;
import android.video.online.R;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Jay on 2017/8/6.
 */

public class CommonTitleLayout extends LinearLayout implements View.OnClickListener {

    private ImageView btnBack;
    private TextView tvTitle;
    private TextView tvRight;
    private TextView tvRightTwo;

    private Context context;
    private int titleColor;
    private int titleSize;
    private CharSequence titleTxt;
    private int backRes;
    private CharSequence rightTxt;
    private CharSequence rightTwoTxt;
    private int rightColor;
    private int rightTwoColor;
    private int rightSize;
    private int rightTwoSize;
    private boolean backIsShow;

    private CommonTitleListener commonTitleListener = new SimpleCommonTitleListener();

    public CommonTitleLayout(Context context) {
        this(context, null);
    }

    public CommonTitleLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public CommonTitleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
        initAttrs(attrs);
        initViewValue();
        initVisible();
        initListener();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.widget_common_title, null);
        btnBack = (ImageView) inflate.findViewById(R.id.btn_back);
        tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        tvRight = (TextView) inflate.findViewById(R.id.tv_right);
        tvRightTwo = (TextView) inflate.findViewById(R.id.tv_right_two);
        this.addView(inflate);
        titleColor = getResources().getColor(R.color.colorMainBlack);
        titleSize = 20;
        titleTxt = getResources().getString(R.string.app_name);
        backRes = R.mipmap.ic_common_back;
        rightColor = getResources().getColor(R.color.colorMainBlack);
        rightTwoColor = getResources().getColor(R.color.colorMainBlack);
        rightSize = 16;
        rightTwoSize = 16;
        backIsShow = true;

    }

    /**
     * @param attrs
     */
    private void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Common_Title_layout);
        if (typedArray == null) {
            return;
        }
        for (int i = 0; i < typedArray.length(); i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.Common_Title_layout_back_isShow:
                    backIsShow = typedArray.getBoolean(attr, true);
                    break;
                case R.styleable.Common_Title_layout_back_res:
                    backRes = typedArray.getResourceId(attr, R.mipmap.ic_common_back);
                    break;
                case R.styleable.Common_Title_layout_title_size:
                    titleSize = typedArray.getDimensionPixelSize(attr, 20);
                    break;
                case R.styleable.Common_Title_layout_title_color:
                    titleColor = typedArray.getColor(attr, getResources().getColor(R.color.colorMainBlack));
                    break;
                case R.styleable.Common_Title_layout_title_txt:
                    titleTxt = typedArray.getText(attr);
                    break;
                case R.styleable.Common_Title_layout_right_txt:
                    rightTxt = typedArray.getText(attr);
                    break;
                case R.styleable.Common_Title_layout_right_two_txt:
                    rightTwoTxt = typedArray.getText(attr);
                    break;
                case R.styleable.Common_Title_layout_right_txt_color:
                    rightColor = typedArray.getColor(attr, getResources().getColor(R.color.colorMainBlack));
                    break;
                case R.styleable.Common_Title_layout_right_two_txt_color:
                    rightTwoColor = typedArray.getColor(attr, getResources().getColor(R.color.colorMainBlack));
                    break;
                case R.styleable.Common_Title_layout_right_size:
                    rightSize = typedArray.getDimensionPixelSize(attr, 16);
                    break;
                case R.styleable.Common_Title_layout_right_two_size:
                    rightTwoSize = typedArray.getDimensionPixelSize(attr, 16);
                    break;
            }
        }
    }

    private void initViewValue() {
        tvTitle.setTextColor(titleColor);
        tvTitle.setTextSize(titleSize);
        tvTitle.setText(titleTxt);

        btnBack.setBackgroundResource(backRes);
        btnBack.setVisibility(backIsShow ? VISIBLE : GONE);

        tvRight.setText(rightTxt);
        tvRight.setTextSize(rightSize);
        tvRight.setTextColor(rightColor);

        tvRightTwo.setText(rightTwoTxt);
        tvRightTwo.setTextColor(rightTwoColor);
        tvRightTwo.setTextSize(rightTwoSize);
    }

    private void initListener() {
        btnBack.setOnClickListener(this);
    }

    private void initVisible() {
        if (TextUtils.isEmpty(rightTxt)) {
            tvRight.setVisibility(GONE);
        } else {
            tvRight.setVisibility(VISIBLE);
        }

        if (TextUtils.isEmpty(rightTwoTxt)) {
            tvRightTwo.setVisibility(GONE);
        } else {
            tvRightTwo.setVisibility(VISIBLE);
        }
    }

    public CommonTitleListener getCommonTitleListener() {
        return commonTitleListener;
    }

    public void setCommonTitleListener(CommonTitleListener commonTitleListener) {
        this.commonTitleListener = commonTitleListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                commonTitleListener.onBack();
                break;
            case R.id.tv_right:
                commonTitleListener.onRight();
                break;
            case R.id.tv_right_two:
                commonTitleListener.onTwoRight();
                break;
        }
    }

    public class SimpleCommonTitleListener implements CommonTitleListener {

        @Override
        public void onBack() {
            if (context instanceof BasicActivity) {
                ((BasicActivity) context).finish();
            }
        }

        @Override
        public void onRight() {

        }

        @Override
        public void onTwoRight() {

        }
    }

    public interface CommonTitleListener {
        void onBack();

        void onRight();

        void onTwoRight();
    }
}
