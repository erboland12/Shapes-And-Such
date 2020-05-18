package com.shapesandsuch.shapesandsuch.shapes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.shapesandsuch.shapesandsuch.MainActivity;
import com.shapesandsuch.shapesandsuch.R;

import java.util.ArrayList;

public class CanvasView extends FrameLayout {
    public CanvasView(Context context){
        super(context);
        this.setWillNotDraw(false);
        initView();
    }
    public CanvasView(Context context, AttributeSet attrs){
        super(context, attrs);
        this.setWillNotDraw(false);
        initView();
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.my_view_layout, null);
        addView(view);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //Sets up paint

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setColor(Color.parseColor("#da4747"));

        for(BShape shape: MainActivity.shapes){
            shape.draw(canvas, (int) shape.getX(), (int) shape.getY(), shape.getPaint());
        }

    }

}
