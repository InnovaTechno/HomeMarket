package com.InnovaTechno.homemarket.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Post.Post;

import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.adapter.CartAdapter;

import java.util.List;


public class CartFragment extends Fragment {
    public static final String TAG ="CartFragment";
    private CartAdapter adapter;
    private List<Post> post;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvListProducts = view.findViewById(R.id.tvListProducts);
        TextView tv_Total_Acheter = view.findViewById(R.id.tv_Total_Acheter);
        TextView tv_Total_Livraison = view.findViewById(R.id.tv_Total_Livraison);
        Button btnCheckout = view.findViewById(R.id.btnCheckout);
        Button btnClear = view.findViewById(R.id.btnClear);
        ImageView ivCart_Item = view.findViewById(R.id.ivCart_Item);
        TextView tvNameItem = view.findViewById(R.id.tvNameItem);
        TextView tvPrice_Item = view.findViewById(R.id.tvPrice_Item);
        TextView tvDevise_Item = view.findViewById(R.id.tvDevise_Item);
        final TextView tv_TOTAL_PRICE = view.findViewById(R.id.tv_TOTAL_PRICE);
        TextView tvDevise_Total = view.findViewById(R.id.tvDevise_Total);


        //set the adapter
        final RecyclerView rv_Cart = view.findViewById(R.id.rv_Cart);
        CartAdapter adapter = new CartAdapter(getContext(), post);
        rv_Cart.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_Cart.setAdapter(adapter);

        //Onclick on button clear cart
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clearing the shopping cart");
                //clear items
            }
        });

        //receive data


        //setting values


    }
}
