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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.shapesandsuch.shapesandsuch.shapes.BShape;
import com.shapesandsuch.shapesandsuch.shapes.CanvasView;
import com.shapesandsuch.shapesandsuch.shapes.Circle;
import com.shapesandsuch.shapesandsuch.shapes.EmptyShape;
import com.shapesandsuch.shapesandsuch.shapes.Triangle;

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

        //Initializes shape spinner and populates list
        String[] shapesList = new String[] {"Circle", "Triangle", "Rectangle", "Square"};
        final Spinner mShapeList = view.findViewById(R.id.shape_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, shapesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mShapeList.setAdapter(adapter);

        //Creates add shape button and handles inputs appropriately
        Button mAddBtn = view.findViewById(R.id.add_btn);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creates new shape, adds it to array of shapes, and updates current shape to be the one most recently added
                String typeOfShape = mShapeList.getSelectedItem().toString();
                BShape s = new EmptyShape();

                //Switch statement to check what type of shape is being added
                switch(typeOfShape){
                    case "Triangle":
                        s = new Triangle(currX, currY, 350, 400, false, currIndex, currName, currPaint, 0);
                        break;
                    case "Circle":
                        s = new Circle(rad, currX, currY, currIndex, currName, currPaint);
                        break;
                }

                //Highlights current non-static shape and checks for colors of shapes array
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

                //Updates canvas view
                view.invalidate();

                Toast.makeText(v.getContext(), "Index: " + currIndex, Toast.LENGTH_LONG).show();
            }
        });

        Button mRotateButton = findViewById(R.id.rotate_btn);
        mRotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BShape s = shapes.get(currIndex);
                s.rotate();
                Toast.makeText(v.getContext(), "Rotated " + s.defaultName(), Toast.LENGTH_SHORT).show();
                view.invalidate();
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

