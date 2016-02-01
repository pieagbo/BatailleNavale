package com.company.model.bateaux;

/**
 * Created by loua001 on 01/02/16.
 */
public class SousMarin extends BateauModel
{
    
    public SousMarin()
    {
        this.nom = "Sous-marin";
        this.taille = 3;
    }
    public boolean isTouch()
    {
        return false;
    }
}
