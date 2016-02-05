package com.company.model.joueurs;

import com.company.model.Plateau;
import com.company.model.bateaux.*;
import com.company.model.cases.Case;

import java.util.ArrayList;import java.util.Scanner;

/*** Created by mlafourca002 on 01/02/16.*/
public class Joueur {

    protected String name ;
    protected ArrayList<Bateau> bateaux;

    public Joueur() {
        this.name = "" ;
        this.bateaux = new ArrayList<>();
        this.bateaux.add(new Torpilleur());
        this.bateaux.add(new Croiseur());
        this.bateaux.add(new PorteAvion());
        this.bateaux.add(new SousMarin());
        this.bateaux.add(new ContreTorpilleur());
    }

    public  void positionnerUnBateau(Bateau bateau, Plateau plateau, int[] coordonnees){
        int x, y, x1, y1 ;

        x = coordonnees[0];
        y = coordonnees[1];

        x1 = coordonnees[2];
        y1 = coordonnees[3];

        plateau.addBoat(x, y, bateau);

        plateau.addBoat(x1, y1, bateau);

        if (x == x1) {
            while (y < (y1 - 1) ) {
                y++;
                plateau.addBoat(x, y, bateau);
            }
        } else if (y == y1) {
            while (x < (x1 - 1) ) {
                x++;
                plateau.addBoat(x, y, bateau);
            }
        }
    }

    public boolean hasLoose(){
        for (Bateau b : this.bateaux){
            if (!b.isDetroy()){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Bateau> getBateaux() {
        return bateaux;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBateauxInLife() {
        int i = 0 ;
        for (Bateau boat : this.getBateaux()) {
            if (!boat.isDetroy())
                i++ ;
        }
        return i ;
    }
}