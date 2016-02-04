package com.company.view;

import com.company.model.Plateau;
import com.company.model.cases.CaseBateau;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pieagbo on 03/02/16.
 */
public class GrilleGraphique extends Canvas {

    private Plateau grille ;
    static int POSITION_X_GRILLE ;
    static int POSITION_Y_GRILLE ;

    int TAILLE_CASE = 50 ;
    int TAILLE_X_JFRAME = 600 ;
    int TAILLE_Y_JFRAME = 1000 ;


    public GrilleGraphique(Plateau grille) {
        this.grille = grille ;
        POSITION_X_GRILLE = getPosX() ;
        POSITION_Y_GRILLE = getPosY() ;
    }

    @Override
    public void paint(Graphics g)
    {
         for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0 ; j < 10 ; j++) {

                g.setColor(Color.black) ;
                g.drawRect(this.grille.getPlateau()[i][j].getX() * TAILLE_CASE + POSITION_X_GRILLE,
                        this.grille.getPlateau()[i][j].getY() * TAILLE_CASE + POSITION_Y_GRILLE,
                        TAILLE_CASE, TAILLE_CASE);

//                if(this.grille.getPlateau()[i][j] instanceof CaseBateau)
//                    g.setColor(Color.black) ;
//                else
//                    g.setColor(Color.cyan);
//
//                g.fillRect(this.grille.getPlateau()[i][j].getX() * TAILLE_CASE + POSITION_X_GRILLE,
//                        this.grille.getPlateau()[i][j].getY() * TAILLE_CASE + POSITION_Y_GRILLE,
//                        TAILLE_CASE, TAILLE_CASE);


            }
        }
    }

    public void setGrille(Plateau grille)
    {
        this.grille = grille;
        POSITION_X_GRILLE = getPosX() ;
        POSITION_Y_GRILLE = getPosY() ;
    }

    public int getPosX()
    {
        int x = (TAILLE_X_JFRAME / 2) - (getSizeWidth() / 2) ;
        return x ;
    }

    public int getPosY()
    {
        int y = ((TAILLE_Y_JFRAME - 100) / 2) - (getSizeHeight() / 2) ;
        return y ;
    }

    public int getSizeWidth()
    {
        return 10 * TAILLE_CASE ;
    }

    public int getSizeHeight()
    {
        return 10 * TAILLE_CASE ;
    }

}
