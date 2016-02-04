package com.company.model;

import com.company.model.bateaux.Bateau;
import com.company.model.bateaux.Croiseur;
import com.company.model.cases.Case;
import com.company.model.cases.CaseBateau;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by pieagbo on 02/02/16.
 */
public class BateauTest {
    
    @Test
    public void testIsDestroy() throws Exception {
        Bateau bateau= new Croiseur();
        ArrayList<Case> coordonnes = bateau.getCoordonnes();
        Case uneCase = new CaseBateau(0,0);
        coordonnes.add(uneCase);

        uneCase.setTouch(true);

        Assert.assertTrue(uneCase.isTouch());



    }


}