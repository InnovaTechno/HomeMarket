package com.InnovaTechno.homemarket.Categories;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.InnovaTechno.homemarket.Categories.Adapters.BAlcoliseesAdapter;
import com.InnovaTechno.homemarket.Categories.Models.row;

import com.InnovaTechno.homemarket.R;

import java.util.ArrayList;
import java.util.List;

public class Boissons_Alcolisees extends AppCompatActivity {

    private RecyclerView rv_boissons_alcolisees1;
    private BAlcoliseesAdapter adapter;
    private StaggeredGridLayoutManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boissons_alcolisees);

        rv_boissons_alcolisees1 = findViewById(R.id.rv_boissons_alcolisees1);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv_boissons_alcolisees1.setLayoutManager(manager);

        //the array list
        List<row> lst = new ArrayList<>();
        lst.add(new row( R.drawable.vin));
        lst.add(new row( R.drawable.rhum));
        lst.add(new row( R.drawable.cognac));
        lst.add(new row( R.drawable.champagne));        ;
        lst.add(new row( R.drawable.whisky));
        lst.add(new row( R.drawable.vodka));
        lst.add(new row(R.drawable.bierre));

        adapter = new BAlcoliseesAdapter (this, lst);
        rv_boissons_alcolisees1.setAdapter(adapter);


    }
}
