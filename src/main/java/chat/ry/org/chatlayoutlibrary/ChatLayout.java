package chat.ry.org.chatlayoutlibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by renyang on 16/3/15.
 */
public class ChatLayout extends ViewGroup{

    public ChatLayout(Context context) {
        super(context);
        init(context,null);
    }

    public ChatLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ChatLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int maxWidth = MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, 0), resolveSizeAndState(maxHeight, heightMeasureSpec, 0));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        View bottom = getChildAt(1);
        View layout = getChildAt(0);
        layout.layout(l,t,r,b);
        bottom.layout(0,b - bottom.getMeasuredHeight(),r,b);
    }

    private void init(Context context, AttributeSet attrs){

    }

}
