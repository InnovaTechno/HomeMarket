package com.InnovaTechno.homemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Models.Post;
import com.InnovaTechno.homemarket.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter <CartAdapter.MyViewHolder> {

    private Context mContext;
    private List<Post> mData;

    public CartAdapter(Context mContext, List<Post> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_cart_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        //holder.ivCart_Item.setImageResource(mData.get(position).getImage());
        holder.tvNameItem.setText(mData.get(position).getName());
        holder.tvPrice_Item.setText(mData.get(position).getPrice());
        holder.tvDevise_Item.setText(mData.get(position).getDevise());
        holder.tvPrice_Total.setText(mData.get(position).getPrice());
        holder.tvDevise_Total.setText(mData.get(position).getDevise());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder  {

        ImageView ivCart_Item;
        TextView tvNameItem;
        TextView tvPrice_Item;
        TextView tvDevise_Item;
        Button btn_moins;
        Button btn_plus;
        TextView tvNbrsItems;
        TextView tvPrice_Total;
        TextView tvDevise_Total;
        CardView cardview_cart_item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();

            ivCart_Item = itemView.findViewById(R.id.ivCart_Item);
            tvNameItem = itemView.findViewById(R.id.tvNameItem);
            tvPrice_Item = itemView.findViewById(R.id.tvPrice_Item);
            tvDevise_Item = itemView.findViewById(R.id.tvDevise_Item);
            tvPrice_Total = itemView.findViewById(R.id.tvPrice_Total);
            tvDevise_Total = itemView.findViewById(R.id.tvDevise_Total);
            btn_moins = itemView.findViewById(R.id.btn_moins);
            btn_plus = itemView.findViewById(R.id.btn_plus);
            tvNbrsItems = itemView.findViewById(R.id.tvNbrsItems);
            //cardview_cart_item = itemView.findViewById(R.id.cardview_cart_item);

        }
    }
}