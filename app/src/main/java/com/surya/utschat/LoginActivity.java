package com.surya.utschat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {


    EditText nomorLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // New Object NomorTeleponList.Class
        NomorTeleponList nomorTeleponList = new NomorTeleponList(LoginActivity.this);

        // Inisialisasi layout
        nomorLogin = findViewById(R.id.nomorLogin);


        Button btnVerifLogin = findViewById(R.id.btnVerifLogin);
        btnVerifLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verifNomorInput = "0" + nomorLogin.getText().toString();

                nomorTeleponList.getNomorTelepon();

                if(nomorTeleponList.isPhoneNumberSaved(verifNomorInput)) {
                    Intent toMain = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(toMain);
                } else {
                    Log.d("NomorTelepon", "Nomor Telepon " + verifNomorInput + " belum terimpan");
                }
            }
        });
    }
}