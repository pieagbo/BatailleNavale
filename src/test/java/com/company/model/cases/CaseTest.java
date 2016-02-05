package com.company.model.cases;

import com.company.model.bateaux.Bateau;
import com.company.model.bateaux.Torpilleur;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseTest {

    private final boolean visible = true;

    @Test
    public void caseHasBoatToString() throws Exception {
        Case c = new Case(0,1) ;

        Bateau b = new Torpilleur() ;

        c.addBoat(b);

        assertEquals(" B ", c.display(visible));
    }

    @Test
    public void caseIsTouchToString() throws Exception {
        Case c = new Case(0,1) ;

        c.setTouch(true);

        assertEquals(" X ", c.display(visible));
    }
}
