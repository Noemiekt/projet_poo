package Test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import controllers.* ;

public class TestGameControls {
	
	public void testGameControls() {
		GameControls game = new GameControls(1, 6);
		Assertions.assertEquals(1, 6);
	}
	
	@Test
    public void testSetL1() {
        GameControls gameControls = new GameControls();
        gameControls.setL1(5);
        Assertions.assertEquals(0, gameControls.getL1()); // setCoord1 renvoie toujours 1
    }

    @Test
    public void testSetL2() {
        GameControls gameControls = new GameControls();
        gameControls.setL2(8);
        Assertions.assertEquals(8, gameControls.getL2());

        // Test with random value (should be between 1 and mot.length())
        int lettre2 = gameControls.getL2();
        Assertions.assertTrue(lettre2 >= 1 && lettre2 <= gameControls.longueur);
    }

    @Test
    public void testConstructorWithCoords() {
        GameControls gameControls = new GameControls(3, 6);
        Assertions.assertEquals(0, gameControls.getL1());
        Assertions.assertEquals(6, gameControls.getL2());
    }

    @Test
    public void testConstructorWithoutCoords() {
        GameControls gameControls = new GameControls();
        Assertions.assertEquals(0, gameControls.getL1()); // setCoord1 renvoie toujours 1
        int lettre2 = gameControls.getL2();
        Assertions.assertTrue(lettre2 >= 1 && lettre2 <= gameControls.longueur);
    }

    
}
