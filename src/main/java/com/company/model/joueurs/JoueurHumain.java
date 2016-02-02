package main.java.com.company.model.joueurs;

import main.java.com.company.model.Plateau;
import main.java.com.company.model.bateaux.Bateau;

import java.util.Scanner;

/**
 * Created by rrauzduel on 02/02/16.
 */
public class JoueurHumain extends Joueur {

    public JoueurHumain(Plateau grille) {
        super( grille);
    }

    @Override
    public void placerBateaux(Plateau grille) {

        for(Bateau b : this.mesBateaux) {
            System.out.print(" Entrez les coordonées de votre bateau : " + b.getNom() + " de taille " + b.getTaille());

            Scanner scan = new Scanner(System.in);
            positionnerUnBateau(b, grille, scan.nextLine());


        }

    }

    @Override
    public void creerJoueur() {

    }
}
