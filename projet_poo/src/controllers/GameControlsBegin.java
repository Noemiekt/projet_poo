package controllers;


import java.util.Random;
import java.text.Normalizer;
import graphics.MotusVariable;

public class GameControlsBegin{
	static String fileName = "src/Test/dictionnaire.txt"; // Provide the path to your dictionary file
    static Dictionnary dictionary = new Dictionnary(fileName);
     
    
    //public static String mot = dictionary.selectRandomWord(wordLength);

    
  
	//static int[] lettres = new int[longueur];
	public static int lettre1 = 0;
	public static int lettre2;
	
	
	
	public static void initmotdebase() {
		MotusVariable.motAtrouver=dictionary.selectRandomWord(MotusVariable.nbLettre);
		MotusVariable.motAtrouver = Normalizer.normalize(MotusVariable.motAtrouver, Normalizer.Form.NFD);
		MotusVariable.motAtrouver = MotusVariable.motAtrouver.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

		MotusVariable.motAtrouver=MotusVariable.motAtrouver.toUpperCase();
		System.out.println("je suis dans game control");
		System.out.println(MotusVariable.motAtrouver);
//		if (MotusVariable.nbLettre==4) {
//			MotusVariable.motAtrouver="papa";
//			MotusVariable.motAtrouver=MotusVariable.motAtrouver.toUpperCase();
//	    }
//		if (MotusVariable.nbLettre==5) {
//			MotusVariable.motAtrouver="hello";
//			MotusVariable.motAtrouver=MotusVariable.motAtrouver.toUpperCase();
//	    }
//		if (MotusVariable.nbLettre==6) {
//			MotusVariable.motAtrouver="coucou";
//			MotusVariable.motAtrouver=MotusVariable.motAtrouver.toUpperCase();
//	    }
//		if (MotusVariable.nbLettre==7) {
//			MotusVariable.motAtrouver="partage";
//			MotusVariable.motAtrouver=MotusVariable.motAtrouver.toUpperCase();
//	    }
//		if (MotusVariable.nbLettre==8) {
//			MotusVariable.motAtrouver="alexandr";
//			MotusVariable.motAtrouver=MotusVariable.motAtrouver.toUpperCase();
//	    }
//		if (MotusVariable.nbLettre==9) {
//			MotusVariable.motAtrouver="alexandra";
//			MotusVariable.motAtrouver=MotusVariable.motAtrouver.toUpperCase();
//	    }
		
	}
	
	///// --- Armelouche -----//////
//	protected char lettreAuHasard = mot.charAt(setCoord2(lettre2));
//	
//	public static char premiereLettre = mot.charAt(setCoord1(lettre1));
	
	/*public GameControlsBegin() {
		this(lettre1, lettre2);
	}
	*/
	
	/*public GameControlsBegin(int lettre1, int lettre2) {
		setL1(lettre1);
		setL2(lettre2);
	}
	*/
	
	public static int setCoord1() {
		 return 0;
	}
	
	public static int setCoord2() {
		Random random = new Random();
        lettre2 = random.nextInt(MotusVariable.nbLettre-1)+1 ;
        return lettre2;
	}
	
	/*
	public int getL1() {
		return this.lettre1;
	}
	public void setL1(int lettre1) {
		this.lettre1 = setCoord1(lettre1);
	}
	public int getL2() {
		return this.lettre2;
	}
	public void setL2(int lettre2) {
		this.lettre2 = setCoord2(lettre2);
	}
	*/
}
