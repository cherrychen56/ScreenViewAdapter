package com.magic_chen_.screenadapter;


import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by cyy 2019.10.22
 */
public class BaseActivity extends Activity {

    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        View view = BaseApplication.onMyCreateView(name, context, attrs);
        if (view != null) {
            return view;
        }
        return super.onCreateView(name, context, attrs);
    }
}
