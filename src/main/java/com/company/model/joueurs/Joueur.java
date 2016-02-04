package com.company.model.joueurs;

import com.company.model.Plateau;
import com.company.model.bateaux.*;
import com.company.model.cases.CaseBateau;

import java.util.ArrayList;import java.util.Scanner;

/*** Created by mlafourca002 on 01/02/16.*/
public abstract class Joueur {

    public String getName() {
        return name;
    }

    protected String name ;
    protected ArrayList<Bateau> bateaux;

    public Joueur(Plateau grille) {

        System.out.println("Bienvenue a vous et que la bataille commence");
        System.out.print("Entrez votre nom : ");
        Scanner scan = new Scanner(System.in);
        this.name = scan.nextLine();
        System.out.println();

        System.out.println("Avant de commencer, veuillez placer vos bateaux sur la carte.");
        System.out.println("Ex : Pour placer un bateau de taille 5 de la case (0,0) à la case (0,4)");
        System.out.println("sur l'axe des abscisses, entrez 01;05");
        System.out.println();

        this.bateaux = new ArrayList<>();
        this.bateaux.add(new Torpilleur());
        this.bateaux.add(new Croiseur());
        //this.bateaux.add(new PorteAvion());
        //this.bateaux.add(new SousMarin());
        //this.bateaux.add(new ContreTorpilleur());

        placerBateaux(grille);
    }

    public  void positionnerUnBateau(Bateau bateau, Plateau plateau, String coordonnees){
        int x, y, x1, y1, aa ;

        String[] parts = coordonnees.split(";");

        String parts1 = parts[0];
        String parts2 = parts[1];

        x = Integer.parseInt(parts1.substring(0,1));
        y = Integer.parseInt(parts1.substring(1));

        x1 = Integer.parseInt(parts2.substring(0,1));
        y1 = Integer.parseInt(parts2.substring(1));

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

    public abstract void placerBateaux( Plateau grille);

    public abstract void creerJoueur();
}
