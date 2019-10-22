package com.magic_chen_.screenadapter.attr;

import android.view.View;

import java.lang.reflect.Method;

/**
 * Created by cyy 2019.10.22
 */
public class MaxHeightAttr extends AutoAttr {
    public MaxHeightAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MAX_HEIGHT;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val_w, int val_h) {
        try {
            Method setMaxWidthMethod = view.getClass().getMethod("setMaxHeight", int.class);
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
            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore) {
        }
    }

    public static MaxHeightAttr generate(int val, int baseFlag) {
        MaxHeightAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MaxHeightAttr(val, Attrs.MAX_HEIGHT, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MaxHeightAttr(val, 0, Attrs.MAX_HEIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MaxHeightAttr(val, 0, 0);
                break;
        }
        return attr;
    }

    public static int getMaxHeight(View view) {
        try {
            Method setMaxWidthMethod = view.getClass().getMethod("getMaxHeight");
            return (int) setMaxWidthMethod.invoke(view);
        } catch (Exception ignore) {
        }
        return 0;
    }
}
