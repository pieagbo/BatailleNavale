package com.company.Model;

/**
 * Created by loua001 on 01/02/16.
 */
public class PorteAvionModel extends BateauModel{

    public PorteAvionModel()
    {
        this.nom = "Porte Avion";
        this.taille = 5;
    }

    public boolean isTouch()
    {
        return false;
    }
}
