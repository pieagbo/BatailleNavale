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
        this.setJoueurBoats(player1, this.model.getPlateau(player2));

        this.setJoueurName(player2);
        this.setJoueurBoats(player2, this.model.getPlateau(player1));

        this.currentPlayer = this.getRandomPlayer() ;
        this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;
    }

    public void drawGame() {
        System.out.println(this.currentPlayer.getName() + " c'est à votre tour de jouer.");
        this.currentPlateau.afficherPlateau(false);
        System.out.println();
    }

    public void jouer(){
        Joueur winner = null ;
        while(winner == null){
            drawGame();

            int[] position = askWhereShoot() ;
            int x =  position[0] ;
            int y =  position[1] ;

            this.controller.shoot(this.currentPlayer, x, y);

            drawGame();

            this.displayBoatDestroy(this.currentPlayer, x, y);

            swapJoueur() ;

            winner = this.model.getWinner() ;
        }

        displayWinner(winner);
    }

     int[] askWhereShoot() {
        System.out.println("Entrez les coordonnées de la case à cibler (ex: C2) : ");
        Scanner scan = new Scanner(System.in);

        return getCoordonnees(scan.nextLine()) ;
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
        System.out.println();
    }

     void setJoueurName(Joueur player){
        System.out.print("Entrez votre nom : ");

        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        System.out.println();
        player.setName(name);
    }

     void setJoueurBoats(Joueur player, Plateau grille){
        System.out.println("Avant de commencer, veuillez placer vos bateaux sur la carte.");
        System.out.println();

        grille.afficherPlateau(false);

        for(Bateau boat : player.getBateaux()){
            Scanner scan = new Scanner(System.in);

            System.out.println("Votre " + boat.getNom() + " à une taille de " + boat.getTaille() + " cases.") ;
            System.out.println("Entrez la case où placer le bateau : ") ;
            String position = scan.nextLine() ;

            System.out.println("Dans quelle position souhaitez-vous placer le bateau ?") ;
            System.out.println("horizontale (h) ou verticale (v)") ;
            String sens = scan.nextLine() ;

            int[] pos = convertToCustomString(getCoordonnees(position), sens, boat.getTaille()) ;

            player.positionnerUnBateau(boat, grille, pos);

            grille.afficherPlateau(true);

            System.out.println();
        }
    }

    private int[] getCoordonnees(String input){
        int[] coordonnees = new int[2] ;

        coordonnees[0] = getIndexInAlphabet(input.substring(0,1).charAt(0)) ;
        coordonnees[1] = getNumber(input.substring(1)) ;

        return coordonnees;
    }

     int getIndexInAlphabet(char letter) {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(Character.toUpperCase(letter)) ;
    }

    private int getNumber(String letter) {
        return Integer.parseInt(letter) - 1 ;
    }

     int[] convertToCustomString(int[] pos, String sens, int taille) {
        int[] coordonnees = new int[4] ;
        coordonnees[0] = pos[0] ;
        coordonnees[1] = pos[1] ;
//        String coordonnees = Integer.toString(pos[0]) + Integer.toString(pos[1]) + ";" ;

        if("v".equalsIgnoreCase(sens)){
            int x = pos[0] + (taille -1) ;
            coordonnees[2] = x ;
            coordonnees[3] = pos[1];
//            coordonnees += Integer.toString(x) + Integer.toString(pos[1]) ;
        } else if("h".equalsIgnoreCase(sens)) {
            int y = pos[1] + (taille -1) ;
            coordonnees[3] = y ;
            coordonnees[2] = pos[0];
//            coordonnees += Integer.toString(pos[0]) + Integer.toString(y) ;
        }

        return coordonnees ;
    }
}