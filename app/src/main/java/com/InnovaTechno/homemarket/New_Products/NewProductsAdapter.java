package com.InnovaTechno.homemarket.New_Products;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.InnovaTechno.homemarket.R;
import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;


public class NewProductsAdapter extends RecyclerView.Adapter<NewProductsAdapter.MyViewHolder> {

    private Context context;
    private List<NewProducts> products;

    public NewProductsAdapter(Context context, List<NewProducts> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_newproducts, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewProducts newProducts = products.get(position);
        holder.bind(newProducts);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivNewProducts;
        TextView tvNameProducts;
        CardView cvNewProducts;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivNewProducts = itemView.findViewById(R.id.ivNewProducts);
            tvNameProducts = itemView.findViewById(R.id.tvNameProducts);
            cvNewProducts = itemView.findViewById(R.id.cvNewProducts);
        }

        public void bind(NewProducts newProducts) {
            ParseFile image = newProducts.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivNewProducts);
            }
            tvNameProducts.setText(newProducts.getName());
        }
    }
}
