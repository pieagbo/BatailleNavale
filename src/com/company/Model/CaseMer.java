package com.company.Model;

/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseMer extends Case{

    public CaseMer(int x, int y) {
        super(x,y);
    }

    @Override
    public String toStringg() {
        return this.touch == true ? "M" : "0" ;
    }
}
