package com.company.model.cases;

/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseBateau extends Case {

    public CaseBateau(int x, int y) {
        super(x,y);
    }

    @Override
    public String toString(boolean boatVisible) {
        if (boatVisible) {
            return this.touch ? " X " : " B " ;
        } else {
            return this.touch ? " X " : " ~ " ;
        }
    }
}