package com.company.model.bateaux;

import com.company.model.cases.Case;

import java.util.ArrayList;

/**
 * Created by loua001 on 01/02/16.
 */
public class Bateau {
    String nom;
    int taille;
    ArrayList<Case> coordonnes;

    public Bateau(String nom, int taille) {
        this.nom = nom ;
        this.taille = taille ;
        this.coordonnes = new ArrayList<>(taille) ;
    }

    public int getTaille() {
        return taille;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Case> getCoordonnes() {
        return coordonnes;
    }

    public boolean isDetroy() {
        for (Case c : this.coordonnes){
            if(!c.isTouch()){
                return false ;
            }
        }
        return true;
    }

}
