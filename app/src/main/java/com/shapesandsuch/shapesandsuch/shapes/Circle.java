package com.shapesandsuch.shapesandsuch.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circle extends BShape{
    private float radius;
    private float x;
    private float y;
    private int index;
    private String name;
    private Paint p;

    public Circle(float radius, float x, float y, int index, String name, Paint p){
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.index = index;
        this.name = name;
        this.p = p;
    }

    public float getRadius(){
        return radius;
    }

    public void setRadius(float r){
        this.radius = r;
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

    @Override
    public void rotate() {

    }

    @Override
    public void updateCoordinates(float newX, float newY) {
        this.x = newX;
        this.y = newY;
    }

    @Override
    public void draw(Canvas c, int x, int y, Paint p) {
        c.drawCircle(x, y, this.getRadius(), p);
    }

    @Override
    public String defaultName() {
        return "Circle";
    }

//    public Circle(int rad, float n, float m){
//       super(n, m, rad);
//       x = n;
//       y = m;
//       radius = rad;
//    }
//
//    public int getRadius(){return radius;}
//    public float getX(){return x;}
//    public float getY(){return y;}
//
//    public void setX(float x1){
//        x = x1;
//    }
//
//    public void setY(float y1){
//        y = y1;
//    }
//
//
//    @Override
//    public void draw(Canvas canvas, float x, float y, float radius, Paint p) {
//        canvas.drawCircle(x, y, radius, p);
//    }
//
//    @Override
//    public void changeSize(int n) {
//
//    }
//
//    @Override
//    public void changeColor(Color color) {
//
//    }
}
