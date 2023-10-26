package controllers;

import java.util.Random;

public class GameControls {
	String mot;
	public int longueur = mot.length();
	static int lettre1 = 0;
	static int lettre2;
	
	public GameControls() {
		this(lettre1, lettre2);
	}
	public GameControls(int lettre1, int lettre2) {
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
