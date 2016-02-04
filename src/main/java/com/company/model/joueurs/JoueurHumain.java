package com.company.model.joueurs;

import com.company.model.Plateau;
import com.company.model.bateaux.Bateau;

import java.util.Scanner;

/**
 * Created by rrauzduel on 02/02/16.
 */
public class JoueurHumain extends Joueur {

    public JoueurHumain(Plateau grille) {
        super(grille);
    }

    @Override
    public void placerBateaux(Plateau grille) {
        for(Bateau boat : this.bateaux) {
            grille.afficherPlateau(true);
            System.out.println("Votre " + boat.getNom() + " à une taille de " + boat.getTaille() + " cases.") ;
            System.out.println("Entrez les coordonées souhaitées pour le placer sur votre carte : ") ;

            Scanner scan = new Scanner(System.in);
            positionnerUnBateau(boat, grille, scan.nextLine());
            System.out.println();
        }
    }

    @Override
    public void creerJoueur() {

    }
}
