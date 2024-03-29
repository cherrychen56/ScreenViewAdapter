package com.magic_chen_.screenadapter.attr;

import android.view.View;

/**
 * Created by cyy 2019.10.22
 */
public class PaddingRightAttr extends AutoAttr {
    public PaddingRightAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.PADDING_RIGHT;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val_w, int val_h) {
        int l = view.getPaddingLeft();
        int t = view.getPaddingTop();
        int r = val_w;
        int b = view.getPaddingBottom();
        view.setPadding(l, t, r, b);

    }


    public static PaddingRightAttr generate(int val, int baseFlag) {
        PaddingRightAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new PaddingRightAttr(val, Attrs.PADDING_RIGHT, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new PaddingRightAttr(val, 0, Attrs.PADDING_RIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new PaddingRightAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
