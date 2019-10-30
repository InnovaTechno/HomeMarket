package com.InnovaTechno.homemarket.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Adapters.PLaitiersAdapter;
import com.InnovaTechno.homemarket.Categories.Models.PostPLaitiers;
import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.SignUpActivity;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Produits_Laitiers extends AppCompatActivity {
    public static final String TAG ="Produits_Laitiers";
    private PLaitiersAdapter adapter;
    private List<PostPLaitiers> mPosts;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits_laiters);
        //Set Title
        this.setTitle("Produits Laitiers");

                //create the data source
                mPosts = new ArrayList<>();
                //create the adapter
                adapter = new PLaitiersAdapter(this, mPosts);
                RecyclerView rv_produits_laitiers = (RecyclerView) findViewById(R.id.rv_produits_laitiers);
        rv_produits_laitiers.setLayoutManager(new GridLayoutManager(this, 2));
        rv_produits_laitiers.setAdapter(adapter);

                queryPostPLaitiers();
            }

            private void queryPostPLaitiers() {
                ParseQuery<PostPLaitiers> postPLaitiersQuery = new ParseQuery<PostPLaitiers>(PostPLaitiers.class);
                postPLaitiersQuery.include(PostPLaitiers.KEY_DEVISE);
                postPLaitiersQuery.include(PostPLaitiers.KEY_PRICE);
                postPLaitiersQuery.findInBackground(new FindCallback<PostPLaitiers>() {
                    @Override
                    public void done(List<PostPLaitiers> posts, ParseException e) {
                        if (e != null) {
                            Log.d(TAG, "error with query");
                            e.printStackTrace();
                            return;
                        }
                        mPosts.addAll(posts);
                        adapter.notifyDataSetChanged();
                        for (int i = 0; i < posts.size(); i++){
                            PostPLaitiers post = posts.get(i);
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
