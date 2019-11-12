package com.InnovaTechno.homemarket.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Models.Post;
import com.InnovaTechno.homemarket.MainActivity;
import com.InnovaTechno.homemarket.Models.Favorites;
import com.InnovaTechno.homemarket.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.parse.DeleteCallback;
import com.parse.ParseException;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.Viewholder> {
    Context context;
    List<Favorites> mFavorites;

    public FavoriteAdapter(Context context, List<Favorites> list) {
        this.context = context;
        this.mFavorites = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_favorite_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Favorites favorites = mFavorites.get(position);

        Post post = (Post) favorites.getProduct();

        Glide.with(context)
                .load(post.getImage().getUrl())
                //.apply(new RequestOptions().error(R.drawable.error))
                .into(holder.imageView);
        holder.tvName.setText(post.getName());
        holder.tvPrice.setText(post.getPrice());
        holder.tvDevise.setText(post.getDevise());

        //Remove favorites
        holder.removeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favorites.deleteInBackground(new DeleteCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e!=null){
                            Log.d("FavoriteAdapter","Erreur delete: "+e.getMessage());
                            e.printStackTrace();
                            return;
                        }
                       mFavorites.remove(position);
                        notifyDataSetChanged();
                        Toast.makeText(context,"successfully removed from favorites", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFavorites.size();
    }

    public void AddAllToList(List<Favorites> list){
        mFavorites.clear();
       mFavorites.addAll(list);
        notifyDataSetChanged();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName, tvPrice, tvDevise;
        Button btnAdd_to_Cart,removeFab;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDevise = itemView.findViewById(R.id.tvDevise);
            btnAdd_to_Cart = itemView.findViewById(R.id.btnAdd_to_Cart);
            removeFab = itemView.findViewById(R.id.removeFab);
        }
    }
}
