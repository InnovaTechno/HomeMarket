package com.InnovaTechno.homemarket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class AccountActivity extends AppCompatActivity {

    private TextView textView;
    private EditText etName;
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

        etName = findViewById(R.id.etName);
        etAdresse = findViewById(R.id.etAdresse);
        etPhone = findViewById(R.id.etPhone);
        etAPhone = findViewById(R.id.etAPhone);
        etEmaill = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPasswordd = findViewById(R.id.etPasswordd);
        etPassworddd = findViewById(R.id.etPassworddd);
        btnCAccount = findViewById(R.id.btnCAccaount);
        //tvLoginBack = findViewById(R.id.tvLoginback);

        btnCAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().toString().isEmpty() || etAdresse.getText().toString().isEmpty() || etPhone.getText().toString().isEmpty() || etAPhone.getText().toString().isEmpty() || etEmaill.getText().toString().isEmpty() || etUsername.getText().toString().isEmpty() || etPasswordd.getText().toString().isEmpty() || etPassworddd.getText().toString().isEmpty()) {
                    Toast.makeText(AccountActivity.this, "field required", Toast.LENGTH_SHORT).show();
                    if (etPasswordd.getText().toString() != etPassworddd.getText().toString()) {
                        Toast.makeText(AccountActivity.this, "Two different passwords", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                String FirstName = etFirstName.getText().toString();
                String LastName = etLastName.getText().toString();
                String email = etEmailS.getText().toString();
                String password = etPasswordS.getText().toString();
                //String passwordConfirm = etPasswordConfirmS.getText().toString();

                //Create user
                ParseUser user = new ParseUser();

                user.setUsername(FirstName + LastName);
                user.setEmail(email);
                user.setPassword(password);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e != null) {
                            Log.e(TAG, "cannot signing up");
                            e.printStackTrace();
                            return;
                        }
                        etFirstName.setText("");
                        etLastName.setText("");
                        etEmailS.setText("");
                        etPasswordS.setText("");
                        etPasswordConfirmS.setText("");
                        etPasswordConfirmS.setText("");
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                });
            }

        });
    }
}
