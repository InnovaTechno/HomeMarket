package com.InnovaTechno.homemarket.adapter;

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

import com.InnovaTechno.homemarket.Categories.Fruits_Legumes;
import com.InnovaTechno.homemarket.Category;

import com.InnovaTechno.homemarket.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Category> mData;

    public RecyclerViewAdapter(Context mContext, List<Category> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.categories_word.setText(mData.get(position).getTitle());
        holder.categories_img_id.setImageResource(mData.get(position).getThumbnail());

        //set the click listener
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, Fruits_Legumes.class);
                //TODO: ITEM DETAILS
                //Start activity
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView categories_word;
        ImageView categories_img_id;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            categories_word = (TextView) itemView.findViewById(R.id.categories_word);
            categories_img_id = (ImageView) itemView.findViewById(R.id.categories_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }



}
