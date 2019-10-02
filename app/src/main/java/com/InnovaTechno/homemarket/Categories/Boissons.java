package com.InnovaTechno.homemarket.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Adapter.BoissonsAdapter;
import com.InnovaTechno.homemarket.Categories.Post.PostBoissons;
import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.SignUpActivity;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Boissons extends AppCompatActivity {
    public static final String TAG = "Fruits_Legumes";
    private BoissonsAdapter adapter;
    private List<PostBoissons> mPosts;
    private Button btnAddToCart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boissons);
        //create the data source
        mPosts = new ArrayList<>();
        //create the adapter
        adapter = new BoissonsAdapter(this, mPosts);
        RecyclerView rv_boissons = (RecyclerView) findViewById(R.id.rv_boissons);
        rv_boissons.setLayoutManager(new GridLayoutManager(this, 2));
        rv_boissons.setAdapter(adapter);

        queryPostBoissons();
    }

    private void queryPostBoissons() {
        ParseQuery<PostBoissons> postBoissonsQuery = new ParseQuery<PostBoissons>(PostBoissons.class);
        postBoissonsQuery.include(PostBoissons.KEY_DEVISE);
        postBoissonsQuery.include(PostBoissons.KEY_PRICE);
        postBoissonsQuery.findInBackground(new FindCallback<PostBoissons>() {
            @Override
            public void done(List<PostBoissons> posts, ParseException e) {
                if (e != null) {
                    Log.d(TAG, "error with query");
                    e.printStackTrace();
                    return;
                }
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();
                for (int i = 0; i < posts.size(); i++) {
                    PostBoissons post = posts.get(i);
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

    public void addToCart(View view) {
        Intent c = new Intent(this, SignUpActivity.class);
        startActivity(c);    }

}