package com.magic_chen_.screenadapter.attr;

import android.view.View;

/**
 * Created by cyy 2019.10.22
 */
public class PaddingBottomAttr extends AutoAttr {
    public PaddingBottomAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.PADDING_BOTTOM;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val_w, int val_h) {
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
        int l = view.getPaddingLeft();
        int t = view.getPaddingTop();
        int r = view.getPaddingRight();
        int b = val;
        view.setPadding(l, t, r, b);

    }


    public static PaddingBottomAttr generate(int val, int baseFlag) {
        PaddingBottomAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new PaddingBottomAttr(val, Attrs.PADDING_BOTTOM, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new PaddingBottomAttr(val, 0, Attrs.PADDING_BOTTOM);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new PaddingBottomAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
