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
    static int POSITION_X_GRILLE ;
    static int POSITION_Y_GRILLE ;

    public GrilleGraphique(Plateau plateau, BatailleNavaleController controller) {
        this.grille = plateau ;
        this.controller = controller ;

        POSITION_X_GRILLE = 50 ;
        POSITION_Y_GRILLE = 50 ;

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grilleMouseClicked(evt);
            }
        });
    }

    private void grilleMouseClicked(MouseEvent evt) {
        this.controller.shoot(this.grille,getCaseY(evt.getY()), getCaseX(evt.getX()));
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
                g2.drawRect(this.grille.getPlateau()[i][j].getY() * TAILLE_CASE + POSITION_X_GRILLE,
                        this.grille.getPlateau()[i][j].getX() * TAILLE_CASE + POSITION_Y_GRILLE,
                        TAILLE_CASE, TAILLE_CASE);


                g2.setStroke(oldStroke);
                if (this.grille.getPlateau()[i][j].getBoat() != null) {
                    if(this.grille.getPlateau()[i][j].getBoat().isDetroy()){
                        g2.setColor(Color.BLACK);
                    } else {
                        if(this.grille.getPlateau()[i][j].getBoat().isTouch()) {
                            if (this.grille.getPlateau()[i][j].isTouch()) {
                                g2.setColor(Color.RED);
                            } else {
                                g2.setColor(Color.BLUE);
                            }
                        } else {
                            g2.setColor(Color.BLUE);
                        }
                    }
                } else {
                    if(this.grille.getPlateau()[i][j].isTouch()) {
                        g2.setColor(Color.CYAN);
                    } else {
                        g2.setColor(Color.BLUE);
                    }
                }

                g2.fillRect(this.grille.getPlateau()[i][j].getY() * TAILLE_CASE + POSITION_X_GRILLE,
                        this.grille.getPlateau()[i][j].getX() * TAILLE_CASE + POSITION_Y_GRILLE,
                        TAILLE_CASE, TAILLE_CASE);
            }
        }
    }

    public void setGrille(Plateau grille)
    {
        this.grille = grille;
        POSITION_X_GRILLE = 50 ;
        POSITION_Y_GRILLE = 50 ;
    }


    public int getCaseX(int pixel) {
        return (pixel - POSITION_Y_GRILLE ) / ( ( ( POSITION_Y_GRILLE + ( TAILLE_CASE * 10 ) ) - POSITION_Y_GRILLE ) / 10);
    }

    public int getCaseY(int pixel) {
        return (pixel - POSITION_X_GRILLE ) / ( ( ( POSITION_X_GRILLE + ( TAILLE_CASE * 10 ) ) - POSITION_X_GRILLE ) / 10);
    }
}
