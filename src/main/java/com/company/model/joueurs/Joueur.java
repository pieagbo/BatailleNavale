package main.java.com.company.model.joueurs;

import main.java.com.company.model.Plateau;
import main.java.com.company.model.bateaux.*;
import main.java.com.company.model.cases.CaseBateau;

import java.util.ArrayList;import java.util.Scanner;
/*** Created by mlafourca002 on 01/02/16.*/
public abstract class Joueur {

    protected String name ;
    protected ArrayList<Bateau> mesBateaux;
    protected int points ;

    public Joueur( Plateau grille) {
        this.points = 0 ;
    
        System.out.print(" Entrez votre Nom : ");

        Scanner scan = new Scanner(System.in);
        this.name = scan.nextLine();

        Croiseur unCroiseur = new Croiseur();
        PorteAvion unPorteAvion = new PorteAvion();
        Torpilleur unTorpilleur = new Torpilleur();
        SousMarin unSousMarin = new SousMarin();
        ContreTorpilleur unContreTorpilleur = new ContreTorpilleur();

        System.out.print(" Bon jeu " + name);

        this.mesBateaux = new ArrayList<>();

        this.mesBateaux.add(unCroiseur);
        this.mesBateaux.add(unPorteAvion);
        this.mesBateaux.add(unTorpilleur);
        this.mesBateaux.add(unSousMarin);
        this.mesBateaux.add(unContreTorpilleur);

        placerBateaux(grille);

    }
    public abstract void placerBateaux( Plateau grille);



    public  void positionnerUnBateau(Bateau unBateau, Plateau unPlateau, String coord ){


        int x,y,x1,y1;


        String[] parts = coord.split(";");

        String parts1 = parts[0];
        String parts2 = parts[1];

        x = Integer.parseInt(parts1.substring(0,1));
        y = Integer.parseInt(parts1.substring(1));

        x1 = Integer.parseInt(parts2.substring(0,1));
        y1 = Integer.parseInt(parts2.substring(1));

        System.out.println(x+""+y+""+x1+""+y1);

        CaseBateau CaseD = new CaseBateau(x,y);
        unPlateau.setCase(x,y,CaseD);
        unBateau.getCoordonnes().add(CaseD);
        CaseBateau CaseArr = new CaseBateau(x1,y1);
        unPlateau.setCase(x1,y1,CaseArr);
        unBateau.getCoordonnes().add(CaseArr);
        if (x==x1) {
            while (y <= y1) {
                int z = y++;
                CaseBateau CaseMillieu = new CaseBateau(x, z);
                unPlateau.setCase(x,z,CaseMillieu);
                unBateau.getCoordonnes().add(CaseMillieu);
            }
        }else if (y==y1) {
            while (x <= x1) {
                int z = x++;
                CaseBateau CaseMillieu = new CaseBateau(z,y);
                unPlateau.setCase(z,y,CaseMillieu);
                unBateau.getCoordonnes().add(CaseMillieu);
            }
        }
    }


    public abstract void creerJoueur();

    public void addPoint() {this.points++;
    }
}
