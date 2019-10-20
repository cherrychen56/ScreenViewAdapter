package com.magic_chen_.screenadapter.attr;

import android.view.View;

/**
 * Created by zhy on 15/12/5.
 */
public class PaddingAttr extends AutoAttr {
    public PaddingAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.PADDING;
    }

    @Override
    public void apply(View view) {
        int l, t, r, b;
        if (useDefault()) {
            l = r = getPercentWidthSize();
            t = b = getPercentHeightSize();
            view.setPadding(l, t, r, b);
            return;
        }
        super.apply(view);
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val_w, int val_h) {
        view.setPadding(val_w, val_w, val_w, val_w);
    }


}
