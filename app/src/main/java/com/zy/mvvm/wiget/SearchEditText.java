package com.zy.mvvm.wiget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.wiget
 * @ClassName: SearchEditText
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/18 13:13
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/18 13:13
 * @UpdateRemark:
 * @Version: 1.0
 */
public class SearchEditText extends androidx.appcompat.widget.AppCompatEditText {
    private Paint mPaint;
    private RectF rectF;

    public SearchEditText(@NonNull Context context) {
        super(context);
        initPaint();
    }


    private void initPaint() {
        mPaint=new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.BLUE);

        setBackground(null);
//        setGravity(Gravity.RIGHT);
//        requestFocus(FOCUS_RIGHT);

    }

    public SearchEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public SearchEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private float rx=30.0f;
    private float ry=30.0f;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF = new RectF(0+15,0+15,getMeasuredWidth()-15,getMeasuredHeight()-15);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRoundRect(rectF,rx,ry,mPaint);
    }
}
