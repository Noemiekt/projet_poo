package Test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import controllers.* ;

public class TestGameControls {
	
	@Test
    public void testSetCoord2() {
        GameControls gameControls = new GameControls();
        int lettre2 = gameControls.setCoord2(0);

        // Vérifie que la lettre2 est un nombre entre 1 et la longueur du mot
        Assertions.assertTrue(lettre2 >= 1 && lettre2 <= gameControls.longueur);
    }

    @Test
    public void testSetL1() {
        GameControls gameControls = new GameControls();
        gameControls.setL1(5);

        // Vérifie que la lettre1 a été mise à 0
        Assertions.assertEquals(0, gameControls.getL1());
    }

    @Test
    public void testSetL2() {
        GameControls gameControls = new GameControls();
        gameControls.setL2(5);

        // Vérifie que la lettre2 a été mise à une valeur aléatoire
        Assertions.assertNotEquals(5, gameControls.getL2());
    }

    @Test
    public void testGetL1() {
        GameControls gameControls = new GameControls();
        int lettre1 = gameControls.getL1();

        // Vérifie que la valeur de lettre1 est correcte
        Assertions.assertEquals(0, lettre1);
    }

    @Test
    public void testGetL2() {
        GameControls gameControls = new GameControls();
        int lettre2 = gameControls.getL2();

        // Vérifie que la valeur de lettre2 est correcte (aléatoire)
        Assertions.assertTrue(lettre2 >= 1 && lettre2 <= gameControls.longueur);
    }

    
}
