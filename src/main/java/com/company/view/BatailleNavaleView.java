package main.java.com.company.view;

import main.java.com.company.controller.BatailleNavaleController;
import main.java.com.company.model.BatailleNavaleModel;
import main.java.com.company.model.Plateau;
import main.java.com.company.model.joueurs.Joueur;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleView {

    BatailleNavaleModel model ;
    BatailleNavaleController controller ;

    Joueur currentPlayer ;
    Plateau currentPlateau ;

    public BatailleNavaleView(BatailleNavaleModel model, BatailleNavaleController controller) {
        this.model = model ;
        this.controller = controller ;

        this.currentPlayer = this.model.getRandomPlayer() ;
        this.currentPlateau = this.model.getPlateau(this.currentPlayer) ;
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
