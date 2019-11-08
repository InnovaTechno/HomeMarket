package com.InnovaTechno.homemarket.PaymentMethods;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.InnovaTechno.homemarket.R;


public class ChoosePayments  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_payments);
        setTitle("Choose Payment");
        //set the back arrow button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //@Onclick for cards Method
    public void chooseCardsMethod(View view) {
        Intent card = new Intent(this, CardsMethod.class);
        startActivity(card);
    }

    public void editMethods(View view) {
        Intent edit = new Intent(this, EditMethods.class);
        startActivity(edit);
    }

}
