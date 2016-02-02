package main.java.com.company.test;

import main.java.com.company.model.cases.CaseBateau;
import main.java.com.company.model.cases.CaseMer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseTest {
    CaseBateau caseBateau = new CaseBateau(0,0);
    CaseMer caseMer = new CaseMer(1,0);

    @Test
    public void CaseBateauToStringTest() throws Exception {
        assertEquals(caseBateau.toString(),"B");
    }

    @Test
    public void CaseMerToStringTest() throws Exception {
        caseMer.setTouch(true);
        assertEquals(caseMer.toString(), "M");
    }

}