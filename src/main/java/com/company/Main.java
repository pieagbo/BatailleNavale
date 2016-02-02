package main.java.com.company;

import main.java.com.company.controller.BatailleNavaleController;
import main.java.com.company.model.BatailleNavaleModel;
import main.java.com.company.view.BatailleNavaleView;

public class Main {

    public static void main(String[] args) {
        BatailleNavaleModel model = new BatailleNavaleModel() ;
        BatailleNavaleController controller = new BatailleNavaleController(model) ;
        BatailleNavaleView view = new BatailleNavaleView(model, controller) ;

        view.drawGame();

    }
}
