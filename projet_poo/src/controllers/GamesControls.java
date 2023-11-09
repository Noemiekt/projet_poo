package controllers;

import java.util.ArrayList;

public class GamesControls extends GameControlsBegin {
    public static String motJoueur = "CAAA";
    static int[] lettresBonPos;
    static int[] lettresMalPos;

    public GamesControls() {
        this(new int[longueur], new int[longueur], motJoueur);
    }

    public GamesControls(int[] lettresBonPos, int[] lettresMalPos, String motJoueur) {
        setBonPos(lettresBonPos);
        setMalPos(lettresMalPos);
        setMotJoueur(motJoueur);
    }
    
    public String setMotJoueur(String motJoueur) {
        if (motJoueur.length() != longueur) {
            throw new IllegalArgumentException("Vous devez avoir un mot de la bonne longueur.");
        }
        if (motJoueur.charAt(0) != mot.charAt(0)) {
            throw new IllegalArgumentException("Vous devez reprendre la première lettre du mot.");
        }
        if (!motJoueur.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("Vous ne devez utiliser que des lettres.");
        }
        this.motJoueur = motJoueur; 
        return motJoueur;
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
                for (int j = 0; j < motJoueur.length(); j++) {
                    if (j != i && motJoueur.charAt(j) == lettre1) {
                        positions.add(j);  // Ajoute l'indice dans motJoueur plutôt que dans mot
                    }
                }
            }
        }
        return positions.stream().mapToInt(Integer::intValue).toArray();
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
}
