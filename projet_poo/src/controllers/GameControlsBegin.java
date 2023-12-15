package controllers;


import java.util.Random;
import java.text.Normalizer;
import graphics.MotusVariable;

public class GameControlsBegin{
	

	public static int lettre1 = 0;
	public static int lettre2;
	
	public static void initmotdebase() {
		
		switch (MotusVariable.indLangue) {
        case 0:
        	MotusVariable.motAtrouver = MotusVariable.frenchdictionary.selectRandomWord(MotusVariable.nbLettre);
            break;
        case 1:
        	MotusVariable.motAtrouver = MotusVariable.englishdictionary.selectRandomWord(MotusVariable.nbLettre);
            break;
        case 2:
        	MotusVariable.motAtrouver = MotusVariable.spanishdictionary.selectRandomWord(MotusVariable.nbLettre);
            break;
        default:
        	MotusVariable.motAtrouver = MotusVariable.frenchdictionary.selectRandomWord(MotusVariable.nbLettre);
            break;
		}
		
		MotusVariable.motAtrouver = Normalizer.normalize(MotusVariable.motAtrouver, Normalizer.Form.NFD);
		MotusVariable.motAtrouver = MotusVariable.motAtrouver.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		MotusVariable.motAtrouver = MotusVariable.motAtrouver.toUpperCase();		
	}
	
	

	
	public static int setCoord1() {
		 return 0;
	}
	
	public static int setCoord2() {
		Random random = new Random();
        lettre2 = random.nextInt(MotusVariable.nbLettre-1)+1 ;
        return lettre2;
	}
	
	
}
