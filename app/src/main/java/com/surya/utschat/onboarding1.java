package com.surya.utschat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class onboarding1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding1);

        Button btnOnBoarding = findViewById(R.id.btnOB1);
        btnOnBoarding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent onboard2 = new Intent(onboarding1.this, onboarding2.class);
                startActivity(onboard2);
            }
        });
    }
}