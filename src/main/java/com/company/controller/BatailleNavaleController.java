package main.java.com.company.controller;

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

    public void attack(Joueur player, Plateau grille, int x, int y) {
        Case c = grille.getCase(x,y) ;

        if (c != null)
            c.setTouch(true);

        if(c instanceof CaseBateau){
            model.addPoint(player) ;
        }
    }

}
