package com.company.model;

import com.company.model.cases.Case;
import com.company.model.cases.CaseMer;

/**
 * Created by mlafourca002 on 01/02/16.
 */
public class Plateau {

    Case[][] plateau ;

    public Plateau (){
        this.plateau = new Case[10][10];
        for(int i=0;i<plateau.length;i++) {
            for(int j=0;j<plateau.length;j++) {
                this.plateau[i][j] = new CaseMer(i,j);
            }
        }
    }

    public void afficherPlateau(boolean boatVisible) {
        for (int i = 0; i < plateau.length ; i++) {
            if (i == 0)
                System.out.println("   1  2  3  4  5  6  7  8  9  10");
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < plateau.length ; j++) {
                System.out.print(this.plateau[i][j].toString(boatVisible)) ;
            }
            System.out.println();
        }
    }

    public Case getCase(int x, int y ){
        return this.plateau[x][y];
    }

    public void setCase(int x, int y ,Case uneCase){
        this.plateau[x][y]=uneCase;
    }

}
