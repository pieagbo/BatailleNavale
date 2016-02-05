package com.company.model.joueurs;

import com.company.model.Plateau;
import com.company.model.bateaux.Bateau;
import com.company.model.bateaux.Croiseur;
import com.company.model.cases.Case;
import com.company.model.cases.CaseBateau;
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
        Bateau bateau= new Croiseur();
        ArrayList<Case> coordonnes = bateau.getCoordonnes();
        coordonnes.add(new CaseBateau(0,0));
        joueur.bateaux.add(bateau);

        Assert.assertFalse(joueur.hasLoose());
    }

    @Test
    public void testGetBateau(){

        Joueur joueur = new Joueur();
        Bateau bateau= new Croiseur();
        joueur.bateaux.add(bateau);
        Case uneCase = new CaseBateau(0,0);

        ArrayList<Case> coordonnes = bateau.getCoordonnes();
        coordonnes.add(uneCase);

        Assert.assertEquals(joueur.getBateau(uneCase), bateau);
    }

    @Test
    public void testerBonPositionnementBateau(){
//        Plateau plat = new Plateau();
//        Joueur joueur = new Joueur();
//        Bateau bateau= new Croiseur();
//        joueur.bateaux.add(bateau);
//
//        Case uneCase = new CaseBateau(0,0);
//
//        joueur.positionnerUnBateau(bateau, plat, "00;02");
//
//        Assert.assertEquals(bateau.getCoordonnes().get(2).getX()
//                , 0);
//        Assert.assertEquals(bateau.getCoordonnes().get(2).getY()
//                , 1);
//
//
//

    }

}