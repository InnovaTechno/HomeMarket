package com.InnovaTechno.homemarket.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories;
import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    List<Categories> lstCategories ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rv_id = view.findViewById(R.id.rv_id);


        lstCategories = new ArrayList<>();
        lstCategories.add(new Categories("Fruits et Légumes", R.drawable.fruits_et_legumes ));
        lstCategories.add(new Categories("Viandes", R.drawable.viandess ));
        lstCategories.add(new Categories("Produits Laitiers", R.drawable.produits_laitierss ));
        lstCategories.add(new Categories("Boissons", R.drawable.boissonss ));
        lstCategories.add(new Categories("Pains", R.drawable.painss ));
        lstCategories.add(new Categories("Chips&Sucreries", R.drawable.sucreriess ));
        lstCategories.add(new Categories("Boissons Alcolisées", R.drawable.boissons_alcoliseess ));
        lstCategories.add(new Categories("Produits Cosmétiques", R.drawable.produits_cosmetiquess ));
        lstCategories.add(new Categories("Article Ménagers", R.drawable.articles_de_menagess));


        RecyclerViewAdapter adapter = new RecyclerViewAdapter (getContext(), lstCategories);
        rv_id.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rv_id.setAdapter(adapter);


    }
}
