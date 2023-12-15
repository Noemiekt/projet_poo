package controllers;


import java.util.Random;
import java.text.Normalizer;

public class GameControlsBegin{
	

	public static int lettre1 = 0;
	public static int lettre2;
	
	
	
	public static int setCoord1() {
		 return 0;
	}
	
	public static int setCoord2() {
		Random random = new Random();
        lettre2 = random.nextInt(MotusVariable.nbLettre-1)+1 ;
        return lettre2;
	}




	public static void initmotdebase() {
		Dictionnary.initDictionnary();
		
		MotusVariable.motAtrouver = Dictionnary.selectRandomWord(MotusVariable.nbLettre,MotusVariable.indLangue);
		MotusVariable.motAtrouver = Normalizer.normalize(MotusVariable.motAtrouver, Normalizer.Form.NFD);
		MotusVariable.motAtrouver = MotusVariable.motAtrouver.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		MotusVariable.motAtrouver = MotusVariable.motAtrouver.toUpperCase();	
		
	}
	
	
}
