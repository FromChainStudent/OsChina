package com.example.oschina.utils;

import android.util.Log;

/**
 * Created by YC on 2017/5/10.
 */

public class LogUtils {

    private static boolean log = true;

    public static void i(String str, String s){
        if (log){
            Log.i(str, s);
        }
    }
}
