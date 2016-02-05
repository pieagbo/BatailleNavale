package com.company.model.bateaux;

import com.company.model.cases.Case;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by loua001 on 01/02/16.
 */
public abstract  class Bateau {
    String nom;
    int taille;
    protected boolean touch ;

    public Bateau(String nom, int taille) {
        this.nom = nom ;
        this.taille = taille ;
    }

    public int getTaille() {
        return taille;
    }

    public String getNom() {
        return nom;
    }

    public boolean isTouch(){
        return this.touch ;
    }

    public void setTouch(boolean touch) {
        this.touch = touch;
        taille-- ;
    }

    public boolean isDetroy() {
        return taille == 0 ;
    }

}