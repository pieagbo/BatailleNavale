package com.company.model.joueurs;

import com.company.model.cases.Case;
import com.company.model.cases.CaseMer;

/**
 * Created by mlafourca002 on 01/02/16.
 */
public class Plateau {


    private Case[][] plateau ;

    public Plateau (){

        this.plateau = new Case[10][10];
    }

    public void creerPlateau (){
        for(int i=0;i<plateau.length;i++) {

            for(int j=0;j<plateau.length;j++) {
                this.plateau[i][j] = new CaseMer(i,j);
                System.out.print(this.plateau[i][j].toString());

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
