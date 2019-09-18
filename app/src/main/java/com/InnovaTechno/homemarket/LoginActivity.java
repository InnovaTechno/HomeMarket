package com.InnovaTechno.homemarket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";


    private ImageView ivProfile;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                Toast.makeText(LoginActivity.this, "login succes", Toast.LENGTH_SHORT).show();
                login (email, password);
            }
        });


        }

    private void login(String email, String password) {


        ParseUser.logInInBackground(email, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    // TODO: better error notifications to users
                    Toast.makeText(LoginActivity.this, "There is a problem with your username or password, please check them and try again.", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "issue with login");
                    e.printStackTrace();
                    return;
                }
                Toast.makeText(LoginActivity.this, "Login succes", Toast.LENGTH_SHORT).show();
                goMainActivity();

            }
        });
    }



        private void goMainActivity() {
            Log.d(TAG, "Navigating to MainActivity");
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
}

