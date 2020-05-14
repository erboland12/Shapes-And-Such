package com.shapesandsuch.shapesandsuch.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class BShape {

    public abstract float getX();
    public abstract void setX(float x);

    public abstract float getY();
    public abstract void setY(float y);

    public abstract int getIndex();
    public abstract void setIndex(int i);

    public abstract String getName();
    public abstract void setName(String name);

    public abstract Paint getPaint();
    public abstract void setPaint(Paint p);

    public abstract void rotate();
    public abstract void updateCoordinates(float newX, float newY);
    public abstract void draw(Canvas c, float x, float y, Paint p);

    public abstract String defaultName();
}
