package personal.buqx.andoridnatureview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

/**
 * Function:
 */

public class EUTabLayout extends TabLayout {

    public EUTabLayout(Context context) {
        super(context);
    }

    public EUTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EUTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    /**
     * Set tab indicator width, xml must use android:background instead app:tabBackground
     *
     * @param leftDistance  margin left dp
     * @param rightDistance margin right dp
     */
    public void setIndicatorMargin(int leftDistance, int rightDistance) {
        Field tabStrip = null;
        try {
            tabStrip = TabLayout.class.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        tabStrip.setAccessible(true);

        LinearLayout slidLinearLayout = null;
        try {
            slidLinearLayout = (LinearLayout) tabStrip.get(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                leftDistance, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                rightDistance, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < slidLinearLayout.getChildCount(); i++) {
            View child = slidLinearLayout.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
            params.setMarginStart(left);
            params.setMarginEnd(right);
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    /**
     * Set tab Image need textAllCaps = false
     *
     * @param position tab position
     */
    public void setTabImage(int position, Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        SpannableString spannableString = new SpannableString(" " + this.getTabAt(position).getText());
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        this.getTabAt(position).setText(spannableString);
    }

}
