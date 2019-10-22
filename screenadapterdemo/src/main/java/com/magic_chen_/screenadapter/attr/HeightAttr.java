package com.magic_chen_.screenadapter.attr;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cyy 2019.10.22
 */
public class HeightAttr extends AutoAttr {
    public HeightAttr(int pxVal, int baseWidth, int baseHeight) {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal() {
        return Attrs.HEIGHT;
    }

    @Override
    protected boolean defaultBaseWidth() {
        return true;
    }

    @Override
    protected void execute(View view, int val_w, int val_h) {

        ViewGroup.LayoutParams lp = view.getLayoutParams();
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
        lp.height = val;
    }

    public static HeightAttr generate(int val, int baseFlag) {
        HeightAttr heightAttr = null;
        switch (baseFlag) {
            case AutoAttr.BASE_WIDTH:
                heightAttr = new HeightAttr(val, Attrs.HEIGHT, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                heightAttr = new HeightAttr(val, 0, Attrs.HEIGHT);
                break;
            case AutoAttr.BASE_DEFAULT:
                heightAttr = new HeightAttr(val, 0, 0);
                break;
        }
        return heightAttr;
    }


}
