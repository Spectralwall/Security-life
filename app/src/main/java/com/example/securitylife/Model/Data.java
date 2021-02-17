package com.example.securitylife.Model;

import android.util.Log;

public class Data {
    public static int key;


    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        Data.key = key;
    }

    public static void seeKey(){
        Log.i("chiave di criptazione", Integer.toString(getKey()));
    }
}
