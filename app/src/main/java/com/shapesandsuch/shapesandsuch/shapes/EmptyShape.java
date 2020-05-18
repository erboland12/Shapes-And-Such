package com.shapesandsuch.shapesandsuch.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;

public class EmptyShape extends BShape {

    public EmptyShape(){};

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public void setX(float x) {

    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public void setY(float y) {

    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public void setIndex(int i) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public Paint getPaint() {
        return null;
    }

    @Override
    public void setPaint(Paint p) {

    }

    @Override
    public void rotate() {

    }

    @Override
    public void updateCoordinates(float newX, float newY) {

    }

    @Override
    public void draw(Canvas c, int x, int y, Paint p) {

    }

    @Override
    public String defaultName() {
        return null;
    }
}
