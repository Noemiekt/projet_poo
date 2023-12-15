package controllers;




public class GamesControls extends GameControlsBegin {
    
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

        for (int i = 0; i < MotusVariable.motAtrouver.length(); i++) {
            if (MotusVariable.userInput.charAt(i) == MotusVariable.motAtrouver.charAt(i)) {
                position[i] = 2;
            }
        }
        
        for (int i = 0; i < MotusVariable.nbLettre; i++) {
            char lettre1 = MotusVariable.motAtrouver.charAt(i);
            char lettre2 = MotusVariable.userInput.charAt(i);

            if (lettre1 != lettre2) {
                int occurrences = compterOccurencesLettre(MotusVariable.motAtrouver,lettre1);

                for (int j = 0; j < MotusVariable.nbLettre; j++) {
                    if (j != i && MotusVariable.userInput.charAt(j) == lettre1 && occurrences > 0) {
                        if (lettre1 != MotusVariable.motAtrouver.charAt(j)) {
                            position[j]=1;
                            occurrences--;
                        }
                    }
                }
            }
        }

        
        for (int i = 0; i < MotusVariable.motAtrouver.length(); i++) {
            if (position[i] != 0 && position[i] != 1) {
                position[i] = 2;
            }
        }

        return position;
    }
    
    
}
