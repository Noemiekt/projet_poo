package graphics;

import java.awt.Color;

import javax.swing.JTextField;

public class MotusVariable {
	public static int nbLettre;
	public static String userInput;
    public static JTextField userInputField;
    public static int nbEssai;
    public static String motAtrouver;
    public static Color rose = Color.decode("#ff32af");
    public static Color gold = Color.decode("#ffd700");
    public static char[][] TabInput=new char[7][MotusVariable.nbLettre]; //Tableau stockant les mot saisi
	public static int[][] TabVerification=new int[7][MotusVariable.nbLettre];
	public static String[][] TabScore=new String[1][2];
	public static int indLangue;
	public static int oneVone;
	
}
