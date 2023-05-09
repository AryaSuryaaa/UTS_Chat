package com.surya.utschat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OTPActivity extends AppCompatActivity {

    EditText inputOTP;
    Button btnResendOTP, btnVerifOTP;
    private String gPhoneNumber;
    OTP otp = new OTP();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);
        NomorTeleponList nomorTeleponList = new NomorTeleponList(OTPActivity.this);
        Bundle acc = getIntent().getExtras();

        gPhoneNumber = acc.getString("phoneNumber");

        btnResendOTP = findViewById(R.id.btnResendOTP);
        btnVerifOTP = findViewById(R.id.btnVerifOTP);
        inputOTP = findViewById(R.id.inputOTP);

        btnResendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(OTPActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    otp.sendOTP(gPhoneNumber);
                    Log.v("Hallo", String.valueOf(otp.getAngkaRandom()));
                } else {
                    ActivityCompat.requestPermissions(OTPActivity.this, new String[]{ Manifest.permission.SEND_SMS}, 100);
                }
            }
        });

        btnVerifOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputCodeOTP = inputOTP.getText().toString();
                String otpCode = String.valueOf(otp.getAngkaRandom());

                Log.v("Nomor", inputCodeOTP);
                Log.v("OTP", otpCode);
                if(inputCodeOTP.equals(otpCode)) {
                    nomorTeleponList.saveNomorTelepon(gPhoneNumber);

                    Intent toMain = new Intent(OTPActivity.this, MainActivity.class);
                    Toast.makeText(getApplicationContext(), "Nomor Tersimpan", Toast.LENGTH_SHORT).show();
                    startActivity(toMain);

                } else {
                    Toast.makeText(getApplicationContext(), "Kode OTP Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 100 ) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                otp.sendOTP(gPhoneNumber);
            } else {
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}