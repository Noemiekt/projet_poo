package controllers;

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
    public static char[][] TabInput=new char[7][MotusVariable.nbLettre]; 
	public static int[][] TabVerification=new int[7][MotusVariable.nbLettre];
	public static int[][] TabVerificationInit=new int[7][MotusVariable.nbLettre];
	public static String[][] TabScore=new String[1][2];
	public static String[][] Tab1V1=new String[1][4];
	public static int indLangue;
	public static int is1V1=0;	
	public static int who1V1player=1;
}
