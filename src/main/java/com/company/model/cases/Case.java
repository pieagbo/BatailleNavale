package com.company.model.cases;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pieagbo on 01/02/16.
 */
public abstract class Case extends JPanel{
    protected int X ;
    protected int Y ;
    protected boolean touch ;

    public Case(int x, int y) {
        this.X = x;
        this.Y = y;
        this.touch = false ;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
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

    public void setTouch(boolean touch) {
        this.touch = touch;
    }

    public abstract String toString();
}
