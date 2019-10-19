package com.magic_chen_.screenadapterdemo.attr;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhy on 15/12/5.
 */
public class MarginBottomAttr extends AutoAttr {
    public MarginBottomAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MARGIN_BOTTOM;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val_w, int val_h) {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
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
        lp.bottomMargin = val;
    }

    public static MarginBottomAttr generate(int val, int baseFlag) {
        MarginBottomAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MarginBottomAttr(val, Attrs.MARGIN_BOTTOM, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MarginBottomAttr(val, 0, Attrs.MARGIN_BOTTOM);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MarginBottomAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
