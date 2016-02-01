package com.company.model.bateaux;

/**
 * Created by loua001 on 01/02/16.
 */
public class Torpilleur extends BateauModel
{
    public Torpilleur()
    {
        this.nom = "Torpilleur";
        this.taille = 2;
    }

    public boolean isTouch()
    {
        return false;
    }
}
