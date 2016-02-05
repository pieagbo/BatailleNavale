package com.company.model;

import com.company.model.joueurs.Joueur;

import java.util.Observable;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleModel extends Observable {
    Joueur player1 ;
    Joueur player2 ;
    Plateau grilleJ1 ;
    Plateau grilleJ2 ;

    public BatailleNavaleModel(){
        this.grilleJ1 = new Plateau();
        this.player1 = new Joueur();

        this.grilleJ2 = new Plateau();
        this.player2 = new Joueur();
    }

    public Plateau getPlateau(Joueur player) {
        if(player.equals(player1)) {
            return grilleJ2;
        } else {
            return grilleJ1;
        }
    }

    public void shoot(Plateau grille, int x, int y){
        grille.getCase(x, y).setTouch(true);
        setChanged();
        notifyObservers(getWinner());
    }

    private  Joueur getWinner() {
        if (player1.hasLoose()){
            return player2;
        } else if(player2.hasLoose()){
            return player1;
        }
        return null ;
    }

    public Joueur getPlayer1() {
        return player1;
    }

    public Joueur getPlayer2() {
        return player2;
    }
}