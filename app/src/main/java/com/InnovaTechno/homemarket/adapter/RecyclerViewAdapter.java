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

import com.InnovaTechno.homemarket.Categories.Articles_Menagers;
import com.InnovaTechno.homemarket.Categories.Boissons;
import com.InnovaTechno.homemarket.Categories.Boissons_Alcolisees;
import com.InnovaTechno.homemarket.Categories.Chips_Sucreries;
import com.InnovaTechno.homemarket.Categories.Fruits_Legumes;
import com.InnovaTechno.homemarket.Categories.Pains;
import com.InnovaTechno.homemarket.Categories.Produits_Cosmetiques;
import com.InnovaTechno.homemarket.Categories.Produits_Laitiers;
import com.InnovaTechno.homemarket.Categories.Viandes;
import com.InnovaTechno.homemarket.Models.Category;

import com.InnovaTechno.homemarket.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.MyViewHolder> {

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
        view = mInflater.inflate(R.layout.cardview_categories, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.categories_word.setText(mData.get(position).getTitle());
        holder.categories_img_id.setImageResource(mData.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView categories_word;
        ImageView categories_img_id;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();

            categories_word = (TextView) itemView.findViewById(R.id.categories_word);
            categories_img_id = (ImageView) itemView.findViewById(R.id.categories_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            final Intent intent;
            switch (getAdapterPosition()) {
                case 0: //first item in Recycler view (Fruits et legumes)
                    intent = new Intent(mContext, Fruits_Legumes.class);
                    mContext.startActivity(intent);
                    break;
                case 1: //second item in Recycler view (Viandes)
                    intent = new Intent(mContext, Viandes.class);
                    mContext.startActivity(intent);
                    break;
                case 2: //third item in Recycler view (Produits laitiers)
                    intent = new Intent(mContext, Produits_Laitiers.class);
                    mContext.startActivity(intent);
                    break;
                case 3: //fourth item in Recycler view (Boissons)
                    intent = new Intent(mContext, Boissons.class);
                    mContext.startActivity(intent);
                    break;
                case 4: //5eme item in Recycler view (Pains)
                    intent = new Intent(mContext, Pains.class);
                    mContext.startActivity(intent);
                    break;
                case 5: //6eme item in Recycler view (Chips and Sucreries)
                    intent = new Intent(mContext, Chips_Sucreries.class);
                    mContext.startActivity(intent);
                    break;
                case 6: //7eme item in Recycler view (Boissons Alcolisees)
                    intent = new Intent(mContext, Boissons_Alcolisees.class);
                    mContext.startActivity(intent);
                    break;
                case 7: //8eme item in Recycler view (Produits cosmetiques)
                    intent = new Intent(mContext, Produits_Cosmetiques.class);
                    mContext.startActivity(intent);
                    break;
                case 8: //9eme item in Recycler view (Articles menagers)
                    intent = new Intent(mContext, Articles_Menagers.class);
                    mContext.startActivity(intent);
                    break;


            }

        }
    }
}
