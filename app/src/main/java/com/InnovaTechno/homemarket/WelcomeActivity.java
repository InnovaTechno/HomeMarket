package com.InnovaTechno.homemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.parse.ParseUser;

public class WelcomeActivity extends AppCompatActivity {
    private ImageView ivWelcome;
    private ImageView ivLogo;
     private Button btnWelcome;

     private Button btnSignIn;
     private Button btnSignUp;
    ParseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //let's make the activity full screen for better ui
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();

        currentUser = ParseUser.getCurrentUser();
        btnSignUp = findViewById(R.id.btnSignUp);
        ivWelcome = findViewById(R.id.ivWelcome);
        ivLogo = findViewById(R.id.ivLogo);
        btnWelcome = findViewById(R.id.btnWelcome);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    public void goToMainActivity(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
