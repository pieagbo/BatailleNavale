package com.company.model.joueurs;

import com.company.model.Plateau;
import com.company.model.bateaux.*;
import com.company.model.cases.Case;
import com.company.model.cases.CaseBateau;

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

        CaseBateau CaseD = new CaseBateau(x,y);
        plateau.setCase(x, y, CaseD);

        bateau.getCoordonnes().add(CaseD);
        CaseBateau CaseArr = new CaseBateau(x1,y1);

        plateau.setCase(x1, y1, CaseArr);
        bateau.getCoordonnes().add(CaseArr);
        if (x == x1) {
            while (y < (y1 - 1) ) {
                y++;
                CaseBateau CaseMillieu = new CaseBateau(x, y);
                plateau.setCase(x, y, CaseMillieu);
                bateau.getCoordonnes().add(CaseMillieu);
            }
        } else if (y == y1) {
            while (x < (x1 - 1) ) {
                x++;
                CaseBateau CaseMillieu = new CaseBateau(x,y);
                plateau.setCase(x, y, CaseMillieu);
                bateau.getCoordonnes().add(CaseMillieu);
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


    public Bateau getBateau(Case uneCase) {
        for (Bateau b : this.bateaux) {
            for (Case c : b.getCoordonnes()){
                if (c.getX() == uneCase.getX() && c.getY() == uneCase.getY()) {
                    return b ;
                }
            }
        }
        return null;
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
}