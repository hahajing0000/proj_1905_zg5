package com.zy.mvvm.wiget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

import androidx.annotation.Nullable;
import io.reactivex.Maybe;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.mvvm.wiget
 * @ClassName: ProgressView
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/16 18:04
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/16 18:04
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ProgressView extends View {
    private Paint mPaint;
    private Paint txtPaint;

    //默认宽高
    private int defaultWidth=200;
    private int defaultHeight=200;

    //角度
    private int angle=360;

    //边框宽度
    private int strokeWidth=5;

    private RectF rectF;

    //弧形内间距
    private int padding=10;

    //默认文本值
    private int txtValue=5;

    private ProgressViewListener listener=null;

    public ProgressView(Context context) {
        super(context);
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setListener(ProgressViewListener listener) {
        this.listener = listener;
    }

    private int centerX=0;
    private int centerY=0;
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rectF = new RectF(0+padding,0+padding,getMeasuredWidth()-padding,getMeasuredHeight()-padding);
        centerX=getMeasuredWidth()/2;
        centerY=getMeasuredHeight()/2;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode==MeasureSpec.AT_MOST&&heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(defaultWidth,defaultHeight);
        }
        else if (widthMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(defaultWidth,heightSize);
        }else if (heightMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSize,defaultHeight);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimator();
        startTxtChange();
    }

    /**
     * 文本倒计时显示
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/16 19:14
     */ 
    private void startTxtChange() {
        final Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (txtValue==0){
                    timer.cancel();
                    return;
                }
                txtValue--;
            }
        },0,1000);

    }

    /**
     * 开始执行动画
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/16 18:58
     */ 
    public void startAnimator() {
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(0.0f,1.0f);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                angle= 360-(int) (360*animatedValue);
                invalidate();
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                listener.finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rectF,0,angle,false,mPaint);

        Rect bounds=new Rect();
        String text=String.valueOf(txtValue)+"S";
        txtPaint.getTextBounds(text,0,text.length(),bounds);
        float offSet=(bounds.top+bounds.bottom)/2;
        canvas.drawText(text,centerX,centerY-offSet,txtPaint);

//        Paint.FontMetrics fontMetrics=new Paint.FontMetrics();
//        mPaint.getFontMetrics(fontMetrics);
//        float offset=(fontMetrics.descent+fontMetrics.ascent)/2;
//        canvas.drawText("100",centerX,centerY-offset*2,txtPaint);
    }



    /**
     * 初始化画笔
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/16 18:06
     */ 
    private void initPaint() {
        mPaint=new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setDither(true);

        txtPaint=new Paint();
        txtPaint.setColor(Color.WHITE);
        txtPaint.setTextAlign(Paint.Align.CENTER);
        txtPaint.setTextSize(50);
    }

    public interface ProgressViewListener{
        void finish();
    }
}
