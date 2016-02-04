package com.company.controller;

import com.company.model.Plateau;
import com.company.model.cases.Case;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rrauzduel on 04/02/16.
 */
public class BatailleNavaleControllerTest {

    @Test
    public void canAttackAndTouch() throws Exception {
        BatailleNavaleController batailleNavaleController = new BatailleNavaleController();
        Plateau grille = new Plateau();

        batailleNavaleController.attack(grille, 0, 0);

        assertEquals(true, grille.getPlateau()[0][0].isTouch());
    }

    @Test
    public void canAttackWithoutTouch() throws Exception {
        BatailleNavaleController batailleNavaleController = new BatailleNavaleController();
        Plateau grille = new Plateau();

        batailleNavaleController.attack(grille, 0, 0);

        assertEquals(false, grille.getPlateau()[1][1].isTouch());
    }
}