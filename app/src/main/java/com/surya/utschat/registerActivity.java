package com.surya.utschat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnToOTPActivity = findViewById(R.id.btnToOTP);
        btnToOTPActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toOTP = new Intent(registerActivity.this, OTPActivity.class);
                startActivity(toOTP);
            }
        });
    }
}