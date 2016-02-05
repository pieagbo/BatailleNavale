package com.company.view;

import com.company.controller.BatailleNavaleController;
import com.company.model.Plateau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by pieagbo on 05/02/16.
 */
public class GrilleGraphique extends JPanel {

    Plateau grille ;
    BatailleNavaleController controller ;

    int TAILLE_CASE = 50 ;
    int TAILLE_X_JFRAME = 700 ;
    int TAILLE_Y_JFRAME = 700 ;
    static int POSITION_X_GRILLE ;
    static int POSITION_Y_GRILLE ;

    public GrilleGraphique(Plateau plateau, BatailleNavaleController controller) {
        this.grille = plateau ;
        this.controller = controller ;

        POSITION_X_GRILLE = getPosX() ;
        POSITION_Y_GRILLE = getPosY() ;

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grilleMouseClicked(evt);
            }
        });
    }

    private void grilleMouseClicked(MouseEvent evt) {
        this.controller.shoot(this.grille,getCaseX(evt.getX()), getCaseY(evt.getY()));
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        float thickness = 2;
        Stroke oldStroke = g2.getStroke();

        for (int i = 0 ; i < 10 ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                g2.setStroke(new BasicStroke(thickness));

                g2.setColor(Color.black) ;
                g2.drawRect(this.grille.getPlateau()[i][j].getX() * TAILLE_CASE + POSITION_X_GRILLE,
                        this.grille.getPlateau()[i][j].getY() * TAILLE_CASE + POSITION_Y_GRILLE,
                        TAILLE_CASE, TAILLE_CASE);


                g2.setStroke(oldStroke);
                if (this.grille.getPlateau()[i][j].getBoat() != null) {
                    if(this.grille.getPlateau()[i][j].getBoat().isDetroy()){
                        g2.setColor(Color.DARK_GRAY);
                    } else {
                        if(this.grille.getPlateau()[i][j].getBoat().isTouch()) {
                            if (this.grille.getPlateau()[i][j].isTouch()) {
                                g2.setColor(Color.green);
                            } else {
                                g2.setColor(Color.gray);
                            }
                        } else {
                            g2.setColor(Color.gray);
                        }
                    }
                } else {
                    if(this.grille.getPlateau()[i][j].isTouch()) {
                        g2.setColor(Color.red);
                    } else {
                        g2.setColor(Color.cyan);
                    }
                }

                g2.fillRect(this.grille.getPlateau()[i][j].getX() * TAILLE_CASE + POSITION_X_GRILLE,
                        this.grille.getPlateau()[i][j].getY() * TAILLE_CASE + POSITION_Y_GRILLE,
                        TAILLE_CASE, TAILLE_CASE);
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

    public int getCaseX(int pixel) {
        int x = (pixel - GrilleGraphique.POSITION_X_GRILLE ) / ( ( ( GrilleGraphique.POSITION_X_GRILLE + ( TAILLE_CASE * 10 ) ) - GrilleGraphique.POSITION_X_GRILLE ) / 10) ;
        return x ;
    }

    public int getCaseY(int pixel) {
        int y = (pixel - GrilleGraphique.POSITION_Y_GRILLE ) / ( ( ( GrilleGraphique.POSITION_Y_GRILLE + ( TAILLE_CASE * 10 ) ) - GrilleGraphique.POSITION_Y_GRILLE ) / 10) ;
        return y ;
    }
}
