package com.example.administrator.ddbusdatatest.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by dell on 2016/3/11.
 */
public class StaInfoExListView extends AnimatedExpandableListView {
    public StaInfoExListView(Context context) {
        super(context);
    }

    public StaInfoExListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StaInfoExListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //return super.onInterceptTouchEvent(ev);
        return  false;
    }


}
