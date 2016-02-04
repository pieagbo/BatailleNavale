package com.company.model.cases;

import com.company.model.cases.CaseBateau;
import com.company.model.cases.CaseMer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseTest {
    CaseBateau caseBateau = new CaseBateau(0,0);
    CaseMer caseMer = new CaseMer(1,0);

    @Test
    public void CaseBateauVisibleToStringTest() throws Exception {
        assertEquals(caseBateau.toString(true)," B ");
    }

    @Test
    public void CaseBateauInvisibleToStringTest() throws Exception {
        assertEquals(caseBateau.toString(false)," ~ ");
    }

    @Test
    public void CaseMerToStringTest() throws Exception {
        caseMer.setTouch(true);
        assertEquals(caseMer.toString(true), " M ");
    }

}
