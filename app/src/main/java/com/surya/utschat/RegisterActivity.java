package com.surya.utschat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class RegisterActivity extends AppCompatActivity {

    EditText daftarNomorHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        daftarNomorHP = findViewById(R.id.daftarNomorHP);

        Button btnToOTPActivity = findViewById(R.id.btnToOTP)   ;
        btnToOTPActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomorHP = "0" + daftarNomorHP.getText().toString();

                Intent toOTP = new Intent(RegisterActivity.this, OTPActivity.class);
                toOTP.putExtra("phoneNumber", nomorHP);
                startActivity(toOTP);
            }
        });
    }
}