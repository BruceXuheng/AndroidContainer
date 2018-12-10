package com.study.test.testapplication.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {

    Paint mPaint1;

    /**
     * 如果View实在Java代码里面new，则调用第一个构造函数
     * @param context
     */
    public CircleView(Context context) {
        super(context);
        //构造函数初始化画笔操作
        init();
    }

    /**
     * 如果View是在XML里声明，则调用第二个构造函数
     * 自定义属性从 AttributeSet参数传入
     * @param context
     * @param attrs
     */

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);init();
    }

    /**
     * 不会主动调用，一般在第二个构造函数主动调用
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);init();
    }

    /**
     * API后调用
     * 不会自动调用，一般第二个构造函数主动调用
     * view拥有style
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);init();
    }

    private void init() {
        mPaint1 =new Paint();
        mPaint1.setColor(Color.BLUE);
        mPaint1.setStrokeWidth(5f);
        mPaint1.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        int radio = Math.min(width,height)/2;

        canvas.drawCircle(width/2,height/2,radio,mPaint1);
    }
}
