package com.company.model.cases;

/**
 * Created by pieagbo on 01/02/16.
 */
public abstract class Case {
    protected int X ;
    protected int Y ;
    protected boolean touch ;

    public Case(int x, int y) {
        this.X = x;
        this.Y = y;
        this.touch = false ;
    }

    public int getX(){
        return this.X ;
    }

    public int getY(){
        return this.Y ;
    }

    public boolean isTouch(){
        return this.touch ;
    }

    public abstract String toString();
}
