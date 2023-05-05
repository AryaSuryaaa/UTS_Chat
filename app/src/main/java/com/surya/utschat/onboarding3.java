package com.surya.utschat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class onboarding3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding3);

        Button btnOnboarding3 = findViewById(R.id.btnOnboarding3);
        btnOnboarding3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcome = new Intent(onboarding3.this, welcomeActivity.class);
                startActivity(welcome);
            }
        });
    }
}