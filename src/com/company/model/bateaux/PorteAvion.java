package com.company.model.bateaux;

/**
 * Created by loua001 on 01/02/16.
 */
public class PorteAvion extends BateauModel{

    public PorteAvion()
    {
        this.nom = "Porte Avion";
        this.taille = 5;
    }

    public boolean isTouch()
    {
        return false;
    }
}
