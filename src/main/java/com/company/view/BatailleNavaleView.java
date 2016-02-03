package com.company.view;

import com.company.controller.BatailleNavaleController;
import com.company.model.BatailleNavaleModel;
import com.company.model.Plateau;
import com.company.model.joueurs.Joueur;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleView {

    BatailleNavaleModel model ;
    BatailleNavaleController controller ;

    protected JFrame frame ;
    protected GrilleGraphique grilleJ1 ;
    protected GrilleGraphique grilleJ2 ;

    Joueur currentPlayer ;
    Plateau currentPlateau ;

    public BatailleNavaleView(BatailleNavaleModel model, BatailleNavaleController controller) {
        super();

        this.model = model ;
        this.controller = controller ;

        this.frame = new JFrame("Bataille Navale");

        this.currentPlayer = this.model.getRandomPlayer() ;
        this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;

        this.grilleJ1 = new GrilleGraphique(model.getPlateau(this.currentPlayer));
        this.grilleJ2 = new GrilleGraphique(model.getPlateau(this.currentPlayer));

        this.frame.setSize(1200, 1000);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(true);
        this.frame.setLocationRelativeTo(null);

        this.frame.setLayout(new GridLayout(1, 2));

        this.frame.add(this.grilleJ1);
        this.frame.add(this.grilleJ2);

        this.frame.setVisible(true);
        this.frame.pack();
    }

    public void drawGame() {
        System.out.println();
        this.currentPlateau.afficherPlateau();
        System.out.println();
    }

    public void jouer(){
        while(model.getWinner()==null){
            drawGame();

            System.out.print(this.currentPlayer.getName()+ " entrez les coordonnées de la case à cibler (ex: 02 ) : ");
            Scanner scan = new Scanner(System.in);
            String coordCible = scan.nextLine();
            this.controller.attack(this.currentPlateau, Integer.parseInt(coordCible.substring(0,1)), Integer.parseInt(coordCible.substring(1,2)));

            drawGame();

            this.currentPlayer=this.model.getNextPlayer(this.currentPlayer);
            this.currentPlateau=this.model.getPlateau(this.currentPlayer);
        }
    }


}
