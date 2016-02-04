package com.company.model;

import com.company.model.cases.Case;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by pieagbo on 02/02/16.
 */
public class PlateauTest {

    @Test
    public void canCreatePlateau() throws Exception {
        Plateau plateau = new Plateau();

        Case[][] cases = plateau.getPlateau();
        for(int i=0;i<cases.length;i++) {
            for (int j = 0; j < cases.length; j++) {
                assertEquals(false, cases[i][j].isTouch());
            }
        }


    }
}