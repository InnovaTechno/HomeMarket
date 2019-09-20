package com.InnovaTechno.homemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {
    private ImageView ivWelcome;
    private ImageView ivLogo;
     private Button btnWelcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ivWelcome = findViewById(R.id.ivWelcome);
        ivLogo = findViewById(R.id.ivLogo);
        btnWelcome = findViewById(R.id.btnWelcome);

        }


    public void goToMainActivity(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
