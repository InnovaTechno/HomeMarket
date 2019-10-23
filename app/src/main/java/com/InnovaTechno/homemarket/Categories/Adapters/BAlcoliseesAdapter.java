package com.InnovaTechno.homemarket.Categories.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Models.row;
import com.InnovaTechno.homemarket.R;

import java.util.List;

public class BAlcoliseesAdapter extends RecyclerView.Adapter<BAlcoliseesAdapter.ViewHolder> {

    private Context mContext;
    private List<row> mData;

    public BAlcoliseesAdapter (Context mContext, List<row> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       // holder.tvName.setText(mData.get(position).getName());
        holder.row_img.setImageResource(mData.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder  {
        //TextView tvName;
        ImageView row_img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            //tvName = (TextView) itemView.findViewById(R.id.tvName);
            row_img = (ImageView) itemView.findViewById(R.id.row_img);


        }
    }
}
