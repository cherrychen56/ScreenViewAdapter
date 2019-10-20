package com.magic_chen_.screenadapter.attr;

import android.view.View;

/**
 * Created by zhy on 15/12/5.
 */
public class PaddingTopAttr extends AutoAttr {
    public PaddingTopAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.PADDING_TOP;
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
        int t = val;
        int r = view.getPaddingRight();
        int b = view.getPaddingBottom();
        view.setPadding(l, t, r, b);
    }

    public static PaddingTopAttr generate(int val, int baseFlag) {
        PaddingTopAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new PaddingTopAttr(val, Attrs.PADDING_TOP, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new PaddingTopAttr(val, 0, Attrs.PADDING_TOP);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new PaddingTopAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
