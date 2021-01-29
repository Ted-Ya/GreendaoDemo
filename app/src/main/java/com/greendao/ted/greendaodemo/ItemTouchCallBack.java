package com.greendao.ted.greendaodemo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;


public class ItemTouchCallBack extends ItemTouchHelper.Callback {

    private OnItemTouchListener onItemTouchListener;


    public ItemTouchCallBack(Context context,OnItemTouchListener onItemTouchListener) {
        this.onItemTouchListener = onItemTouchListener;

    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0,ItemTouchHelper.LEFT);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
             int position =viewHolder.getAdapterPosition();
             onItemTouchListener.onSwiped(position);
    }


    public interface OnItemTouchListener{
        void onSwiped(int position);
    }
}
