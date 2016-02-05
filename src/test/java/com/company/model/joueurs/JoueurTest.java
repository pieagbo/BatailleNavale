package com.company.model.joueurs;

import com.company.model.Plateau;
import com.company.model.bateaux.Bateau;
import com.company.model.bateaux.Croiseur;
import com.company.model.bateaux.Torpilleur;
import com.company.model.cases.Case;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by pieagbo on 02/02/16.
 */
public class JoueurTest {

    @Test
    public void checkPLayerLoose(){
        Joueur joueur = new Joueur();

        Case c1 = new Case(0,0) ;
        Case c2 = new Case(0,1) ;

        Bateau bateau= new Torpilleur();

        c1.addBoat(bateau);
        c2.addBoat(bateau);

        joueur.bateaux.clear();
        joueur.bateaux.add(bateau);

        c1.setTouch(true);
        c2.setTouch(true);

        Assert.assertTrue(joueur.hasLoose());
    }

    @Test
    public void testBateauInLife(){
        Joueur joueur = new Joueur();

        Case c1 = new Case(0,0) ;
        Case c2 = new Case(0,1) ;

        Bateau bateau= new Croiseur();

        c1.addBoat(bateau);
        c2.addBoat(bateau);

        Assert.assertEquals(5, joueur.getBateauxInLife());
    }

    @Test
    public void testPlacerBateau(){
        Plateau g = new Plateau() ;
        Joueur joueur = new Joueur();

        int[] coordonnes = new int[4] ;
        coordonnes[0] = 0 ;
        coordonnes[1] = 0 ;
        coordonnes[2] = 0 ;
        coordonnes[3] = 1 ;

        joueur.bateaux.clear();

        Case c1 = new Case(0,0) ;
        Case c2 = new Case(0,1) ;

        Bateau bateau= new Croiseur();

        c1.addBoat(bateau);
        c2.addBoat(bateau);

        joueur.bateaux.add(bateau);

        joueur.positionnerUnBateau(bateau, g, coordonnes);

        Assert.assertEquals(" B ", g.getCase(0,0).display(true));
    }

}