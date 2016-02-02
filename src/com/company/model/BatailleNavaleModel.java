package com.company.model;

import com.company.model.joueurs.Joueur;
import com.company.model.joueurs.Plateau;

import java.util.Observable;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleModel extends Observable {

    private Joueur player1 ;
    private Joueur player2 ;
    private Plateau grilleJ1 ;
    private Plateau grilleJ2 ;

    public BatailleNavaleModel(String nameJ1, String nameJ2){
        this.grilleJ1 = new Plateau();
        this.grilleJ2 = new Plateau();
        this.player1 = new Joueur(nameJ1, grilleJ1);
        this.player2 = new Joueur(nameJ2, grilleJ2);
    }



}
