package com.company.controller;

import main.java.com.company.model.BatailleNavaleModel;
import main.java.com.company.model.Plateau;
import main.java.com.company.model.cases.Case;
import main.java.com.company.model.cases.CaseBateau;
import main.java.com.company.model.joueurs.Joueur;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleController {

    private BatailleNavaleModel model ;

    public BatailleNavaleController(BatailleNavaleModel model) {
        this.model = model ;
    }

    public void attack(Plateau grille, int x, int y) {
        Case uneCase = grille.getCase(x, y);
        uneCase.setTouch(true);
    }

}
