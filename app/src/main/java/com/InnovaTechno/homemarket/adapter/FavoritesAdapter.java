package com.InnovaTechno.homemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Models.Post;
import com.InnovaTechno.homemarket.R;
import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Post> mData;

    public FavoritesAdapter(Context mContext, List<Post> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_favorites, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.MyViewHolder holder, final int position) {
        Post post = mData.get(position);
        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvName, tvPrice, tvDevise;
        ToggleButton favoritesBtn;
        Button btnAdd_to_Cart;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mContext = itemView.getContext();

            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvDevise = itemView.findViewById(R.id.tvDevise);
            favoritesBtn = itemView.findViewById(R.id.favoritesBtn);
            btnAdd_to_Cart = itemView.findViewById(R.id.btnAdd_to_Cart);
        }

        public void bind(Post post) {
            ParseFile image = post.getImage();
            if (image != null) {
                Glide.with(mContext).load(image.getUrl()).into(imageView);
            }

            tvName.setText(post.getName());
            tvDevise.setText(post.getDevise());
            tvPrice.setText(post.getPrice());
        }

    }
}
