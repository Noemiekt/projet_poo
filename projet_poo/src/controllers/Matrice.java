package controllers;

public class Matrice extends GamesControls {
    static int[] lineVerification;

    public Matrice() {
        this(new int[longueur]);
    }

    public Matrice(int[] tableau) {
        settab(tableau);
    }

    public int[] settab(int[] lineVerification) {
        this.lineVerification = new int[longueur];  // Réinitialise lineVerification ici

        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < lettresBonPos.length; j++) {
                if (i == lettresBonPos[j]) {
                    this.lineVerification[i] = 2;
                }
            }

            for (int k = 0; k < lettresMalPos.length; k++) {
                if (i == lettresMalPos[k]) {
                    this.lineVerification[i] = 1;
                }
            }
        }

        return this.lineVerification;
    }
}
