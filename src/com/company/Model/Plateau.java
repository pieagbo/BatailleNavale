package com.company.Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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



}
