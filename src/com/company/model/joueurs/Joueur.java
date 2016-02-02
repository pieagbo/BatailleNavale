package com.company.model.joueurs;
import com.company.model.bateaux.*;
import java.util.ArrayList;import java.util.Scanner;
/*** Created by mlafourca002 on 01/02/16.*/
public class Joueur {

    private String name ;
    private ArrayList<Bateau> mesBateaux;
     public String coord ;

    public Joueur() {

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

    }

    public Joueur(String name) {

    }

    public Joueur(String name, Plateau grille) {

    }

    public void placerBateaux(){

        System.out.print(" Entrez les coordonées de votre premier bateau : "+ this.mesBateaux.get(0));
        Scanner scan = new Scanner(System.in);
        this.coord = scan.nextLine();
        //this.mesBateaux.get(0).coordonnes.set();


    }


    public void convertCoordonnées(){
        //this.coord;
    }
}