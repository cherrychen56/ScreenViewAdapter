package com.magic_chen_.screenadapter.attr;

import android.os.Build;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by cyy 2019.10.22
 */
public class MinHeightAttr extends AutoAttr {
    public MinHeightAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MIN_HEIGHT;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val_w, int val_h) {
        try {
            float val_w_f = val_w;
            float val_w_h = val_h;
            int val;
            if (val_w_f / val_w_h > 1.05f) {
                val = val_h;
            } else if (val_w_f / val_w_h < 0.95f) {
                val = val_h;
            } else {
                val = val_w;
            }
            view.setMinimumHeight(val);
//            Method setMaxWidthMethod = view.getClass().getMethod("setMinHeight", int.class);
//            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore) {
        }
    }

    public static MinHeightAttr generate(int val, int baseFlag) {
        MinHeightAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MinHeightAttr(val, Attrs.MIN_HEIGHT, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MinHeightAttr(val, 0, Attrs.MIN_HEIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MinHeightAttr(val, 0, 0);
                break;
        }
        return attr;
    }

    public static int getMinHeight(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return view.getMinimumHeight();
        } else {
            try {
                Field minHeight = view.getClass().getField("mMinHeight");
                minHeight.setAccessible(true);
                return (int) minHeight.get(view);
            } catch (Exception e) {
            }
        }

        return 0;
    }

}
