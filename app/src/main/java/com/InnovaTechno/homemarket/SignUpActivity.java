package com.InnovaTechno.homemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";

    private EditText etFirstName;
    private EditText etLastName;
    private EditText etEmailS;
    private EditText etPasswordS;
    private EditText etPasswordConfirmS;
    private Button btnSignUp;

   // private TextView tvLoginBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etEmailS = findViewById(R.id.etEmailS);
        etPasswordS = findViewById(R.id.etPasswordS);
        btnSignUp = findViewById(R.id.btnSignUp);
        etEmailS = findViewById(R.id.etEmailS);
        etPasswordConfirmS = findViewById(R.id.etPasswordConfirmS);
        //tvLoginBack = findViewById(R.id.tvLoginback);


        final ParseACL acl = new ParseACL();
        acl.setPublicWriteAccess(true);
        acl.setPublicReadAccess(true);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etFirstName.getText().toString().isEmpty() || etLastName.getText().toString().isEmpty() || etEmailS.getText().toString().isEmpty() || etPasswordS.getText().toString().isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "field required", Toast.LENGTH_SHORT).show();
                    if (etPasswordS.getText().toString() != etPasswordConfirmS.getText().toString()) {
                        Toast.makeText(SignUpActivity.this, "Two different passwords", Toast.LENGTH_SHORT).show();
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
                user.setACL(acl);

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

//onClick for login if the user already have an account
    public void loginBack(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}
