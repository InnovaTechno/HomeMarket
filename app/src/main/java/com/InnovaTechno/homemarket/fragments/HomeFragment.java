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

import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.adapter.HomeAdapter;

public class HomeFragment extends Fragment {
    private GridView gridView;

    String[] categoriesWord = {"Fruits et Légumes", "Viandes", "Produits Laitiers", "Boissons", "Paints ","Chips & Sucreries"};
   // int[] categoriesImage = {R.drawable.fruits_et_legumes, R.drawable.viandess,
   //         R.drawable.produits_laitierss, R.drawable.boissonss, R.drawable.painss, R.drawable.sucreriess};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = view.findViewById(R.id.gridView);

        //HomeAdapter adapter = new HomeAdapter(getContext(), categoriesWord, categoriesImage);
        //gridView.setAdapter(adapter);


        //HomeAdapter adapter = new HomeAdapter (this,  categoriesWord, categoriesImage);
        //gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getActivity(), "You clicked Gloria " + categoriesWord[+position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
