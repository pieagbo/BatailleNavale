package com.company.model.cases;

/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseMer extends Case{

    public CaseMer(int x, int y) {
        super(x,y);
    }

    @Override
    public String toString(boolean boatVisible) {
        return this.touch ? " M " : " ~ " ;
    }
}