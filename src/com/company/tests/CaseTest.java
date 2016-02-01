package com.company.tests;

import com.company.model.cases.CaseBateau;
import com.company.model.cases.CaseMer;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseTest {
    CaseBateau caseBateau = new CaseBateau(0,0);
    CaseMer caseMer = new CaseMer(1,0);

    @Test
    public void CaseBateauToStringTest() throws Exception {
        assertEquals(caseBateau.toString(),"~");
    }

    @Test
    public void CaseMerToStringTest() throws Exception {
        caseMer.setTouch(true);
        assertEquals(caseMer.toString(), "M");
    }

}