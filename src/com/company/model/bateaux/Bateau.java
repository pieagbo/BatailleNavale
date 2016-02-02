package com.company.model.bateaux;

import com.company.model.cases.Case;

/**
 * Created by loua001 on 01/02/16.
 */
public class Bateau {
    protected String nom;
    protected int taille;
    protected Case[] coordonnes;

    public Bateau(String nom, int taille) {
        this.nom = nom ;
        this.taille = taille ;
        this.coordonnes = new Case[taille] ;
    }

    public boolean isTouch()
    {
        return false;
    }

}
