package com.InnovaTechno.homemarket.Categories.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Models.PostPains;
import com.InnovaTechno.homemarket.Items_Detail.ItemDetails;
import com.InnovaTechno.homemarket.R;
import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PainsAdapter extends RecyclerView.Adapter<PainsAdapter.ViewHolder> {

    private Context context;
    private List<PostPains> posts;

    public PainsAdapter(Context context, List<PostPains> posts) {
        this.context = context;
        this.posts = posts;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cardview_fruits_legumes, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostPains post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFruits_Legumes;
        TextView tvName;
        TextView tvDevise;
        Button btnAddToCart;
        CardView cvFruits_Legumes;
        private TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFruits_Legumes = itemView.findViewById(R.id.ivFruits_Legumes);
            tvName = itemView.findViewById(R.id.tvName);
            tvDevise = itemView.findViewById(R.id.tvDevise);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
            cvFruits_Legumes = itemView.findViewById(R.id.cvFruits_Legumes);
            tvPrice = itemView.findViewById(R.id.tvPrice);

        }
        public void bind(PostPains post) {
            ParseFile image = post.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivFruits_Legumes);
            }
            tvName.setText(post.getName());
            tvDevise.setText(post.getDevise());
            tvPrice.setText(post.getPrice());
            //tvPrice.setText(Post.getPrice());

            //Passing the data to items details activity
            cvFruits_Legumes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent intent = new Intent(context, ItemDetails.class);
                    intent.putExtra("name", posts.get(position).getName());
                    intent.putExtra("price", posts.get(position).getPrice());
                    intent.putExtra("devise", posts.get(position).getDevise());
                    intent.putExtra("productImage" , posts.get(position).getImage());
                    context.startActivity(intent);

                }
            });
        }

    }
}
