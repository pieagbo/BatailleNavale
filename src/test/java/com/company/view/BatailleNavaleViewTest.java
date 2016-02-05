package com.company.view;

import com.company.controller.BatailleNavaleController;
import com.company.model.BatailleNavaleModel;
import com.company.model.Plateau;
import com.company.model.joueurs.Joueur;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatailleNavaleViewTest {

    @Test
    public void testConversionSaisiClavier() throws Exception {
        BatailleNavaleView b = createBatailleNavaleViewWithoutScanner();

        String input = "C5";
        input.substring(0, 1);
        int last = Integer.parseInt(input.substring(1,2));

        int res = b.getIndexInAlphabet(input.charAt(0));

        assertEquals("24", res + String.valueOf(last - 1));
    }

    @Test
    public void testConvertToCustomString() throws Exception{
        BatailleNavaleView b = createBatailleNavaleViewWithoutScanner();
        int[] rc = new int[3];
        int[] res = b.convertToCustomString(rc,"v",3);
        Assert.assertEquals(res[0],rc[0]);

    }

    private BatailleNavaleView createBatailleNavaleViewWithoutScanner() {
        BatailleNavaleModel model = new BatailleNavaleModel();
        BatailleNavaleController controller = new BatailleNavaleController(model);
        return new BatailleNavaleView(model, controller) {
            @Override
            int[] askWhereShoot() {
                int[] rc = new int[2];
                return rc;
            }

            @Override
            void setJoueurName(Joueur player) {
            }

            @Override
            void setJoueurBoats(Joueur player, Plateau grille) {

            }
        };
    }

    private BatailleNavaleView createBatailleNavaleView() {
        BatailleNavaleModel model = new BatailleNavaleModel();
        BatailleNavaleController controller = new BatailleNavaleController(model);
        return new BatailleNavaleView(model, controller);
    }
}
