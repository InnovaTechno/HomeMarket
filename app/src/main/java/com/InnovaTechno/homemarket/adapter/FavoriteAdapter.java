package com.InnovaTechno.homemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Models.Favorite;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder>{
    private Favorite favorites;
    private Context context;

    public FavoriteAdapter(Favorite favorites, Context context) {
        this.favorites = favorites;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoriteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(android.R.layout.cardview_favorite_item,parent, false);
        return new FavoriteHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FavoriteHolder extends RecyclerView.ViewHolder {
        private Favorite favorite;
        private ImageView iv_empty_cart;
        private TextView tv_start_shopping;

        public FavoriteHolder(@NonNull View itemView) {
            super(itemView);
            tv_start_shopping = (TextView) itemView;
            iv_empty_cart = (ImageView) itemView;
        }

        public void bindFavorite (Favorite favorite){
            favorite = favorite;
            tv_start_shopping.setText(favorite.getTitle());
            iv_empty_cart.setImageResource(favorite.getImage());

        }


        //  public FavoriteHolder(View itemView) {
         //   super(itemView);
          //  titleTextView = (TextView)itemView;       }

      //  public void bindTodo(Todo todo) {
         //   todo = todo;
          //  titleTextView.setText(todo.getTitle());        }
    }
}
