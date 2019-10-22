package com.magic_chen_.screenadapter.utils;

import android.util.Log;

/**
 * Created by cyy 2019.10.22
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
