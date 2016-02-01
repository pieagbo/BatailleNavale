package com.company.model.bateaux;

/**
 * Created by loua001 on 01/02/16.
 */
public class ContreTorpilleur extends BateauModel
{
    public ContreTorpilleur()
    {
        this.nom = "Contre-torpilleur";
        this.taille = 3;
    }

    public boolean isTouch()
    {
        return false;
    }
}
