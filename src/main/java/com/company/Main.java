package main.java.com.company;

import main.java.com.company.controller.BatailleNavaleController;
import main.java.com.company.model.BatailleNavaleModel;
import main.java.com.company.model.cases.Case;
import main.java.com.company.model.cases.CaseMer;
import main.java.com.company.view.BatailleNavaleView;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        /*
        BatailleNavaleModel model = new BatailleNavaleModel() ;
        BatailleNavaleController controller = new BatailleNavaleController(model) ;
        BatailleNavaleView view = new BatailleNavaleView(model, controller) ;

        view.drawGame();
        */


        //Gestion de la fenêtre graphique

        GridLayout grille = new GridLayout(10, 10);

        JFrame frame = new JFrame();

        frame.setTitle("Bataille Navale");
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(grille);
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                //frame.getContentPane().add(new CaseMer(i, j));
                frame.getContentPane().add(new JButton());


            }
        }

        frame.setVisible(true);



    }
}
