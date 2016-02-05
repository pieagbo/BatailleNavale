package com.company.view;

import com.company.controller.BatailleNavaleController;
import com.company.model.BatailleNavaleModel;
import com.company.model.Plateau;
import com.company.model.bateaux.Bateau;
import com.company.model.joueurs.Joueur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleView extends JFrame implements Observer {

    BatailleNavaleModel model ;
    BatailleNavaleController controller ;

    Joueur player1 ;
    Joueur player2 ;

    GrilleGraphique grilleJ1 ;
    GrilleGraphique grilleJ2 ;

    GrilleGraphique currentGrilleGraphique ;

    Joueur currentPlayer ;
    Plateau currentPlateau ;

    PlayerBoard infoPlayer ;

    JButton swapp ;
    JButton restart ;


    public BatailleNavaleView(BatailleNavaleModel model, BatailleNavaleController controller) {
        super();
        this.setName("Bataille Navale");

        this.model = model ;
        this.controller = controller ;

        this.controller.addView(this) ;

        this.player1 = this.model.getPlayer1() ;
        this.player2 = this.model.getPlayer2() ;

        this.setJoueurName(player1);
        this.setJoueurBoats(player1, this.model.getPlateau(player2));

        this.setJoueurName(player2);
        this.setJoueurBoats(player2, this.model.getPlateau(player1));

        this.grilleJ1 = new GrilleGraphique(this.model.getPlateau(player2), this.controller);
        this.grilleJ2 = new GrilleGraphique(this.model.getPlateau(player1), this.controller);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(800, 650));
        this.pack();

        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //this.currentPlayer = this.getRandomPlayer() ;
        this.currentPlayer = this.player1 ;

        this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;
        this.currentGrilleGraphique = this.grilleJ2 ;

        JPanel buttonPanel = new JPanel() ;
        this.infoPlayer = new PlayerBoard(this.currentPlayer) ;

        this.restart = new JButton("Recommencer");
        this.swapp = new JButton("Changer de tour");

        restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                restartSetThisActionPerformed(evt);
            }
        });

        swapp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                swappThisActionPerformed(evt);
            }
        });

        buttonPanel.add(restart);
        buttonPanel.add(swapp);

        this.swapp.setEnabled(false);

        this.add(this.currentGrilleGraphique, BorderLayout.CENTER) ;
        this.add(buttonPanel, BorderLayout.NORTH) ;
        this.add(this.infoPlayer, BorderLayout.EAST) ;

        this.model.addObserver(this);
    }

    private void swappThisActionPerformed(ActionEvent evt) {
        if(this.currentPlayer.equals(player1)) {
            this.currentPlayer = player2;
            this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;
            this.currentGrilleGraphique.setGrille(this.currentPlateau);
            this.infoPlayer.setPlayer(this.currentPlayer) ;
            this.repaint();
            this.controller.nowCanPlay();
        } else {
            this.currentPlayer = player1;
            this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;
            this.currentGrilleGraphique.setGrille(this.currentPlateau);
            this.infoPlayer.setPlayer(this.currentPlayer) ;
            this.repaint();
            this.controller.nowCanPlay();
        }

        this.swapp.setEnabled(false);
    }

    private void restartSetThisActionPerformed(ActionEvent evt) {
        this.model = new BatailleNavaleModel() ;
    }

    private Joueur getRandomPlayer() {
        Random rand = new Random();

        if(rand.nextInt(2) == 1) {
            return  player1;
        } else {
            return player2;
        }
    }

    private void setJoueurName(Joueur player){
        System.out.print("Entrez votre nom : ");

        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        System.out.println();
        player.setName(name);
    }

    private void setJoueurBoats(Joueur player, Plateau grille){
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

            String pos = convertToCustomString(getCoordonnees(position), sens, boat.getTaille()) ;
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

    private int getIndexInAlphabet(char letter) {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(Character.toUpperCase(letter)) ;
    }

    private int getNumber(String letter) {
        return Integer.parseInt(letter) - 1 ;
    }

    private String convertToCustomString(int[] pos, String sens, int taille) {
        String coordonnees = Integer.toString(pos[0]) + Integer.toString(pos[1]) + ";" ;

        if("v".equalsIgnoreCase(sens)){
            int x = pos[0] + (taille -1) ;
            coordonnees += Integer.toString(x) + Integer.toString(pos[1]) ;
        } else if("h".equalsIgnoreCase(sens)) {
            int y = pos[1] + (taille -1) ;
            coordonnees += Integer.toString(pos[0]) + Integer.toString(y) ;
        }

        return coordonnees ;
    }

    public void enableSwapp(){
        this.swapp.setEnabled(true);
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}