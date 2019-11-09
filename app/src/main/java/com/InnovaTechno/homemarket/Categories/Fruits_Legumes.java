package com.InnovaTechno.homemarket.Categories;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.InnovaTechno.homemarket.Categories.Adapters.PostAdapter;
import com.InnovaTechno.homemarket.Categories.Models.Post;
import com.InnovaTechno.homemarket.R;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class Fruits_Legumes extends AppCompatActivity {

    public static final String TAG ="Fruits_Legumes";
    private PostAdapter adapter;
    private List<Post> mPosts;
    private StaggeredGridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Check the internet connection state
        if(!isConnected(Fruits_Legumes.this)) buildDialog(Fruits_Legumes.this).show();
        else {
            Toast.makeText(Fruits_Legumes.this,"Welcome", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_fruits_legumes);
        }

        //Set Title
        this.setTitle("Fruits et Légumes");
        //set the back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView rv_fruits_legumes = (RecyclerView) findViewById(R.id.rv_fruits_legumes);
        //set the animation
      //  LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_fall_down);
//        rv_fruits_legumes.setLayoutAnimation(animationController);


        //create the data source
        mPosts = new ArrayList<>();
        //create the adapter
        adapter = new PostAdapter(this, mPosts );
        //Check the internet connection state
        if(!isConnected(Fruits_Legumes.this)) buildDialog(Fruits_Legumes.this).show();
        else {
            manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            rv_fruits_legumes.setLayoutManager(manager);
       // rv_fruits_legumes.setLayoutManager(new GridLayoutManager(this, 2));
        rv_fruits_legumes.setAdapter(adapter);}


        queryPost();
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

    private void queryPost() {
        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.include(Post.KEY_DEVISE);
        postQuery.include(Post.KEY_PRICE);
        postQuery.include(Post.KEY_DESCRIPTION);
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null) {
                    Log.d(TAG, "error with query");
                    e.printStackTrace();
                    return;
                }
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();
                for (int i = 0; i < posts.size(); i++){
                    Post post = posts.get(i);
                    Log.d(TAG, "Post: " + posts.get(i).getName() + ",devise" + post.getDevise() + ", price2" + post.getPrice() +
                            ", description" + post.getDescription());
                }
            }
        });

                }

    //The return of the animation after changing the data
    private void runLayoutAnimation (RecyclerView rv_fruits_legumes){
        Context context = rv_fruits_legumes.getContext();
        LayoutAnimationController layoutAnimationController =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        rv_fruits_legumes.setLayoutAnimation(layoutAnimationController);
        rv_fruits_legumes.getAdapter().notifyDataSetChanged();
        rv_fruits_legumes.scheduleLayoutAnimation();

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
