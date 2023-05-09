package com.surya.utschat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NomorTeleponList {
    private SharedPreferences teleponList;

    public NomorTeleponList(Context context) {
        teleponList = context.getSharedPreferences("nomorTeleponList", Context.MODE_PRIVATE);
    }

    public void saveNomorTelepon(String nomorTelepon) {
        SharedPreferences.Editor editor = teleponList.edit();
        int count = teleponList.getInt("count", 0);
        editor.putString("nomorTelepon" + count, nomorTelepon);
        editor.putInt("count", count + 1);
        editor.apply();
    }

    public void getNomorTelepon() {
        int count = teleponList.getInt("count", 0);
        for (int i = 0; i < count; i++) {
            String phoneNumber = teleponList.getString("nomorTelepon" + i , null);
            Log.d("PhoneNumber", "Phone number" + i + " : " + phoneNumber);
        }
    }

    public boolean isPhoneNumberSaved(String phoneNumber) {
        int count = teleponList.getInt("count", 0);
        for (int i = 0; i < count; i++) {
            String savedPhoneNumber = teleponList.getString("nomorTelepon" + i, null);
            if (savedPhoneNumber != null && savedPhoneNumber.equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

}
