package com.InnovaTechno.homemarket;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.InnovaTechno.homemarket.Markets_Details.MarketsDetailsActivity;
import com.InnovaTechno.homemarket.Models.Market;

import java.util.List;

public class RecyclerViewMarket extends RecyclerView.Adapter <RecyclerViewMarket.MyViewHolderr> {

    private Context mContextt;
    private List<Market> mDataa;

    public RecyclerViewMarket(Context mContextt, List<Market> mDataa) {
        this.mContextt = mContextt;
        this.mDataa = mDataa;
    }

    @NonNull
    @Override
    public RecyclerViewMarket.MyViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContextt);
        view = mInflater.inflate(R.layout.cardview_market, parent, false);
        return new MyViewHolderr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewMarket.MyViewHolderr holder, final int position) {
        holder.tvMarket.setText(mDataa.get(position).getNamee());
        holder.ivMarket.setImageResource(mDataa.get(position).getThumbnail());
        holder.cvMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //Passing the data
                Intent intent = new Intent(mContextt, MarketsDetailsActivity.class);
                intent.putExtra("Thumbnail", mDataa.get(position).getThumbnail());
                mContextt.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataa.size();
    }

    public static class MyViewHolderr extends RecyclerView.ViewHolder {
        TextView tvMarket;
        ImageView ivMarket;
        CardView cvMarket;


        public MyViewHolderr(@NonNull View itemView) {
            super(itemView);

            tvMarket = (TextView) itemView.findViewById(R.id.tvMarket);
            ivMarket = (ImageView) itemView.findViewById(R.id.ivMarket);
            cvMarket = (CardView) itemView.findViewById(R.id.cvMarket);
            cvMarket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}