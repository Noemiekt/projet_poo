package controllers;
import graphics.*;

public class Matrice extends GamesControls {
    public static int[] lineVerification;
	public static int[] lineRightPlaced;

	private MotusGameFrameUtil motusgameframeutil;

    public Matrice() {
        this(new int[longueur]);
    }

    public Matrice(int[] tableau) {
        settab(tableau);
        settab_right_placed(tableau);
    }

    public int[] settab(int[] lineVerification) {
        this.lineVerification = new int[longueur];  // Réinitialise lineVerification ici
        for (int i = 0; i < longueur; i++) {
            for (int j = 0; j < motusgameframeutil.game.lettresBonPos.length; j++) {
                if (i == motusgameframeutil.game.lettresBonPos[j]) {
                    this.lineVerification[i] = 2;
                }
            }
            for (int k = 0; k < motusgameframeutil.game.lettresMalPos.length; k++) {
                if (i == motusgameframeutil.game.lettresMalPos[k]) {
                    this.lineVerification[i] = 1;
                }
            }
        }
        return this.lineVerification;
    }
    
   
    public int[] settab_right_placed(int[] lineRightPlaced){
    	this.lineRightPlaced = new int[longueur];
    	for (int i = 0; i < longueur; i++) {
            if ((lineVerification[i]==2)) {
                this.lineRightPlaced[i] = 1;
            }
            else if (lineVerification[i]==1) {
            	this.lineRightPlaced[i] = 0;
            }
        }
    	return this.lineRightPlaced; 
    }
}