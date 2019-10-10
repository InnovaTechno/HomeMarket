package com.InnovaTechno.homemarket.Items_Detail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.New_Products.NewProducts;
import com.InnovaTechno.homemarket.R;
import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class RelatedItemsAdapter extends RecyclerView.Adapter<RelatedItemsAdapter.MyViewHolder> {

    private Context context;
    private List<RelatedItems> items;

    public RelatedItemsAdapter(Context context, List<RelatedItems> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_related_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RelatedItems relatedItems = items.get(position);
        holder.bind(relatedItems);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView ivRelated_Items;
        TextView tvNameRelatedItems, tvRI_Price, tvRI_Devise;
        CardView cvRelated_Items;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRelated_Items = itemView.findViewById(R.id.ivRelated_Items);
            tvNameRelatedItems = itemView.findViewById(R.id.tvNameRelatedItems);
            tvRI_Price = itemView.findViewById(R.id.tvRI_Price);
            tvRI_Devise = itemView.findViewById(R.id.tvRI_Devise);
            cvRelated_Items = itemView.findViewById(R.id.cvRelated_Items);
            cvRelated_Items.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        public void bind(RelatedItems relatedItems) {
            ParseFile image = relatedItems.getImage();
            if (image != null) {
                Glide.with(context).load(image.getUrl()).into(ivRelated_Items);
            }
            tvNameRelatedItems.setText(relatedItems.getName());
            tvRI_Devise.setText(relatedItems.getDevise());
            tvRI_Price.setText(relatedItems.getPrice());
        }
    }
}
