package controllers;

import graphics .*;
import java.util.ArrayList;


public class GamesControls extends GameControlsBegin {
    /*public static String motJoueur = graphics.MotusFrame.userInput ;
	//public static String motJoueur = "";
    public static int[] lettresBonPos;
    public static int[] lettresMalPos;
    public static int erreur_int;
    public static String erreur_string;

    public GamesControls() {
        this(new int[longueur], new int[longueur], motJoueur, erreur_int, erreur_string);
    }

    public GamesControls(String motJoueur) {
        this(); // Appel au constructeur par défaut
        setMotJoueur(motJoueur);
    }
    
    public GamesControls(int[] lettresBonPos, int[] lettresMalPos, String motJoueur, int erreur_int2, String erreur_string2) {
        setBonPos(lettresBonPos);
        setMalPos(lettresMalPos);
        setMotJoueur(motJoueur);
        setErreurInt(erreur_int, motJoueur);
        setErreurString(erreur_string, motJoueur);
    }
    */
    
    public static int setErreurInt() {
        if (!MotusVariable.userInput.matches("^[a-zA-Z]+$")) {
      	  return 1;
        }
        if (MotusVariable.userInput.length() != MotusVariable.nbLettre) {
      	  return 2;
	  	  }
	  	  if (MotusVariable.userInput.charAt(0) != MotusVariable.motAtrouver.charAt(0)) {
	  		  System.out.println(MotusVariable.userInput.charAt(0));
	  		  System.out.println(MotusVariable.motAtrouver.charAt(0));
	      	  return 3;
	  	  }
	  	  else {
	      	  return 0;
	  	  }   
    }
    

    public static int compterOccurencesLettre(String mot, char lettre) {
        int compteur = 0;

        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == lettre) {
                compteur++;
            }
        }
        return compteur;
    }
    
    
    public static int[] setPositionInt() {

        int[] position = new int[MotusVariable.nbLettre];

        // Marquer les lettres bien placées (position i : 2)
        for (int i = 0; i < MotusVariable.motAtrouver.length(); i++) {
            if (MotusVariable.userInput.charAt(i) == MotusVariable.motAtrouver.charAt(i)) {
                position[i] = 2;
            }
        }

        // Marquer les lettres mal placées (position i : 1)
        for (int i = 0; i < MotusVariable.motAtrouver.length(); i++) {
            if (position[i] == 2) {
                continue; // Si la lettre est déjà bien placée, passer à la suivante
            }
            
            int occ = compterOccurencesLettre(MotusVariable.motAtrouver, MotusVariable.userInput.charAt(i));
            System.out.print("occ " + occ + MotusVariable.userInput.charAt(i));
            
            
            for (int j = 0; j < MotusVariable.motAtrouver.length(); j++) {
            	if (occ ==0) {
            		break;
            	}
            	System.out.print("occ " + occ + MotusVariable.userInput.charAt(i));
            	System.out.println();
            	System.out.print("char à rechercher " + MotusVariable.motAtrouver.charAt(j));
            	System.out.println();
            	System.out.print("position " + position[j]);
            	System.out.println();

            	if (MotusVariable.motAtrouver.charAt(j)==MotusVariable.userInput.charAt(i) && (position[j] == 1 || position[j] == 2 )&& occ>0) {
            		occ --;
            		System.out.println("zizi");
            	}
            	
            }
            System.out.print("occ avant if " + occ + MotusVariable.userInput.charAt(i));
            
            if (occ >0) {
            	position[i] = 1;
            	
            }
            
            

        }

        // Les lettres non marquées sont mal placées (position i : 0)
        for (int i = 0; i < MotusVariable.motAtrouver.length(); i++) {
            if (position[i] != 0 && position[i] != 1) {
                position[i] = 2;
            }
        }

        return position;
    }
    
    /*
    
    
    public String setMotJoueur(String motJoueur) {
//        if (motJoueur.length() != longueur) {
//            throw new IllegalArgumentException("Vous devez avoir un mot de la bonne longueur.");
//        }
//        if (motJoueur.charAt(0) != mot.charAt(0)) {
//            throw new IllegalArgumentException("Vous devez reprendre la première lettre du mot.");
//        }
//        if (!motJoueur.matches("^[a-zA-Z]+$")) {
//            throw new IllegalArgumentException("Vous ne devez utiliser que des lettres.");
//        }
        this.motJoueur = motJoueur; 
        return motJoueur;
    }
    
    // On verifie les erreurs et on associe un int 	
    public String setErreurString(String erreur_string, String motJoueur) {
      this.motJoueur = motJoueur; 
      
      if (!motJoueur.matches("^[a-zA-Z]+$")) {
    	  this.erreur_string = "Vous ne devez utiliser que des lettres.";
    	  return erreur_string;
      }
      if (motJoueur.length() != longueur) {
    	  this.erreur_string = "Vous devez avoir un mot de la bonne longueur.";
    	  return erreur_string;
    	  
	  }
	  if (motJoueur.charAt(0) != mot.charAt(0)) {
		  this.erreur_string = "Vous devez reprendre la première lettre du mot.";
    	  return erreur_string;
	  }
	  else {
		  this.erreur_string = "";
    	  return erreur_string;
	  }
    }
    
    /*
    // On verifie les erreurs et on associe un String
    public int setErreurInt(int erreur_int, String motJoueur) {
      this.motJoueur = motJoueur; 
      if (!motJoueur.matches("^[a-zA-Z]+$")) {
    	  this.erreur_int = 1;
    	  return erreur_int;
      }
      if (motJoueur.length() != longueur) {
    	  this.erreur_int = 2;
    	  return erreur_int;
	  }
	  if (motJoueur.charAt(0) != mot.charAt(0)) {
		  this.erreur_int = 3;
    	  return erreur_int;
	  }
	  else {
		  this.erreur_int = 0;
    	  return erreur_int;
	  }   
    }
    
    
    // On cherche les lettres bien positionnées   	
    public int[] setBonneLettres(int[] lettresBonPos) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < longueur; i++) {
            if (motJoueur.charAt(i) == mot.charAt(i)) {
                positions.add(i);
            }
        }
        return positions.stream().mapToInt(Integer::intValue).toArray(); // On transforme la liste en tableau
    }

    // On cherche les lettres bonnes mais mal positionnées
    public int[] setMauvaiseEndroitLettre(int[] lettresMalPos) {
        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = 0; i < longueur; i++) {
            char lettre1 = mot.charAt(i);
            char lettre2 = motJoueur.charAt(i);

            if (lettre1 != lettre2) {
                int occurrences = countOccurrences(lettre1);

                for (int j = 0; j < motJoueur.length(); j++) {
                    if (j != i && motJoueur.charAt(j) == lettre1 && occurrences > 0) {
                        if (lettre1 != mot.charAt(j)) {
                            positions.add(j);
                            occurrences--;
                        }
                    }
                }
            }
        }

        return positions.stream().mapToInt(Integer::intValue).toArray();
    }

    private int countOccurrences(char letter) {
        int count = 0;
        for (int i = 0; i < mot.length(); i++) {
            if (mot.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }



    public int[] getBonPos() {
        return this.lettresBonPos;
    }

    public void setBonPos(int[] lettresBonPos) {
        this.lettresBonPos = setBonneLettres(lettresBonPos);
    }

    public int[] getMalPos() {
        return this.lettresMalPos;
    }

    public void setMalPos(int[] lettresMalPos) {
        this.lettresMalPos = setMauvaiseEndroitLettre(lettresMalPos);
    }
    */
}
