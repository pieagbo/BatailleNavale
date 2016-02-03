package main.java.com.company.model;

import main.java.com.company.model.joueurs.Joueur;
import main.java.com.company.model.joueurs.JoueurHumain;

import java.util.Observable;
import java.util.Random;

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
        this.player1 = new JoueurHumain(grilleJ1);

        this.grilleJ2 = new Plateau();
        this.player2 = new JoueurHumain( grilleJ2);
    }

    public void addPoint(Joueur player) {
        player.addPoint();
    }

    public Plateau[] getGrilles(){
        Plateau[] grilles = new Plateau[2] ;
        grilles[0] = grilleJ1 ;
        grilles[1] = grilleJ2 ;

        return  grilles ;
    }

    public Joueur getRandomPlayer(){
        Random rand = new Random();

        if(rand.nextInt(2) == 1) {
            return  player1;
        } else {
            return player2;
        }
    }

    public Joueur getNextPlayer(Joueur player) {
        if(player.equals(player1)) {
            return player2;
        } else {
            return player1;
        }
    }

    public Plateau getPlateau(Joueur player) {
        if(player.equals(player1)) {
            return grilleJ2;
        } else {
            return grilleJ1;
        }
    }

    public Joueur getWinner() {
        if (player1.hasLoose()){
            return player2;
        }else if(player2.hasLoose()){
            return player1;
        }
        return null ;
    }
}
