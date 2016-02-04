package com.company.model;

import com.company.model.cases.Case;
import com.company.model.cases.CaseBateau;
import com.company.model.cases.CaseMer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaseTest {

    @Test
    public void testCaseBateauToString() throws Exception {
        Case c = new CaseBateau(0,0);
        assertEquals("B", c.toString());
    }

    @Test
    public void testCaseMerToString() throws Exception {
        Case c = new CaseMer(1,0);
        assertEquals("~", c.toString());
    }

    @Test
    public void caseIsTouch() throws Exception {
        CaseMer c = new CaseMer(0, 0);
        c.setTouch(true);

        assertEquals("M", c.toString());
    }
}
