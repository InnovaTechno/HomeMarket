package com.InnovaTechno.homemarket.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Models.Post;

import com.InnovaTechno.homemarket.PaymentMethods.ChoosePayments;
import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.adapter.CartAdapter;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {
    public static final String TAG = "CartFragment";
    private CartAdapter adapter;
    private List<Post> post;
    TextView tvNameItem;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv_Total_Acheter = view.findViewById(R.id.tv_Total_Acheter);
        TextView tv_Total_Livraison = view.findViewById(R.id.tv_Total_Livraison);
        Button btnCheckout = view.findViewById(R.id.btnCheckout);
        ImageView ivCart_Item = view.findViewById(R.id.ivCart_Item);
        TextView tvNameItem = view.findViewById(R.id.tvNameItem);
        TextView tvPrice_Item = view.findViewById(R.id.tvPrice_Item);
        TextView tvDevise_Item = view.findViewById(R.id.tvDevise_Item);
        final TextView tv_TOTAL_PRICE = view.findViewById(R.id.tv_TOTAL_PRICE);
        TextView tvDevise_Total = view.findViewById(R.id.tvDevise_Total);

        //create the data source
        post = new ArrayList<>();
        //set the adapter
        final RecyclerView rv_Cart = view.findViewById(R.id.rv_Cart);
        adapter = new CartAdapter(getContext(), post);
        rv_Cart.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_Cart.setAdapter(adapter);

        //Set intent on checkout button to choose payment method
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent checkout = new Intent(getContext(), ChoosePayments.class);
               startActivity(checkout);
            }
        });


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getArguments() == null){
            Toast.makeText(getContext(), "You haven't add anything to the cart",Toast.LENGTH_SHORT).show();
        } else{
            String name = getArguments().getString("name");
            tvNameItem.setText(name);
        }

        return inflater.inflate(R.layout.fragment_cart, container, false);
    }


        }



