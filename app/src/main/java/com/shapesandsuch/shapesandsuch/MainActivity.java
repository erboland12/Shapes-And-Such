package com.shapesandsuch.shapesandsuch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shapesandsuch.shapesandsuch.shapes.BShape;
import com.shapesandsuch.shapesandsuch.shapes.CanvasView;
import com.shapesandsuch.shapesandsuch.shapes.Circle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private CanvasView view;
    public static ArrayList<BShape> shapes = new ArrayList<>();
    private static final String DEBUG_TAG = "Gestures";
    private GestureDetectorCompat mDetector;

    private int index = 0;
    private int rad = 150;
    private boolean scrolling = false;

    public static float currX = 150;
    public static float currY = 150;
    public int currIndex = -1;
    public static String currName = "Circle";
    public static Paint currPaint = new Paint();

    private Button mAddBtn;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new CanvasView(this);
        setContentView(view);

        currPaint.setColor(Color.RED);
        currPaint.setStyle(Paint.Style.FILL);
//        currPaint.setAntiAlias(true);
//        currPaint.setDither(true);
        
        mAddBtn = view.findViewById(R.id.add_btn);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creates new shape, adds it to array of shapes, and updates current shape to be the one most recently added

                BShape s = new Circle(rad, currX, currY, currIndex, currName, currPaint);
//                updateToCurrentShape(shapes);
                shapes.add(s);
                ++currIndex;

                //Updates canvas view
                view.invalidate();

                Toast.makeText(v.getContext(), "Index: " + currIndex, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(shapes.size() > 0){
            switch (event.getAction()){
                case MotionEvent.ACTION_MOVE:
                    if(!scrolling){
                        //Allows touch-based movement for currently selected shape
                        BShape s = shapes.get(currIndex);
                        s.updateCoordinates(event.getX(), event.getY());
                        view.invalidate();
//                        Toast.makeText(this, "Coordinates updated: " + event.getX() + ", " + event.getY(),
//                                        Toast.LENGTH_SHORT).show();

                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
        }
        else{
            Toast.makeText(this, "There are no shapes on the canvas.", Toast.LENGTH_SHORT).show();
        }
        return super.onTouchEvent(event);
    }
}

