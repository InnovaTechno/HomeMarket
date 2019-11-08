package com.InnovaTechno.homemarket.Items_Detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.InnovaTechno.homemarket.Categories.Models.Post;
import com.InnovaTechno.homemarket.GlideApp;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.parse.ParseFile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.InnovaTechno.homemarket.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class ItemDetails extends AppCompatActivity {

    private RelatedItemsAdapter adapter;
    private List<RelatedItems> relatedItems;
    private Context context;
    private List <Post> post;
    private static final String TAG = "RelatedItems";
    private int counter;
    private int priceChange;

    ImageView ivItemDetails;
    TextView tvName, tv_Price, tv_Devise, tvCounter, tvDescription;
    Button btnPlus, btnMoins, btnAdd_to_Cart, btnBuy_Now;

    private View.OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnMoins :
                    minusCounter();
                    break;
                case R.id.btnPlus :
                    plusCounter();
                    break;
            }

        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        //set the back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivItemDetails = findViewById(R.id.ivItemDetails);
        tvName = findViewById(R.id.tvName);
        tv_Price = findViewById(R.id.tv_Price);
        tv_Devise = findViewById(R.id.tv_Devise);
        tvCounter = findViewById(R.id.tvCounter);
        tvDescription = findViewById(R.id.tvDescription);
        btnPlus = findViewById(R.id.btnPlus);
        btnMoins = findViewById(R.id.btnMoins);
        btnAdd_to_Cart = findViewById(R.id.btnAdd_to_Cart);
        btnBuy_Now = findViewById(R.id.btnBuy_Now);

        btnMoins.setOnClickListener(clickListener);
        tvCounter.setOnClickListener(clickListener);
        btnPlus.setOnClickListener(clickListener);

        //receive data for the details
        Intent intent = getIntent();
        String name = intent.getExtras().getString("name");
        String price2 = intent.getExtras().getString("price2");
        String devise = intent.getExtras().getString("devise");
        String description = intent.getExtras().getString("description");
       // String image = intent.getExtras().getString("productImage");

        //Setting the data
        tv_Price.setText(price2);
        tv_Devise.setText(devise);
        tvName.setText(name);
        tvDescription.setText(description);



        //Related Items adapter
        relatedItems = new ArrayList<>();
        //create the adapter
        adapter = new RelatedItemsAdapter(this, relatedItems);
        RecyclerView rvRelated_items = findViewById(R.id.rvRelated_items);
        rvRelated_items.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        //Set the adapter
        rvRelated_items.setAdapter(adapter);
        QueryRelatedItems();
        initCounter();

    }

    private void initCounter() {
        counter = 1;
        tvCounter.setText(counter + "");
    }
    //Minus Counter
    private void minusCounter() {
        counter --;
        tvCounter.setText(counter + "");
    }
    //plus Counter
    private void plusCounter() {
        counter ++;
        tvCounter.setText(counter + "");

    }


    private void QueryRelatedItems() {
            ParseQuery<RelatedItems> relatedItemsQuery = new ParseQuery<RelatedItems>(RelatedItems.class);
            relatedItemsQuery.include(RelatedItems.KEY_NAME);
            relatedItemsQuery.include(RelatedItems.KEY_DEVISE);
            relatedItemsQuery.include(RelatedItems.KEY_PRICE);
            relatedItemsQuery.findInBackground(new FindCallback<RelatedItems>() {

                @Override
                public void done(List<RelatedItems> items, ParseException e) {
                    if (e != null) {
                        Log.d(TAG, "Error with Related Items Query");
                        e.printStackTrace();
                        return;
                    }

                    relatedItems.addAll(items);
                    adapter.notifyDataSetChanged();

                    for (int i = 0; i < items.size(); i++) {
                        RelatedItems relatedItems = items.get(i);
                        Log.d(TAG, "Post: " + items.get(i).getName() + ",devise" + relatedItems.getDevise()
                                + ", price" + relatedItems.getPrice());
                    }
                }
            });
        }




}




