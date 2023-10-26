package controllers;

public class GameControls {
	String mot;
	static int lettre1;
	static int lettre2;
	
	public GameControls() {
		this(lettre1, lettre2);
	}
	public GameControls(int lettre1, int lettre2) {
		setL1(lettre1);
		setL2(lettre2);
	}
	
	public int setCoord(int lettre1) {
		 if (lettre1 < 0)
				return 0;
			return lettre1;
		}
	
	public int getL1() {
		return this.lettre1;
	}
	public void setL1(int lettre1) {
		this.lettre1 = setCoord(lettre1);
	}
	public int getL2() {
		return this.lettre2;
	}
	public void setL2(int lettre2) {
		this.lettre2 = setCoord(lettre2);
	}
}
