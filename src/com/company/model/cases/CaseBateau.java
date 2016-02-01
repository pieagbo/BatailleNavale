package com.company.model.cases;

/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseBateau extends Case {

    public CaseBateau(int x, int y) {
        super(x,y);
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return this.touch == true ? "X" : "~" ;
=======
        return this.touch == true ? "X" : "0" ;
>>>>>>> 9e26f1af8035ac6d4c1d012dd886391991b85470
    }
}
