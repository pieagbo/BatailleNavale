package com.company.model.bateaux;

import com.company.model.cases.Case;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by pieagbo on 02/02/16.
 */
public class BateauTest {

    @Test
    public void testIsDetroy() throws Exception {
        Case c = new Case(0,0) ;
        Case c1 = new Case(0,1) ;

        Bateau b = new Torpilleur() ;

        c.addBoat(b);
        c1.addBoat(b);

        c.setTouch(true);
        c1.setTouch(true);

        assertTrue(b.isDetroy());
    }

    @Test
    public void testIsTouch() throws Exception {
        Case c = new Case(0,0) ;
        Bateau b = new Torpilleur() ;
        c.addBoat(b);
        c.setTouch(true);

        assertTrue(b.isTouch());
    }


}