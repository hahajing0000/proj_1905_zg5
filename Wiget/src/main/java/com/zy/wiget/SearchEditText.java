package com.zy.wiget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.wiget
 * @ClassName: SearchEditText
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/18 8:02
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/18 8:02
 * @UpdateRemark:
 * @Version: 1.0
 */
public class SearchEditText extends androidx.appcompat.widget.AppCompatEditText {
    private Paint mPaint;
    private int rx=20;
    private int ry=20;
    private int strokeWidth=3;
    private int halfStrokeWidth=strokeWidth/2;
    private int borderColor=Color.GRAY;
    public SearchEditText(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        mPaint=new Paint();
        mPaint.setColor(borderColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(strokeWidth);

        this.setBackground(null);
    }

    public SearchEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SearchEditText);
        borderColor = typedArray.getColor(R.styleable.SearchEditText_borderColor, borderColor);

        typedArray.recycle();
        initPaint();
    }

    public SearchEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF=new RectF(halfStrokeWidth,halfStrokeWidth,getMeasuredWidth()-halfStrokeWidth,getMeasuredHeight()-halfStrokeWidth);
        canvas.drawRoundRect(rectF,rx,ry,mPaint);
    }
}
