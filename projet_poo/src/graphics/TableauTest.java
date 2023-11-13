package graphics;

import controllers .*;

public class TableauTest {
	
	public static void main(String[] args) {
	 
		// Création d'une instance de Tableau pour un mot de 4 lettres
        Tableau tableau = new Tableau(4);

        // Première tentative avec le mot "coco"
        tableau.addAttempt("coco");
        tableau.updateTabRightPlaced();
        // Affiche l'état actuel du tableau
        tableau.printTabInput();
        tableau.printTabVerification();
        tableau.printTabRightPlaced();

        // Deuxième tentative avec le mot "coca"
        tableau.addAttempt("coca");
        tableau.updateTabRightPlaced();
        // Affiche l'état actuel du tableau
        tableau.printTabInput();
        tableau.printTabVerification();
        tableau.printTabRightPlaced();

        // Troisième tentative avec le mot "caca"
        tableau.addAttempt("caaa");
        tableau.updateTabRightPlaced();
        // Affiche l'état actuel du tableau
        tableau.printTabInput();
        tableau.printTabVerification();
        tableau.printTabRightPlaced();
        
     // Troisième tentative avec le mot "caca"
        tableau.addAttempt("cooa");
        tableau.updateTabRightPlaced();
        // Affiche l'état actuel du tableau
        tableau.printTabInput();
        tableau.printTabVerification();
        tableau.printTabRightPlaced();
     
        // Troisième tentative avec le mot "caca"
        tableau.addAttempt("cooo");
        tableau.updateTabRightPlaced();
        // Affiche l'état actuel du tableau
        tableau.printTabInput();
        tableau.printTabVerification();
        tableau.printTabRightPlaced();
        
        // Troisième tentative avec le mot "caca"
        tableau.addAttempt("cooo");
        tableau.updateTabRightPlaced();
        // Affiche l'état actuel du tableau
        tableau.printTabInput();
        tableau.printTabVerification();
        tableau.printTabRightPlaced();
        
        
        // Troisième tentative avec le mot "caca"
        tableau.addAttempt("cooo");
        tableau.updateTabRightPlaced();
        // Affiche l'état actuel du tableau
        tableau.printTabInput();
        tableau.printTabVerification();
        tableau.printTabRightPlaced();
        
        // Troisième tentative avec le mot "caca"
        tableau.addAttempt("caca");
        tableau.updateTabRightPlaced();
        // Affiche l'état actuel du tableau
        tableau.printTabInput();
        tableau.printTabVerification();
        tableau.printTabRightPlaced();
        
        
        
        
        
        
		}
}

