package main.java.com.company.model.bateaux;

import main.java.com.company.model.cases.Case;

import java.util.ArrayList;

/**
 * Created by loua001 on 01/02/16.
 */
public class Bateau {
    protected String nom;
    protected int taille;
    protected ArrayList<Case> coordonnes;

    public Bateau(String nom, int taille) {
        this.nom = nom ;
        this.taille = taille ;
        this.coordonnes = new ArrayList<>(taille) ;
    }

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

    public boolean isTouch()
    {
        return false;
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
