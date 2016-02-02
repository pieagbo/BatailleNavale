package com.company.model.bateaux;

import java.util.ArrayList;
import com.company.model.cases.Case;

/**
 * Created by loua001 on 01/02/16.
 */
public class Bateau {
    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Case> getCoordonnes() {
        return coordonnes;
    }

    public void setCoordonnes(ArrayList<Case> coordonnes) {
        this.coordonnes = coordonnes;
    }

    protected String nom;
    protected int taille;
    protected ArrayList<Case> coordonnes;

    public Bateau(String nom, int taille) {
        this.nom = nom ;
        this.taille = taille ;
        this.coordonnes = new ArrayList<>(taille) ;
    }

    public boolean isTouch()
    {
        return false;
    }

}
