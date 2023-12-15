package controllers;


import java.util.Random;
import java.text.Normalizer;
import graphics.MotusVariable;

public class GameControlsBegin{
	static String fileName = "src/Test/dictionnaire.txt"; 
    static Dictionnary dictionary = new Dictionnary(fileName);
	public static int lettre1 = 0;
	public static int lettre2;
	
	public static void initmotdebase() {
		MotusVariable.motAtrouver = dictionary.selectRandomWord(MotusVariable.nbLettre);
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
