package com.InnovaTechno.homemarket.PaymentMethods;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.InnovaTechno.homemarket.Models.Methods;
import com.InnovaTechno.homemarket.R;

import java.util.List;

public class CardsMethod extends AppCompatActivity {

    private List<Methods> lsMethods;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_method);
    }


}
