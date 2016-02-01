package com.company.Model;

/**
 * Created by loua001 on 01/02/16.
 */
public class Croiseur extends BateauModel
{
    public Croiseur()
    {
        this.nom = "Croiseur";
        this.taille = 4;
    }

    public boolean isTouch()
    {
        return false;
    }
}
