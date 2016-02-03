package com.company.model.joueurs;

import com.company.model.Plateau;
import com.company.model.bateaux.Bateau;

import java.util.Scanner;

/**
 * Created by rrauzduel on 02/02/16.
 */
public class JoueurIA extends Joueur {

    public JoueurIA( Plateau grille) {
        super( grille);
    }

    @Override
    public void placerBateaux(Plateau grille) {
        for(Bateau boat : this.bateaux) {
            System.out.println("Entrez les coordonées de votre " + boat.getNom() + " :") ;
            Scanner scan = new Scanner(System.in);
            positionnerUnBateau(boat, grille, scan.nextLine());
        }
    }

    @Override
    public void creerJoueur() {

    }
}
