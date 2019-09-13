package com.InnovaTechno.homemarket;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {

    private TextView textView;
    private EditText etAdresse ;
    private EditText etPhone;
    private EditText etAPhone;
    private EditText etEmaill;
    private EditText etUsername;
    private EditText etPasswordd;
    private EditText etPassworddd;
    private Button btnCAccount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


    }
}
