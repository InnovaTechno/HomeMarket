package com.InnovaTechno.homemarket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.InnovaTechno.homemarket.Models.CardInfo;
import com.parse.ParseException;
import com.parse.SaveCallback;

public class CreditCardInfo extends AppCompatActivity {

    private final String TAG = "CreditCardInfo";
    Button saveBtn;
    TextView etCardNumberr, etCardName, etExpDate;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_card_info);
        setTitle("Edit Profile");

        saveBtn = findViewById(R.id.saveBtn);
        etCardNumberr = findViewById(R.id.etCardNumberr);
        etCardName = findViewById(R.id.etCardName);
        etExpDate = findViewById(R.id.etExpDate);
        progressBar = findViewById(R.id.siProgressbar);
        progressBar.setVisibility(View.GONE);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setIndeterminate(true);
                String cardNumber = etCardNumberr.getText().toString();
                String cardHolderName = etCardName.getText().toString();
                String expDate = etExpDate.getText().toString();

                savePost(cardNumber, cardHolderName, expDate);
            }
        });
        progressBar.setVisibility(View.GONE);


}

    private void savePost(String cardNumber, String cardHolderName, String expDate) {
        CardInfo cardInfo = new CardInfo();
        cardInfo.setNumber(cardNumber);
        cardInfo.setName(cardHolderName);
        cardInfo.setDate(expDate);
        cardInfo.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e!= null){
                    Log.d(TAG, "error while saving");
                    e.printStackTrace();
                    return;
                }
                Toast.makeText(CreditCardInfo.this, "Saved", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "SUCCESS!!");
                etCardNumberr.setText("");
                etCardName.setText("");
                etExpDate.setText("");
                goToProfile();
            }
        });
    }

    private void goToProfile() {
        Log.d(TAG, "Navigating to MainActivity");
        Intent p = new Intent(this, Profile.class);
        startActivity(p);
        finish();
    }
}
