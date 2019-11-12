package com.InnovaTechno.homemarket.Markets_Details;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.InnovaTechno.homemarket.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class MarketsDetailsActivity extends AppCompatActivity {

    public static final String TAG = "MarketsDetailsActivity";

    ImageView ivDetailsMarkets;
    TextView tvMarketsDescription;
    Button btnAdresse;
    TextView tvAdresse;
    Button btnTelephone;
    TextView tvTelephone;
    Button btnServices;
    TextView tvServices;
    TextView tvRate;
    RatingBar rbMarkets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_markets);
        //set the back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivDetailsMarkets = findViewById(R.id.ivDetailsMarkets);
        tvMarketsDescription = findViewById(R.id.tvMarketsDescription);
        btnAdresse = findViewById(R.id.btnAdresse);
        tvAdresse = findViewById(R.id.tvAdresse);
        btnTelephone = findViewById(R.id.btnTelephone);
        tvTelephone = findViewById(R.id.tvTelephone);
        btnServices = findViewById(R.id.btnServices);
        tvServices = findViewById(R.id.tvServices);
        tvRate = findViewById(R.id.tvRate);
        rbMarkets = findViewById(R.id.rbMarkets);

        //receive data
        Intent intent = getIntent();
        int image = intent.getExtras().getInt("Thumbnail");

        //setting the data
        ivDetailsMarkets.setImageResource(image);

        //queryMarketDetails();
        //todo-details
    }

    private void queryMarketDetails() {
        ParseQuery<MarketDetails> marketDetailsQuery = new ParseQuery<MarketDetails>(MarketDetails.class);
        marketDetailsQuery.include(MarketDetails.KEY_DESCRIPTION);
        marketDetailsQuery.include(MarketDetails.KEY_ADRESSE);
        marketDetailsQuery.include(MarketDetails.KEY_TELEPHONE);
        marketDetailsQuery.include(MarketDetails.KEY_SERVICES);
        marketDetailsQuery.findInBackground(new FindCallback<MarketDetails>() {
            @Override
            public void done(List<MarketDetails> details, ParseException e) {
                if (e != null) {
                    Log.d(TAG, "error with market details Query");
                    e.printStackTrace();
                    return;
                }

                for (int i = 0; i < details.size(); i++){
                    MarketDetails marketDetails = details.get(i);
                    Log.d(TAG, "MarketDetails: " + details.get(i).getDescription() + ", adresse" + marketDetails.getAdresse()
                            + ", telephone" + marketDetails.getTelephone() + ", services" + marketDetails.getServices());

                    //set the data
                    tvMarketsDescription.setText(marketDetails.getDescription());
                    tvAdresse.setText(marketDetails.getAdresse());
                    tvTelephone.setText(marketDetails.getTelephone());
                    tvServices.setText(marketDetails.getServices());

                }


            }
        });


    }
}

 

