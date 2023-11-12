package graphics;

import controllers .*;

public class TableauTest {
	
	public static void main(String[] args) {
	 
	
	    Tableau tableau = new Tableau(5); //Supposons le mot à deviner à 5 lettres 

        // Simuler quelques tentatives avec des mots de longueur 5.
	    
        tableau.addAttempt("abcde");
        Matrice.lineVerification = new int[]{2, 1, 0, 0, 0}; // Simuler la vérification de la première tentative.
        tableau.updateTabRightPlaced();

        // Afficher les états des tableaux après les tentatives.
        System.out.println("Tableau des mots saisis (TabInput) : ");
        tableau.printTabInput();

        System.out.println("\nTableau de vérification des positions des lettres (TabVerification) : ");
        tableau.printTabVerification();

        System.out.println("\nTableau des lettres bien positionnées (TabRightPlaced) : ");
        tableau.printTabRightPlaced();
        
		}
}

