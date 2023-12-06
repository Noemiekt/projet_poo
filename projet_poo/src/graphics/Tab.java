package graphics;

import controllers.GameControlsBegin;
import controllers.GamesControls;
import controllers.Matrice;

public class Tab extends Matrice {
	
	

	public static void initTabVerification() {
		
		MotusVariable.TabVerification=new int[7][MotusVariable.nbLettre];

		
		for (int i = 0; i < 7; i++) {
	        for (int j = 0; j < MotusVariable.nbLettre; j++) {
	        	MotusVariable.TabVerification[i][j] = -1;
	        }
	    }
		
		GameControlsBegin.initmotdebase();
				
		MotusVariable.TabVerification[0][GameControlsBegin.setCoord1()]=2;
		MotusVariable.TabVerification[0][GameControlsBegin.setCoord2()]=2;
		
		MotusGameLeftPanel.afficherTableau(MotusVariable.TabVerification);
		
	}
	
	
	public static void initTabInput() {
		MotusVariable.TabInput=new char[7][MotusVariable.nbLettre];
		
		MotusVariable.TabInput[0]=(MotusVariable.motAtrouver).toCharArray();
		

	}
	
	public static void modifTabVerification() {
		int[] position =GamesControls.setPositionInt();

		
        if (MotusVariable.nbEssai<7) {
        	for (int i = 0; i < MotusVariable.nbLettre; i++) {
    			if ((MotusVariable.TabVerification[MotusVariable.nbEssai-1][i]==2)||(position[i]==2)) {
    				MotusVariable.TabVerification[MotusVariable.nbEssai][i]=2;
    			}
    		}   	
        }
		MotusVariable.TabVerification[MotusVariable.nbEssai-1]=position;
		
	}
	
	public static void modifTabInput() {	
		MotusVariable.TabInput[MotusVariable.nbEssai-1]=(MotusVariable.userInput).toCharArray();
		if (MotusVariable.nbEssai<7) {
			MotusVariable.TabInput[MotusVariable.nbEssai]=(MotusVariable.motAtrouver).toCharArray();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// TABINPUT
	// mot = mot de dictionnaire 
//	public void setTabInput(String motJoueur){
//		if (currentAttempt == 0) {
//			if(mot != null && mot.length() >= 4) {
////				TabInput[0][lettre1]= premiereLettre; //lettre1 = 0 normalement 
////				// lettre 2 indice aléatoire deuxième lettre 
////		        TabInput[0][lettre2] = lettreAuHasard; 
//		        currentAttempt ++;
//			}
//		} else if (currentAttempt <7) {
//			//Le joueur commence à joue
//			if (motJoueur != null && motJoueur.length() == longueur) {
//				for (int i = 0; i < longueur; i++) {
//		            TabInput[currentAttempt][i] = motJoueur.charAt(i);
//		        }
//		        currentAttempt++; 
//			}  
//		}
//	}
	
	// TABVERIFICATION
//	public boolean TabVerification(String motJoueur) {
//	    if (currentAttempt < 7 && motJoueur != null && motJoueur.length() == TabInput[0].length) {
//	        // Copier les valeurs du tableau 'ligne' dans 'TabVerification' pour l'essai courant
//	        if (lineVerification.length == TabInput[0].length) {
//	            System.arraycopy(lineVerification, 0, TabVerification[currentAttempt], 0, lineVerification.length);
//	            currentAttempt++;
//	            return true;
//	        } else {
//	            return false;
//	        }
//	    }
//	    return false;
//	}
	
	/*
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
//	public char[][] getTabInput() {
//        return TabInput;
//    }
	
	//Fonction qui retourne le tableau des positions des lettres 0,1,2
	public int[][] getTabVerification() {
        return TabVerification;
    }
	
	//Fonction qui retourne le tab des lettres bien positionnées: 0,1
		public int[][] getTabRightPlaced() {
	        return TabRightPlaced;
	    }
	
	
	//Affiche la table juste pour test 
//	public void printTabInput() {
//        for (int i = 0; i < currentAttempt; i++) { 
//            for (int j = 0; j < TabInput[i].length; j++) {
//                System.out.print(TabInput[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
	
	public void printTabVerification() {
        for (int i = 0; i < 7; i++) { 
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
	
	*/
}
