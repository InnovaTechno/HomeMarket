package com.InnovaTechno.homemarket.PaymentMethods;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.InnovaTechno.homemarket.R;



public class CardsMethod extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6, e7, e8;
    TextView t1, t2,t3, t4, t5;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_method);
        e1 = (EditText) findViewById(R.id.et1); //code1
        e2 = (EditText) findViewById(R.id.et2); //...
        e3 = (EditText) findViewById(R.id.et3); //...
        e4 = (EditText) findViewById(R.id.et4); //code4
        e5 = (EditText) findViewById(R.id.et5); //name
        e6 = (EditText) findViewById(R.id.et6); //month
        e7 = (EditText) findViewById(R.id.et7); //year
        e8 = (EditText) findViewById(R.id.et8);//cvv

        t1 = (TextView) findViewById(R.id.code);
        t2 = (TextView) findViewById(R.id.cardholder);
        t4 = (TextView) findViewById(R.id.month);
        t5 = (TextView) findViewById(R.id.year);
        t5 = (TextView) findViewById(R.id.cvv);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.push_down);

                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl);
                relativeLayout.setAnimation(animation);

                String code1, code2, code3, code4;

                code1 = e1.getText().toString();
                code2 = e2.getText().toString();
                code3 = e3.getText().toString();
                code4 = e4.getText().toString();

                t1.setText(code1 + "\t"+ code2 + "\t" + code3 + "\t" + code4 + "\t");

                String name, month, year, cvv;

                name = e5.getText().toString();
                t2.setText(name);

                month = e5.getText().toString();
                t2.setText(month);

                year = e5.getText().toString();
                t2.setText(year);

                cvv = e5.getText().toString();
                t2.setText(cvv);
            }
        });


    }


}
