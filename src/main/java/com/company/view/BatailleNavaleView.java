package com.company.view;

import com.company.controller.BatailleNavaleController;
import com.company.model.BatailleNavaleModel;
import com.company.model.Plateau;
import com.company.model.bateaux.Bateau;
import com.company.model.joueurs.Joueur;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleView {

    BatailleNavaleModel model ;
    BatailleNavaleController controller ;

    Joueur player1 ;
    Joueur player2 ;

    Joueur currentPlayer ;
    Plateau currentPlateau ;

    public BatailleNavaleView(BatailleNavaleModel model, BatailleNavaleController controller) {
        this.model = model ;
        this.controller = controller ;

        this.player1 = this.model.getPlayer1() ;
        this.player2 = this.model.getPlayer2() ;

        this.setJoueurName(player1);
        this.setJoueurBoats(player1, this.model.getPlateau(player1));

        this.setJoueurName(player2);
        this.setJoueurBoats(player2, this.model.getPlateau(player2));

        this.currentPlayer = this.getRandomPlayer() ;
        this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;
    }

    public void drawGame() {
        System.out.println(this.currentPlayer.getName() + " c'est à votre tour de jouer.");
        this.currentPlateau.afficherPlateau(false);
    }

    public void jouer(){
        while(model.getWinner() == null){
            drawGame();

            String position = askWhereShoot() ;
            int x =  Integer.parseInt(position.substring(0, 1)) ;
            int y =  Integer.parseInt(position.substring(1, 2)) ;

            this.controller.shoot(this.currentPlayer, x, y);

            drawGame();

            this.displayBoatDestroy(this.currentPlayer, x, y);

            swapJoueur() ;
        }

        displayWinner(this.model.getWinner());
    }

    private String askWhereShoot() {
        System.out.println("Entrez les coordonnées de la case à cibler (ex: 02) : ");
        Scanner scan = new Scanner(System.in);

        return scan.nextLine();
    }

    private Joueur getRandomPlayer() {
        Random rand = new Random();

        if(rand.nextInt(2) == 1) {
            return  player1;
        } else {
            return player2;
        }
    }

    private void swapJoueur() {
        if(this.currentPlayer.equals(player1)) {
            this.currentPlayer = player2;
            this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;
        } else {
            this.currentPlayer = player1;
            this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;
        }
    }

    private void displayWinner(Joueur winner) {
        System.out.println("Félicitation " + winner.getName() + " vous êtes le vainqueur !");
    }

    private void displayBoatDestroy(Joueur player, int x, int y){
        switch (this.controller.boatIsDestroy(player, x, y)) {
            case "DESTROY":
                System.out.println("Vous avez détruit un bateau !");
                break;
            case "TOUCH":
                System.out.println("Vous avez touché un bateau !");
                break;
            case "NO":
                System.out.println("Vous n'avez rien touché !");
                break;
            default:
                System.out.println("Erreur");
        }
    }

    private void setJoueurName(Joueur player){
        System.out.print("Entrez votre nom : ");

        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        player.setName(name);
    }

    private void setJoueurBoats(Joueur player, Plateau grille){
        System.out.println("Avant de commencer, veuillez placer vos bateaux sur la carte.");
        System.out.println("Ex : Pour placer un bateau de taille 5 de la case (0,0) à la case (0,4)");
        System.out.println("sur l'axe des abscisses, entrez 01;05");
        System.out.println();

        grille.afficherPlateau(true);

        for(Bateau boat : player.getBateaux()){

            System.out.println("Votre " + boat.getNom() + " à une taille de " + boat.getTaille() + " cases.") ;
            System.out.println("Entrez les coordonées souhaitées pour le placer sur votre carte : ") ;

            Scanner scan = new Scanner(System.in);
            String position = scan.nextLine() ;

            player.positionnerUnBateau(boat, grille, position);

            System.out.println();
        }
    }
}
