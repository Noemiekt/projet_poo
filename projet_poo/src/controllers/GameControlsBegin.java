package controllers;

import java.util.Random;
import Test.*;

public class GameControlsBegin{
	static String fileName = "src/Test/dictionnaire.txt"; // Provide the path to your dictionary file
    static Dictionnary dictionary = new Dictionnary(fileName);
    static int wordLength = 4; 
//    public static String mot = dictionary.selectRandomWord(wordLength);
    public static String motdebase = "caioa";
    public static String mot = motdebase.toUpperCase();
	public static int longueur = mot.length();
	static int[] lettres = new int[longueur];
	static int lettre1 = lettres[0];
	static int lettre2;
	
	public GameControlsBegin() {
		this(lettre1, lettre2);
	}
	
	public GameControlsBegin(int lettre1, int lettre2) {
		setL1(lettre1);
		setL2(lettre2);
	}
	
	public int setCoord1(int lettre1) {
		 return 0;
	}
	
	public int setCoord2(int lettre2) {
		Random random = new Random();
        lettre2 = random.nextInt(longueur) + 1;
        return lettre2;
	}
	
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
}
