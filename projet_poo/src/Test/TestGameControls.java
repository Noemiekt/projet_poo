package Test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import controllers.* ;


public class TestGameControls {
	
	@Test
    public void testSetBonneLettres() {
        GamesControls game = new GamesControls();
        int[] lettresBonPos = game.setBonneLettres(new int[game.longueur]);
        int[] expected = {0,1,2,3}; 
        Assertions.assertArrayEquals(expected, lettresBonPos);
    }

    @Test
    public void testSetMauvaiseEndroitLettre() {
        GamesControls game = new GamesControls();
        int[] lettresMalPos = game.setMauvaiseEndroitLettre(new int[game.longueur]);
        int[] expected = {};
        Assertions.assertArrayEquals(expected, lettresMalPos);
    }

    @Test
    public void testConstructorValidLength() {
        GamesControls game = new GamesControls(new int[GamesControls.longueur], new int[GamesControls.longueur], GamesControls.motJoueur);
        Assertions.assertNotNull(game);
    }


    @Test
    public void testConstructorValidFirstLetter() {
        GamesControls game = new GamesControls(new int[GamesControls.longueur], new int[GamesControls.longueur], GamesControls.motJoueur);
        Assertions.assertNotNull(game);
        // Vérifier que la première lettre de motJoueur est la même que la première lettre de mot
        Assertions.assertEquals(GamesControls.mot.charAt(0), GamesControls.motJoueur.charAt(0));
    }

    @Test
    public void testSetMotJoueurValid() {
        GamesControls game = new GamesControls();
        String motJoueur = "chat"; // Un mot valide
        Assertions.assertDoesNotThrow(() -> game.setMotJoueur(motJoueur));
    }

    @Test
    public void testSetMotJoueurInvalidLength() {
        GamesControls game = new GamesControls();
        String motJoueur = "chats"; // Mot de longueur incorrecte
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.setMotJoueur(motJoueur));
    }

    @Test
    public void testSetMotJoueurInvalidFirstLetter() {
        GamesControls game = new GamesControls();
        String motJoueur = "zhtj"; // Première lettre incorrecte
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.setMotJoueur(motJoueur));
    }
    
    @Test
    public void testSetMotJoueurInvalidLetter() {
        GamesControls game = new GamesControls();
        String motJoueur = "c\tj"; // Première lettre incorrecte
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.setMotJoueur(motJoueur));
    }

    @Test
    public void testSetMotJoueurInvalidCharacters() {
        GamesControls game = new GamesControls();
        String motJoueur = "cht1"; // Caractère non alphabétique
        Assertions.assertThrows(IllegalArgumentException.class, () -> game.setMotJoueur(motJoueur));
    }

}
