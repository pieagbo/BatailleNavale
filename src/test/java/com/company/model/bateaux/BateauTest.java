package com.company.model.bateaux;

import com.company.model.bateaux.Torpilleur;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by pieagbo on 02/02/16.
 */
public class BateauTest {

    @Test
    public void testIsDetroy() throws Exception {
        Torpilleur torpilleur = new Torpilleur() ;
        assertTrue("NO", torpilleur.isDetroy());
    }
}