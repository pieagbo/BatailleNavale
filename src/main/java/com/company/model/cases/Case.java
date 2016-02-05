package com.company.model.cases;

import com.company.model.bateaux.Bateau;

/**
 * Created by pieagbo on 01/02/16.
 */
public class Case {
    protected int X ;
    protected int Y ;
    protected boolean touch ;
    private Bateau bateau;

    public Case(int x, int y) {
        this.X = x;
        this.Y = y;
        this.touch = false ;
        this.bateau = null ;
    }

    public boolean isTouch(){
        return this.touch ;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
        if (bateau != null) {
            bateau.setTouch(touch);
        }
    }

    public String toString(boolean boatVisible) {
        if (this.bateau != null) {
            if(this.bateau.isDetroy()){
                return " X ";
            } else {
                if(this.bateau.isTouch()) {
                    if (this.isTouch()) {
                        return " X ";
                    } else {
                        if (boatVisible) {
                            return  " B ";
                        } else {
                            return " ~ ";
                        }
                    }
                } else {
                    if (boatVisible) {
                        return " B ";
                    } else {
                        return " ~ ";
                    }
                }
            }
        } else {
            return this.touch ? " X " : " ~ " ;
        }
    }

    public int getX() {
        return this.X ;
    }

    public int getY() {
        return this.Y;
    }

    public void addBoat(Bateau boat) {
        this.bateau = boat ;
    }

    public Bateau getBoat() {
        return this.bateau;
    }
}