package com.InnovaTechno.homemarket.Categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.InnovaTechno.homemarket.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class Fruits_Legumes extends AppCompatActivity {

    public static final String TAG ="Fruits_Legumes";
    private PostAdapter adapter;
    private List<Post> mPosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits_legumes);

        //create the data source
        mPosts = new ArrayList<>();
        //create the adapter
        adapter = new PostAdapter(this, mPosts);
        RecyclerView rv_fruits_legumes = (RecyclerView) findViewById(R.id.rv_fruits_legumes);
        rv_fruits_legumes.setLayoutManager(new GridLayoutManager(this, 2));
        rv_fruits_legumes.setAdapter(adapter);

        queryPost();
    }

    private void queryPost() {
        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.include(Post.KEY_DEVISE);
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
                for (int i = 0; i < posts.size(); i++) {
                    Post post = posts.get(i);
                    Log.d(TAG, "Post : " + posts.get(i).getName() + ", devise" + post.getDevise());
                }

            }
        });
    }


}
