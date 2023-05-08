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

        NomorTeleponList nomorTeleponList = new NomorTeleponList(RegisterActivity.this);

        daftarNomorHP = findViewById(R.id.daftarNomorHP);


        Button btnToOTPActivity = findViewById(R.id.btnToOTP)   ;
        btnToOTPActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomorHP = daftarNomorHP.getText().toString();
                nomorTeleponList.saveNomorTelepon(nomorHP);

                Intent toOTP = new Intent(RegisterActivity.this, welcomeActivity.class);
                startActivity(toOTP);
            }
        });
    }
}