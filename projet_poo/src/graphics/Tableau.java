package graphics;

import controllers.GameControlsBegin;
import controllers.Matrice;

public class Tableau extends Matrice {
	
	static Matrice mat = new Matrice();
	
	public static char[][] TabInput; //Tableau stockant le mot saisi
	public static int[][] TabVerification; 	//Tableau stockant 0,1,2
	public static int[][] TabRightPlaced;	// Tbleau stockant 0,1
	public static int currentAttempt = 0;	// La tentative courante 
	//public static int[] currentLineRightPlaced = mat.lineRightPlaced ;
	
	


	
	
	// INITIALISATION DE LA GRILLE À LA BONNE TAILLE 
	public Tableau(int longueur) {
		TabInput = new char[7][longueur];
		TabVerification = new int[7][longueur];
		TabRightPlaced = new int[7][longueur];
		
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
	
	// TABINPUT
	// mot = mot de dictionnaire 
	public void setTabInput(String motJoueur){
		if (currentAttempt == 0) {
			if(mot != null && mot.length() >= 4) {
				TabInput[0][lettre1]= premiereLettre; //lettre1 = 0 normalement 
				// lettre 2 indice aléatoire deuxième lettre 
		        TabInput[0][lettre2] = lettreAuHasard; 
		        currentAttempt ++;
			}
		} else if (currentAttempt <7) {
			//Le joueur commence à joue
			if (motJoueur != null && motJoueur.length() == longueur) {
				for (int i = 0; i < longueur; i++) {
		            TabInput[currentAttempt][i] = motJoueur.charAt(i);
		        }
		        currentAttempt++; 
			}  
		}
	}
	
	// TABVERIFICATION
	public boolean TabVerification(String motJoueur) {
	    if (currentAttempt < 7 && motJoueur != null && motJoueur.length() == TabInput[0].length) {
	        // Copier les valeurs du tableau 'ligne' dans 'TabVerification' pour l'essai courant
	        if (lineVerification.length == TabInput[0].length) {
	            System.arraycopy(lineVerification, 0, TabVerification[currentAttempt], 0, lineVerification.length);
	            currentAttempt++;
	            return true;
	        } else {
	            return false;
	        }
	    }
	    return false;
	}
	
	
	// TABLERIGHTPLACED
	public void updateTabRightPlaced() {
	    if (currentAttempt == 0) {
	        TabRightPlaced[0][0] = 1;
	        TabRightPlaced[0][lettre2] = 1;
	        currentAttempt++;
	    }

	    while (currentAttempt < 7) {
	        for (int i = 0; i < longueur; i++) {
	            // Si la lettre est bien placée dans l'essai précédent, conservez la valeur
	            if (TabRightPlaced[currentAttempt - 1][i] == 1) {
	                TabRightPlaced[currentAttempt][i] = 1;
	            } else {
	                // Sinon, utilisez la valeur de lineRightPlaced
	                TabRightPlaced[currentAttempt][i] = lineRightPlaced[i];
	            }
	        }
	        currentAttempt++;
	    }
	}
	
	
	
	
	//Fonction qui retourne le tableau des mots saisis
	public char[][] getTabInput() {
        return TabInput;
    }
	
	//Fonction qui retourne le tableau des positions des lettres 0,1,2
	public int[][] getTabVerification() {
        return TabVerification;
    }
	
	//Fonction qui retourne le tab des lettres bien positionnées: 0,1
		public int[][] getTabRightPlaced() {
	        return TabRightPlaced;
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
	
	public void printTabRightPlaced() {
        for (int i = 0; i < currentAttempt; i++) { 
            for (int j = 0; j < TabRightPlaced[i].length; j++) {
                System.out.print(TabRightPlaced[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	public void printlineVerification() {
        for (int i = 0; i < longueur; i++) { 
                System.out.print(mat.lineVerification[i] + " ");
        }
    }
	
	
}
