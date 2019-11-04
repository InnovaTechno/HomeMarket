package com.InnovaTechno.homemarket;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.InnovaTechno.homemarket.adapter.ImageSliderAdapter;
import com.bumptech.glide.Glide;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Make activity fullScreen for better UI
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        progressBar = findViewById(R.id.siProgressbar);
        progressBar.setVisibility(View.GONE);

    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    //    getSupportActionBar().setTitle(null);

        //Image slider
        SliderView sliderView = findViewById(R.id.imageSlider);
        ImageSliderAdapter adapter = new ImageSliderAdapter(this);

        sliderView.setSliderAdapter(adapter);
        //set indicator animation by using SliderLayout.IndicatorAnimations.
        // :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setIndicatorAnimation(IndicatorAnimations.DROP);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        //set scroll delay in seconds :
        sliderView.setScrollTimeInSec(4);
        sliderView.startAutoCycle();


    btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(true);
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                login(email, password);
            }
        });

        progressBar.setVisibility(View.GONE);


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

    public void goToSignUpActivity(View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
        finish();
    }

}


