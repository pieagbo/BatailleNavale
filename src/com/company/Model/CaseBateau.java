package com.company.Model;

/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseBateau extends Case {

    public CaseBateau(int x, int y) {
        super(x,y);
    }

    @Override
    public String toStringg() {
        return this.touch == true ? "X" : "0" ;
    }
}
