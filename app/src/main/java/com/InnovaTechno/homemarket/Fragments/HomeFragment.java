package com.InnovaTechno.homemarket.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.InnovaTechno.homemarket.Models.Category;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.New_Products.NewProducts;
import com.InnovaTechno.homemarket.New_Products.NewProductsAdapter;
import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.adapter.RecyclerViewAdapter;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public static final String TAG = "HomeFragment";

    List<Category> lstCategories;
    private NewProductsAdapter adapterr;
    private List<NewProducts> newProducts;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv_id = view.findViewById(R.id.rv_id);
        TextView tvCategories = view.findViewById(R.id.tvCategories);
        ImageView ivNewProducts = view.findViewById(R.id.ivNewProducts);
        TextView tvNameProducts = view.findViewById(R.id.tvNameProducts);

        lstCategories = new ArrayList<>();
        lstCategories.add(new Category("Fruits et Légumes", R.drawable.fruits_et_legumes));
        lstCategories.add(new Category("Viandes", R.drawable.viandess));
        lstCategories.add(new Category("Produits Laitiers", R.drawable.produits_laitierss));
        lstCategories.add(new Category("Boissons", R.drawable.boissonss));
        lstCategories.add(new Category("Pains", R.drawable.painss));
        lstCategories.add(new Category("Chips&Sucreries", R.drawable.sucreriess));
        lstCategories.add(new Category("Boissons Alcolisées", R.drawable.boissons_alcoliseess));
        lstCategories.add(new Category("Produits Cosmétiques", R.drawable.produits_cosmetiquess));
        lstCategories.add(new Category("Articles Ménagers", R.drawable.articles_de_menagess));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), lstCategories);
        rv_id.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_id.setAdapter(adapter);

        //New products adapter
        newProducts = new ArrayList<>();
        //create the adapter
        adapterr = new NewProductsAdapter(getContext(), newProducts);
        RecyclerView rvNewProducts = view.findViewById(R.id.rvNewProducts);
        rvNewProducts.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvNewProducts.setAdapter(adapterr);

        QueryNewProducts();
    }

    private void QueryNewProducts() {
        ParseQuery<NewProducts> newProductsQuery = new ParseQuery<NewProducts>(NewProducts.class);
        newProductsQuery.addDescendingOrder(NewProducts.KEY_CREATED_AT);
        newProductsQuery.findInBackground(new FindCallback<NewProducts>() {

            @Override
            public void done(List<NewProducts> products, ParseException e) {
                if (e != null) {
                    Log.d(TAG, "Error with New Products Query");
                    e.printStackTrace();
                    return;
                }

                newProducts.addAll(products);
                adapterr.notifyDataSetChanged();

                for (int i = 0; i < products.size(); i++) {
                    Log.d(TAG, "NewProducts: " + products.get(i).getName());
                }

            }
        });
    }



}