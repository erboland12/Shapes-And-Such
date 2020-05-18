package com.shapesandsuch.shapesandsuch.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class Triangle extends BShape {

    private float x;
    private float y;
    private float base;
    private float height;
    private boolean inverted;
    private int p1X;
    private int p1Y;
    private int p2X;
    private int p2Y;
    private int p3X;
    private int p3Y;
    private int index;
    private String name;
    private Paint p;
    private int numRotations;

    public Triangle(float x, float y, float b, float h, boolean inverted, int index, String name, Paint p, int nr){
        this.x = x;
        this.y = y;
        this.base = b;
        this.height = h;
        this.inverted = inverted;
        this.index = index;
        this.name = name;
        this.p = p;
        this.numRotations = nr;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public float getBase(){
        return this.base;
    }

    public void setBase(float b){
        this.base = b;
    }

    public float getHeight(){
        return this.height;
    }

    public void setHeight(float h){
        this.height = h;
    }

    public boolean getInverted(){
        return this.inverted;
    }

    public void setInverted(boolean inv){
        this.inverted = inv;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void setIndex(int i) {
        this.index = i;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Paint getPaint() {
        return p;
    }

    @Override
    public void setPaint(Paint p) {
        this.p = p;
    }

    public int getNumRotations(){ return numRotations; }

    public void setNumRotations(int nr){ this.numRotations = nr; }

    @Override
    public void rotate() {
        this.numRotations++;
    }

    @Override
    public void updateCoordinates(float newX, float newY) {
        this.x = newX;
        this.y = newY;
    }

    @Override
    public void draw(Canvas c, int x, int y, Paint p) {
        setUpPoints(x, y, (int) this.base, (int) this.height, this.inverted);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(p1X, p1Y);
        path.lineTo(p2X,p2Y);
        path.lineTo(p3X,p3Y);
        path.close();

        c.drawPath(path, p);
    }

    private void setUpPoints(int x, int y, int base, int height, boolean inverted){
        int checkInversion = inverted? y + height: y - height;
        if(numRotations == 0){
            p1X = x;
            p1Y = y;

            p2X = (x + base/2);
            p2Y = y - height;

            p3X = (x + base);
            p3Y = y;
        }
        else if (numRotations == 1){
            p1X = x;
            p1Y = y - base;

            p2X = x + height;
            p2Y = y - base/2;

            p3X = x;
            p3Y = y;
        }
        else if(numRotations == 2){
            p1X = x;
            p1Y = y - height;

            p2X = (x + base/2);
            p2Y = y;

            p3X = (x + base);
            p3Y = y - height;

        }

        else if(numRotations == 3){
            p1X = x + height;
            p1Y = y - base;

            p2X = x;
            p2Y = y - base/2;

            p3X = x + height;
            p3Y = y;

//            numRotations = -1;
        }

//        p1 = new Point((int) x, (int) y);
//        int pointX = (int) x + (int) base/2;
//        int pointY = (int) (inverted?  y + height : y - height);
//
//        p2 = new Point(pointX,pointY);
//        p3 = new Point((int) x+(int) base, (int) y);
//        this.p1 = new Point((int) x, (int) y);
//        this.p2 = new Point((int) (x + base/2), (int) (inverted?  y + height : y - height));
//        this.p3 = new Point((int) (x + base), (int) y);
    }

    @Override
    public String defaultName() {
        return "Triangle";
    }
}
