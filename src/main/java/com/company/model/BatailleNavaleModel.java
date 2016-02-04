package com.company.model;

import com.company.model.bateaux.Bateau;
import com.company.model.cases.CaseBateau;
import com.company.model.joueurs.Joueur;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleModel {
    private Joueur player1 ;
    private Joueur player2 ;
    private Plateau grilleJ1 ;
    private Plateau grilleJ2 ;

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

    public String boatIsDestroy(Joueur player, int x, int y){
        if(player.equals(this.player1)) {
            if (this.grilleJ2.getCase(x,y) instanceof CaseBateau) {
                return player2.getBateau(this.grilleJ2.getCase(x, y)).isDetroy() ? "DESTROY" : "TOUCH" ;
            } else {
                return "NO" ;
            }
        } else {
            if (this.grilleJ2.getCase(x,y) instanceof CaseBateau) {
                return player1.getBateau(this.grilleJ1.getCase(x, y)).isDetroy() ? "DESTROY" : "TOUCH" ;
            } else {
                return "NO" ;
            }
        }
    }

    public void shoot(Joueur player, int x, int y){
        if(player.equals(this.player1)) {
            this.grilleJ2.getCase(x, y).setTouch(true);
        } else {
            this.grilleJ1.getCase(x, y).setTouch(true);
        }
    }

    public Joueur getWinner() {
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

    public void setPlayerName(Joueur player, String name) {
        player.setName(name);
    }
}
