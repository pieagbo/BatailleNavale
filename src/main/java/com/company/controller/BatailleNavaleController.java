package com.company.controller;

import com.company.model.BatailleNavaleModel;
import com.company.model.Plateau;
import com.company.model.bateaux.Bateau;
import com.company.model.cases.Case;
import com.company.model.cases.CaseBateau;
import com.company.model.joueurs.Joueur;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleController {

    BatailleNavaleModel model ;

    public BatailleNavaleController(BatailleNavaleModel model) {
        this.model = model ;
    }

    public void shoot(Joueur joueur, int x, int y) {
        this.model.shoot(joueur, x, y);
    }

    public String boatIsDestroy(Joueur joueur, int x, int y) {
        return this.model.boatIsDestroy(joueur, x, y) ;
    }
}
