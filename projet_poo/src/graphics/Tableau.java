package graphics;

import controllers.Matrice;

public class Tableau extends Matrice {
	public static char[][] TabInput; //Tableau mot saisi
	public static int[][] TabVerification;
	public static int[][] TabRightPlaced;
	public static int currentAttempt;
	
	// Initialiser la grille de la bonne taille
	public Tableau(int longueur) {
		
		TabInput = new char[8][longueur];
		TabVerification = new int[8][longueur];
		TabRightPlaced = new int[8][longueur];
		
		// Initialiser toutes les valeurs à un caractère par défaut, par exemple un espace ' '
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < longueur; j++) {
                TabInput[i][j] = '-';
                TabVerification[i][j] = 0;
                TabRightPlaced[i][j] = 0;
            }
        }
        currentAttempt = 0;
	}
	
	public boolean addAttempt(String motJoueur){
		if((motJoueur.length() == TabInput[0].length) && (currentAttempt < 8)) {
			for(int i=0; i<longueur; i++) {
                // Mettre chaque caractère à la bonne case
                TabInput[currentAttempt][i] = motJoueur.charAt(i);
            }
            // Copier les valeurs du tableau 'ligne' dans 'TabVerification' pour l'essai courant
            if (lineVerification.length == TabInput[0].length) {
                System.arraycopy(lineVerification, 0, TabVerification[currentAttempt], 0, lineVerification.length);
            } else {
                return false;
            }
            
            currentAttempt++;
            return true;
        }
        return false;
    }

	
	//Fonction qui retourne le tableau des mots saisis
	public char[][] getTabInput() {
        return TabInput;
    }
	
	//Fonction qui retourne le tableau des positions des lettres 0,1,2
	public int[][] getTabVerification() {
        return TabVerification;
    }
	
	//Affiche la table juste pour test 
	public void printTabInput() {
        for (int i = 0; i < currentAttempt; i++) { 
            for (int j = 0; j < TabInput[i].length; j++) {
                System.out.print(TabInput[i][j] + " ");
            }
            System.out.println();
        }
    }
	public void printTabVerification() {
        for (int i = 0; i < currentAttempt; i++) { 
            for (int j = 0; j < TabVerification[i].length; j++) {
                System.out.print(TabVerification[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	
}
