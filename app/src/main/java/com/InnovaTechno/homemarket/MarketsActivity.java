package com.InnovaTechno.homemarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.InnovaTechno.homemarket.Models.Market;

import java.util.ArrayList;
import java.util.List;

public class MarketsActivity extends AppCompatActivity {

    List <Market> lsMarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);
        //Set Title
        this.setTitle("Markets");
        //set the back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lsMarket = new ArrayList<>();
        lsMarket.add( new Market("Avani", R.drawable.avani));
        lsMarket.add(new Market("Extra Supermarché", R.drawable.extra));
        lsMarket.add(new Market("Olympia Market", R.drawable.oly));
        lsMarket.add(new Market("One Stop Market", R.drawable.onestop));
        lsMarket.add(new Market("Compas Market",R.drawable.compas));
        lsMarket.add(new Market("Caribbean", R.drawable.cari));
        lsMarket.add(new Market("Giant SuperMarket", R.drawable.giant));

        RecyclerView rv_Markets  = (RecyclerView) findViewById(R.id.rv_markets);
        RecyclerViewMarket adapterr = new RecyclerViewMarket(this, lsMarket);
        rv_Markets.setLayoutManager(new LinearLayoutManager(this));
        rv_Markets.setAdapter(adapterr);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate searchView in the action bar
        getMenuInflater().inflate(R.menu.toolbar_search_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_seach);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Market");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
    });
        return super.onCreateOptionsMenu(menu);
    }

}
