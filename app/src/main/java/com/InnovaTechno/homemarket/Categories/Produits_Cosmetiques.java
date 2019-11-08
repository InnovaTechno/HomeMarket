package com.InnovaTechno.homemarket.Categories;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.Categories.Adapters.PCosmetiquesAdapter;
import com.InnovaTechno.homemarket.Categories.Models.PostPCosmetiques;
import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.SignUpActivity;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class Produits_Cosmetiques extends AppCompatActivity {
    public static final String TAG ="Produits_Cosmetiques";
    private PCosmetiquesAdapter adapter;
    private List<PostPCosmetiques> mPosts;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Check the internet connection state
        if(!isConnected(Produits_Cosmetiques.this)) buildDialog(Produits_Cosmetiques.this).show();
        else {
            Toast.makeText(Produits_Cosmetiques.this,"Welcome", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_produits_cosmetiques);}
        //Set Title
        this.setTitle("Produits Cosmétiques");

        //set the back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                //create the data source
                mPosts = new ArrayList<>();
                //create the adapter
                adapter = new PCosmetiquesAdapter(this, mPosts);
                RecyclerView rv_produits_cosmetiques = (RecyclerView) findViewById(R.id.rv_produits_cosmetiques);
        if(!isConnected(Produits_Cosmetiques.this)) buildDialog(Produits_Cosmetiques.this).show();
        else {
        rv_produits_cosmetiques.setLayoutManager(new GridLayoutManager(this, 2));
        rv_produits_cosmetiques.setAdapter(adapter);}

                queryPostPCosmetiques();
            }

    //Check the network connection
    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else return false;
        } else
            return false;
    }

    //Alert dialog for no network connection
    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Make sure your devise is connected to the internet. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }

            private void queryPostPCosmetiques() {
                ParseQuery<PostPCosmetiques> postPCosmetiquesQuery = new ParseQuery<PostPCosmetiques>(PostPCosmetiques.class);
                postPCosmetiquesQuery.include(PostPCosmetiques.KEY_DEVISE);
                postPCosmetiquesQuery.include(PostPCosmetiques.KEY_PRICE);
                postPCosmetiquesQuery.findInBackground(new FindCallback<PostPCosmetiques>() {
                    @Override
                    public void done(List<PostPCosmetiques> posts, ParseException e) {
                        if (e != null) {
                            Log.d(TAG, "error with query");
                            e.printStackTrace();
                            return;
                        }
                        mPosts.addAll(posts);
                        adapter.notifyDataSetChanged();
                        for (int i = 0; i < posts.size(); i++){
                            PostPCosmetiques post = posts.get(i);
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
