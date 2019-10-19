package com.magic_chen_.screenadapterdemo.attr;

import android.util.Log;
import android.view.View;

import com.magic_chen_.screenadapterdemo.utils.AutoUtils;
import com.magic_chen_.screenadapterdemo.utils.L;


/**
 * Created by zhy on 15/12/4.
 */
public abstract class AutoAttr {
    public static final int BASE_WIDTH = 1;
    public static final int BASE_HEIGHT = 2;
    public static final int BASE_DEFAULT = 3;

    protected int pxVal;
    protected int baseWidth;
    protected int baseHeight;

    /*
    protected boolean isBaseWidth;
    protected boolean isBaseDefault;

    public AutoAttr(int pxVal)
    {
        this.pxVal = pxVal;
        isBaseDefault = true;
    }

    public AutoAttr(int pxVal, boolean isBaseWidth)
    {
        this.pxVal = pxVal;
        this.isBaseWidth = isBaseWidth;
    }
 */

    public AutoAttr(int pxVal, int baseWidth, int baseHeight) {
        this.pxVal = pxVal;
        this.baseWidth = baseWidth;
        this.baseHeight = baseHeight;
    }

    public void apply(View view) {

        boolean log = view.getTag() != null && view.getTag().toString().equals("auto");

        if (log) {
            L.e(" pxVal = " + pxVal + " ," + this.getClass().getSimpleName());
        }
        //todo 修改为宽按宽匹配，高按高匹配
        int val, val_W, val_H;
        val_W = getPercentWidthSize();
        val_H = getPercentHeightSize();
        if (useDefault()) {
            val = defaultBaseWidth() ? getPercentWidthSize() : getPercentHeightSize();
            if (log) {
                L.e(" useDefault val= " + val);
            }
        } else if (baseWidth()) {
            val = getPercentWidthSize();
            if (log) {
                L.e(" baseWidth val= " + val);
            }
        } else {
            val = getPercentHeightSize();
            if (log) {
                L.e(" baseHeight val= " + val);
            }
        }
        Log.d("AutoLayout_cyy", "   val:" + val + "  val_w:" + val_W + "  val_h:" + val_H);
        if (val > 0)
            val = Math.max(val, 1);//for very thin divider
        if (val_W > 0)
            val_W = Math.max(val_W, 1);//for very thin divider
        if (val > 0)
            val_H = Math.max(val_H, 1);//for very thin divider
        execute(view, val_W, val_H);
    }

    protected int getPercentWidthSize() {
        return AutoUtils.getPercentWidthSizeBigger(pxVal);
    }

    protected int getPercentHeightSize() {
        return AutoUtils.getPercentHeightSizeBigger(pxVal);
    }


    protected boolean baseWidth() {
        return contains(baseWidth, attrVal());
    }

    protected boolean useDefault() {
        return !contains(baseHeight, attrVal()) && !contains(baseWidth, attrVal());
    }

    protected boolean contains(int baseVal, int flag) {
        return (baseVal & flag) != 0;
    }

    protected abstract int attrVal();

    protected abstract boolean defaultBaseWidth();

    protected abstract void execute(View view, int val_w, int val_h);


    @Override
    public String toString() {
        return "AutoAttr{" +
                "pxVal=" + pxVal +
                ", baseWidth=" + baseWidth() +
                ", defaultBaseWidth=" + defaultBaseWidth() +
                '}';
    }
}
