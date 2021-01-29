package com.greendao.ted.greendaodemo;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TradeDataListAdapter extends RecyclerView.Adapter<TradeDataListAdapter.QueryDataHolder>{

    private ArrayList<TradeDate> mTradeDate;
    private ItemSelectedListener mItemSelectedListener;
    private RecyclerView recyclerView;


    public interface ItemSelectedListener{
       void onItemSelected(int index);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView =recyclerView;
    }

    public TradeDataListAdapter(){
        this.mTradeDate = new ArrayList<>();
    }

    public TradeDataListAdapter(ArrayList<TradeDate> tradeDate){
        this.mTradeDate = tradeDate;
    }

    public TradeDataListAdapter(ItemSelectedListener itemSelectedListener, ArrayList<TradeDate> TradeDate) {
        this.mTradeDate = TradeDate;
        this.mItemSelectedListener =itemSelectedListener;
    }


    @NonNull
    @Override
    public QueryDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem,parent,false);
        if(mItemSelectedListener == null){
            return  new QueryDataHolder(view);
        }
        return new QueryDataHolder(view,mItemSelectedListener);
    }



    @Override
    public void onBindViewHolder(@NonNull QueryDataHolder holder, int position) {
        TradeDate tradeDate = mTradeDate.get(position);
        holder.tradeId.setText(tradeDate.getId().toString());
        holder.tradeItemId.setText(tradeDate.getItem());
        holder.tradePriceId.setText(tradeDate.getPrice()+" ");
    }


    @Override
    public int getItemCount() {
        return mTradeDate.size();
    }


    public void removeTradeTable(int index){
        mTradeDate.remove(index);
        notifyDataSetChanged();
    }

    static class QueryDataHolder extends RecyclerView.ViewHolder{

        public TextView tradeId;
        public TextView tradeItemId;
        public TextView tradePriceId;

        public QueryDataHolder(@NonNull View recycleritem) {
            super(recycleritem);
            tradeId = recycleritem.findViewById(R.id.tradeId);
            tradeItemId = recycleritem.findViewById(R.id.tradeItemId);
            tradePriceId = recycleritem.findViewById(R.id.tradePriceId);
        }

        public QueryDataHolder(View recycleritem,final ItemSelectedListener itemSelecedListener){
            super(recycleritem);
            tradeId = recycleritem.findViewById(R.id.tradeId);
            tradeItemId = recycleritem.findViewById(R.id.tradeItemId);
            tradePriceId = recycleritem.findViewById(R.id.tradePriceId);
            recycleritem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    if(index != -1){
                        itemSelecedListener.onItemSelected(index);
                    }
                }
            });
        }
    }
}
