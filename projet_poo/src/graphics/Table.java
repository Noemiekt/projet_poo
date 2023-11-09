package graphics;

import controllers.Matrice;

public class Table extends Matrice {
	
	public static String[][] TableauInput  = new String[8][motJoueur.length()];
	
	public Table(){
		this(new String[8][longueur]);
	}
	
	public Table(String[][] TableauInput) {
		setTable(TableauInput);
	}
	
	public String[][] setTable(String[][] TableauInput){
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < longueur; j++) {
				TableauInput[i][j] = String.valueOf(motJoueur.charAt(j));
				i++;
				j++;
			}
		}
		// Afficher le tableau
	    System.out.println("Tableau de mots : ");
	    for (String[] ligne : TableauInput) {
	        for (String caractere : ligne) {
	            System.out.print(caractere + " ");
	        }
	        System.out.println();  // Passer à la ligne suivante après chaque ligne du tableau
	    }
		return Table.TableauInput;
	}	

}
