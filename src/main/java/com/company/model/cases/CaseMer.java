package com.company.model.cases;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseMer extends Case{

    public CaseMer(int x, int y) {

        super(x,y);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public String toString(boolean boatVisible) {
        return this.touch ? " M " : " ~ " ;
    }
}
