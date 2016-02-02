package main.java.com.company.view;

import main.java.com.company.controller.BatailleNavaleController;
import main.java.com.company.model.BatailleNavaleModel;
import main.java.com.company.model.Plateau;
import main.java.com.company.model.joueurs.Joueur;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by pieagbo on 01/02/16.
 */
public class BatailleNavaleView implements Observer {

    BatailleNavaleModel model ;
    BatailleNavaleController controller ;

    Joueur currentPlayer ;
    Plateau currentPlateau ;

    public BatailleNavaleView(BatailleNavaleModel model, BatailleNavaleController controller) {
        this.model = model ;
        this.controller = controller ;
    }

    public void drawGame() {
        for (Plateau p : model.getGrilles()){
            p.afficherPlateau();
            System.out.println();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        drawGame();
    }
}
