package com.magic_chen_.screenadapter.attr;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhy on 15/12/5.
 */
public class MarginTopAttr extends AutoAttr {
    public MarginTopAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.MARGIN_TOP;
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
        lp.topMargin = val;

    }


    public static MarginTopAttr generate(int val, int baseFlag) {
        MarginTopAttr attr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                attr = new MarginTopAttr(val, Attrs.MARGIN_TOP, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MarginTopAttr(val, 0, Attrs.MARGIN_TOP);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MarginTopAttr(val, 0, 0);
                break;
        }
        return attr;
    }
}
