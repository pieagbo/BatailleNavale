package com.company.controller;

import com.company.model.BatailleNavaleModel;
import com.company.model.Plateau;
import com.company.model.joueurs.Joueur;
import com.company.view.BatailleNavaleView;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleController {

    BatailleNavaleModel model ;
    BatailleNavaleView view ;

    boolean canPlay = true ;

    public BatailleNavaleController(BatailleNavaleModel model) {
        this.model = model ;
    }

    public void shoot(Joueur joueur, int x, int y) {
        this.model.shoot(joueur, x, y);
    }

    public void shoot(Plateau grille, int x, int y) {
        if (canPlay && (x >= 0 && x < 10) && (y >= 0 && y < 10) && grille.getCase(x, y) != null && !grille.getCase(x, y).isTouch()){
            this.model.shoot(grille, x, y);
            canPlay = false ;
            this.view.enableSwapp();
        } else {
            //on fait rien et on le laisse jouer
        }
    }

    public void addView(BatailleNavaleView batailleNavaleView) {
        this.view = batailleNavaleView ;
    }

    public void nowCanPlay() {
        this.canPlay = true ;
    }
}