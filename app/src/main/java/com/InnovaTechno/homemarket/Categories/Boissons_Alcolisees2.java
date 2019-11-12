package com.InnovaTechno.homemarket.Categories;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Adapters.BAlcoliseesAdapter2;
import com.InnovaTechno.homemarket.Categories.Models.PostBAlcolisees;
import com.InnovaTechno.homemarket.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Boissons_Alcolisees2 extends AppCompatActivity {
    public static final String TAG = "Boissons_Alcolisees";
    private BAlcoliseesAdapter2 adapter;
    private List<PostBAlcolisees> mPosts;
    private Button btnAddToCart;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boissons_alcolisees2);
        //Set Title
        this.setTitle("Boissons Alcolisées");

        //create the data source
        mPosts = new ArrayList<>();
        //create the adapter
        adapter = new BAlcoliseesAdapter2(this, mPosts);
        RecyclerView rv_boissons_alcolisees = (RecyclerView) findViewById(R.id.rv_boissons_alcolisees);
        rv_boissons_alcolisees.setLayoutManager(new GridLayoutManager(this, 2));
        rv_boissons_alcolisees.setAdapter(adapter);

        queryPostBAlcolisees();
    }

    private void queryPostBAlcolisees() {
        ParseQuery<PostBAlcolisees> postBAlcoliseesQuery = new ParseQuery<PostBAlcolisees>(PostBAlcolisees.class);
        postBAlcoliseesQuery.include(PostBAlcolisees.KEY_DEVISE);
        postBAlcoliseesQuery.include(PostBAlcolisees.KEY_PRICE);
        postBAlcoliseesQuery.findInBackground(new FindCallback<PostBAlcolisees>() {
            @Override
            public void done(List<PostBAlcolisees> posts, ParseException e) {
                if (e != null) {
                    Log.d(TAG, "error with query PAINS");
                    e.printStackTrace();
                    return;
                }
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();
                for (int i = 0; i < posts.size(); i++) {
                    PostBAlcolisees post = posts.get(i);
                    Log.d(TAG, "Post: " + posts.get(i).getName() + ",devise" + post.getDevise() + ", price" + post.getPrice());
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate searchView in the action bar
        getMenuInflater().inflate(R.menu.toolbar_search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_seach);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Products");
        return super.onCreateOptionsMenu(menu);
    }
}
