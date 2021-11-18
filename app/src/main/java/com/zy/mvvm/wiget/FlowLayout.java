package com.zy.mvvm.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.wiget
 * @ClassName: FlowLayout
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/18 14:00
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/18 14:00
 * @UpdateRemark:
 * @Version: 1.0
 */
public class FlowLayout extends ViewGroup {

    private int width;
    private int height;

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    int lastX=0;
    int lastY=0;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        /**
         * 算法 学委版：
         * x 横轴 y 纵轴
         * x轴累加 判断总的ViewGroup宽  如果超出  y轴增加  x清理
         *
         */
        for (int i=0;i<childCount;i++){

            View subView = getChildAt(i);
            int subViewWidth=subView.getMeasuredWidth();
            int subViewHeight=subView.getMeasuredHeight();
            if ((lastX+subViewWidth)>width){

                lastX=0;
                lastY+=subViewHeight;
            }
            subView.layout(lastX,lastY,lastX+subViewWidth,lastY+subViewHeight);
            lastX+=subViewWidth;

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}
