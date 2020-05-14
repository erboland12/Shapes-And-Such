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

    private int rad = 150;
    private boolean scrolling = false;

    //Variables to keep track of shape values
    public static float currX = 150;
    public static float currY = 150;
    public static int currIndex = -1;
    public static String currName = "Circle";
    public static Paint currPaint = new Paint();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new CanvasView(this);
        setContentView(view);

        //Sets default color...for now
        currPaint.setColor(Color.RED);
        currPaint.setStyle(Paint.Style.FILL);

        Button mAddBtn = view.findViewById(R.id.add_btn);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creates new shape, adds it to array of shapes, and updates current shape to be the one most recently added
                BShape s = new Circle(rad, currX, currY, currIndex, currName, currPaint);
                highlightCurrentShape(s);
                if(shapes.size() > 0){
                    for(BShape shape: shapes){
                        if(shape.getIndex() != currIndex){
                            shape.setPaint(currPaint);
                        }
                    }
                }
                shapes.add(s);
                ++currIndex;

//                highlightCurrentShape(shapes);
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

    //Helper function that highlights the shape that is currently non-static
    public static void highlightCurrentShape(BShape shape){
        if(shape.getIndex() == currIndex){
            Paint p = new Paint();
            p.setColor(Color.GREEN);
            p.setStyle(Paint.Style.FILL);

            shape.setPaint(p);
        }
        else{
            shape.setPaint(currPaint);
        }

    }
}

