package com.InnovaTechno.homemarket.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.InnovaTechno.homemarket.Categories.Adapter.AMenagersAdapter;
import com.InnovaTechno.homemarket.Categories.Post.PostAMenagers;
import com.InnovaTechno.homemarket.R;
import com.InnovaTechno.homemarket.SignUpActivity;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Articles_Menagers  extends AppCompatActivity {
    public static final String TAG ="Articles_menagers";
    private AMenagersAdapter adapter;
    private List<PostAMenagers> mPosts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles_menagers);
        this.setTitle("Articles Ménagers");

           //create the data source
            mPosts = new ArrayList<>();
            //create the adapter
            adapter = new AMenagersAdapter(this, mPosts);
            RecyclerView rv_articles_menagers = (RecyclerView) findViewById(R.id.rv_articles_menagers);
        rv_articles_menagers.setLayoutManager(new GridLayoutManager(this, 2));
        rv_articles_menagers.setAdapter(adapter);

            queryPostAMenagers();
        }

        private void queryPostAMenagers() {
            ParseQuery<PostAMenagers> postAMenagersQuery = new ParseQuery<PostAMenagers>(PostAMenagers.class);
            postAMenagersQuery.include(PostAMenagers.KEY_DEVISE);
            postAMenagersQuery.include(PostAMenagers.KEY_PRICE);
            postAMenagersQuery.findInBackground(new FindCallback<PostAMenagers>() {
                @Override
                public void done(List<PostAMenagers> posts, ParseException e) {
                    if (e != null) {
                        Log.d(TAG, "error with query");
                        e.printStackTrace();
                        return;
                    }
                    mPosts.addAll(posts);
                    adapter.notifyDataSetChanged();
                    for (int i = 0; i < posts.size(); i++){
                        PostAMenagers post = posts.get(i);
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
