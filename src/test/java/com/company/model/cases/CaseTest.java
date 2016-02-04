package com.company.model;

import com.company.model.cases.CaseBateau;
import com.company.model.cases.CaseMer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseTest {

    private final boolean visible = true;

    @Test
    public void caseBateauToStringTest() throws Exception {
        CaseBateau caseBateau = new CaseBateau(0,0);

        assertEquals(" B ", caseBateau.toString(visible));
    }

    @Test
    public void caseMerTouchToStringTest() throws Exception {
        CaseMer caseMer = new CaseMer(1,0);

        caseMer.setTouch(true);
        assertEquals(" M ", caseMer.toString(visible));
    }


    @Test
    public void caseMerToStringTest() throws Exception {
        CaseMer caseMer = new CaseMer(1,0);

        assertEquals(" ~ ", caseMer.toString(visible));
    }

}
