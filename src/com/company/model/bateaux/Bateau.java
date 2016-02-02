package com.company.model.bateaux;

import com.company.model.cases.Case;
import com.company.model.cases.CaseBateau;

/**
 * Created by loua001 on 01/02/16.
 */
public abstract class Bateau {
    protected String nom;
    protected int taille;
    protected Case[] coordonnes;

    public Bateau(String nom, int taille) {
        this.nom = nom ;
        this.taille = taille ;
        this.coordonnes = new CaseBateau[taille] ;
    }

    public boolean isDestroy()
    {
        int i =  0 ;
        while(i < coordonnes.length) {
            if (!coordonnes[i].isTouch())
                return false;
        }
        return true;
    }

}
