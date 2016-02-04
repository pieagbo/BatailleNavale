package com.company.view;

import com.company.controller.BatailleNavaleController;
import com.company.model.BatailleNavaleModel;
import com.company.model.Plateau;
import com.company.model.joueurs.Joueur;

import java.util.Scanner;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleView {

    BatailleNavaleModel model ;
    BatailleNavaleController controller ;

    Joueur currentPlayer ;
    Joueur winner ;
    Plateau currentPlateau ;

    public BatailleNavaleView(BatailleNavaleModel model, BatailleNavaleController controller) {
        this.model = model ;
        this.controller = controller ;

        this.currentPlayer = this.model.getRandomPlayer() ;
        this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;
        this.winner = null ;
    }

    public void drawGame() {
        System.out.println(this.currentPlayer.getName()+ " c'est à votre tour de jouer.");
        this.currentPlateau.afficherPlateau(false);
        System.out.println();
    }

    public void jouer(){
        while(this.winner == null){
            drawGame();

            System.out.println("Entrez les coordonnées de la case à cibler (ex: 02) : ");
            Scanner scan = new Scanner(System.in);
            String coordCible = scan.nextLine();
            System.out.println();
            this.controller.attack(this.currentPlateau, Integer.parseInt(coordCible.substring(0,1)), Integer.parseInt(coordCible.substring(1,2)));

            drawGame();

            this.currentPlayer=this.model.getNextPlayer(this.currentPlayer);
            this.currentPlateau=this.model.getPlateau(this.currentPlayer);

            this.winner = model.getWinner() ;
        }

        System.out.println("Félicitation " + this.winner.getName() + " vous êtes le vainqueur !");
    }

}
