package com.surya.utschat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Random;

public class OTP {
    private int angkaRandom;

    public void generateAngkaRandom() {
        Random random = new Random();
       angkaRandom = random.nextInt(900000) + 100000;
    }

    public int getAngkaRandom() {
        return angkaRandom;
    }


    public void sendOTP(String phoneNumber) {
        generateAngkaRandom();

        String message = " is your verification code.";

        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> parts = smsManager.divideMessage(angkaRandom + message);
        String number = phoneNumber;
        smsManager.sendMultipartTextMessage(number, null,parts,null,null);
    }
}


