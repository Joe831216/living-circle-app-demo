package com.test.locationlisttest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Joe on 2018/2/5.
 */

public class CustomListView extends ListView {

    public CustomListView(Context context) {
        super(context);
    }

    public CustomListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomListView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

}
