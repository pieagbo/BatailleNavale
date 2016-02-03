package com.company.model;

import com.company.model.cases.Case;
import com.company.model.cases.CaseMer;

/**
 * Created by mlafourca002 on 01/02/16.
 */
public class Plateau {

    private Case[][] plateau ;

    public Plateau (){
        this.plateau = new Case[10][10];
        for(int i=0;i<plateau.length;i++) {
            for(int j=0;j<plateau.length;j++) {
                this.plateau[i][j] = new CaseMer(i,j);
            }

        }
    }

    public void afficherPlateau() {
        for (Case[] aPlateau : plateau) {
            System.out.println();
            for (int j = 0; j < plateau.length; j++) {
                System.out.print(aPlateau[j].toString());
            }

        }
    }

    public Case getCase(int x, int y ){
        return this.plateau[x][y];
    }

    public void setCase(int x, int y ,Case uneCase){
        this.plateau[x][y]=uneCase;
    }

}
