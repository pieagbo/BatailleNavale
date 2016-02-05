package com.company.model;

import com.company.model.bateaux.Bateau;
import com.company.model.cases.Case;

/**
 * Created by mlafourca002 on 01/02/16.
 */
public class Plateau {

    Case[][] plateau ;

    public Plateau (){
        this.plateau = new Case[10][10];
        for(int i=0;i<plateau.length;i++) {
            for(int j=0;j<plateau.length;j++) {
                this.plateau[i][j] = new Case(i,j);
            }
        }
    }

    public void afficherPlateau(boolean boatVisible) {
        for (int i = 0; i < plateau.length ; i++) {
            if (i == 0)
                System.out.println("   A  B  C  D  E  F  G  H  I  J");
            System.out.print((i + 1) + " ");
            for (int j = 0; j < plateau.length ; j++) {
                System.out.print(this.plateau[i][j].display(boatVisible)) ;
            }
            System.out.println();
        }
    }

    public Case getCase(int x, int y ){
        return this.plateau[x][y];
    }

    public void addBoat(int x, int y, Bateau boat) {
        this.plateau[x][y].addBoat(boat) ;
    }

    public Case[][] getPlateau() {
        return plateau;
    }
}