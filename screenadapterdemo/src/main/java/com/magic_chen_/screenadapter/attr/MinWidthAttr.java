package com.magic_chen_.screenadapter.attr;

import android.os.Build;
import android.view.View;

import java.lang.reflect.Field;
/**
 * Created by cyy 2019.10.22
 */
public class MinWidthAttr extends AutoAttr {
    public MinWidthAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MIN_WIDTH;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val_w, int val_h) {
        try {
//            Method setMaxWidthMethod = view.getClass().getMethod("setMinWidth", int.class);
//            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore) {
        }

        view.setMinimumWidth(val_w);
    }

    public static int getMinWidth(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            return view.getMinimumWidth();
        try {
            Field minWidth = view.getClass().getField("mMinWidth");
            minWidth.setAccessible(true);
            return (int) minWidth.get(view);
        } catch (Exception ignore) {
        }
        return 0;
    }


    public static MinWidthAttr generate(int val, int baseFlag) {
        MinWidthAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MinWidthAttr(val, Attrs.MIN_WIDTH, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MinWidthAttr(val, 0, Attrs.MIN_WIDTH);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MinWidthAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
