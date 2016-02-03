package com.company;

import com.company.controller.BatailleNavaleController;
import com.company.model.BatailleNavaleModel;
import com.company.view.BatailleNavaleView;

public class Main {

    public static void main(String[] args) {
        BatailleNavaleModel model = new BatailleNavaleModel() ;
        BatailleNavaleController controller = new BatailleNavaleController(model) ;
        BatailleNavaleView view = new BatailleNavaleView(model, controller) ;

        //view.jouer();

    }
}
