package com.magic_chen_.screenadapterdemo.utils;

import android.util.Log;

/**
 * Created by zhy on 15/11/18.
 */
public class L {
    public static boolean debug = true;
    private static final String TAG = "AUTO_LAYOUT";

    public static void e(String msg) {
        if (debug) {
            Log.e(TAG, msg);
        }
    }


}
