package com.InnovaTechno.homemarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MarketsActivity extends AppCompatActivity {

    List <Market> lsMarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);

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

    public void marketDetails(View view) {
        Intent d = new Intent(this, MarketsDetailsActivity.class);
        startActivity(d);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate searchView in the action bar
        getMenuInflater().inflate(R.menu.toolbar_search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_seach);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Market");
        return super.onCreateOptionsMenu(menu);
    }
}
