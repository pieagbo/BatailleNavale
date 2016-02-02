package com.company.model;

import com.company.model.joueurs.Joueur;
import com.company.model.joueurs.JoueurHumain;

import java.util.Observable;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleModel extends Observable {

    private Joueur player1 ;
    private Joueur player2 ;
    private Plateau grilleJ1 ;
    private Plateau grilleJ2 ;

    public BatailleNavaleModel(){
        this.grilleJ1 = new Plateau();
        //this.grilleJ2 = new Plateau();
        this.player1 = new JoueurHumain(grilleJ1);
        //this.player2 = new JoueurHumain( grilleJ2);
    }

    public void addPoint(Joueur player) {
        player.addPoint();
    }

    public Plateau[] getGrilles(){
        Plateau[] grilles = new Plateau[1] ;
        grilles[0] = grilleJ1 ;
        //grilles[1] = grilleJ2 ;

        return  grilles ;
    }
}
