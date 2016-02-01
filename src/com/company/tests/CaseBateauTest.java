package com.company.tests;

import com.company.model.cases.CaseBateau;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pieagbo on 01/02/16.
 */
public class CaseBateauTest {
    CaseBateau caseBateau = new CaseBateau(0,0);

    @Test
    public void testToString() throws Exception {
        assertEquals(caseBateau.toString(),"~");

    }
}