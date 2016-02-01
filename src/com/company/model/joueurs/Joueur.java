package com.company.model.joueurs;

import com.company.model.bateaux.BateauModel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mlafourca002 on 01/02/16.
 */
public class Joueur {

    private String name ;
    private ArrayList<BateauModel> mesBateaux;

    public Joueur(){

        System.out.print(" Entrez votre Nom : ");
        Scanner scan = new Scanner(System.in);

        this.name = scan.nextLine();

        System.out.print(" Bon jeu " + name);
        this.mesBateaux = new ArrayList<>();
    }
}
