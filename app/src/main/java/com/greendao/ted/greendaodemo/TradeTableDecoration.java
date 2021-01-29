package com.greendao.ted.greendaodemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TradeTableDecoration extends RecyclerView.ItemDecoration {
    private static final int[] attrs = new int[]{android.R.attr.listDivider};
    private Drawable mDivider;
    private int orientation;

    public TradeTableDecoration(Context context,int orientation){
        TypedArray typedArray =context.obtainStyledAttributes(attrs);
        mDivider =typedArray.getDrawable(0);
        typedArray.recycle();
        this.orientation =orientation;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        drawHDeration(c,parent);
        drawHDeration(c,parent);
    }
    private  void drawHDeration(Canvas c,RecyclerView parent){
        int left = parent.getPaddingLeft();
        int right = parent.getWidth()-parent.getPaddingRight();
        int childCount =parent.getChildCount();
        for(int i =0;i<childCount;i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top =child.getBottom() + layoutParams.bottomMargin;
            int bottom = top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }
}
