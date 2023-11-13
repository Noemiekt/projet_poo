package graphics;

import javax.swing.*;

import controllers.GameControlsBegin;
import controllers.GamesControls;

import controllers.*;

import java.awt.*;

public class MotusFrame {
	public static int nbLettre;
    public static JFrame homeFrame;
    public static JFrame gameFrame;
    public static String userInput;
    public static JTextField userInputField;
    
    
    
    public static void startGame(int selectedIndex) {
    	homeFrame.setVisible(false);
        gameFrame = MotusGameFrame.createGameFrame(selectedIndex);
        MotusFrameUtil.configureAndShowFrame(gameFrame, 800, 350);

    }

    public static void main(String[] args) {
        homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(homeFrame, 800, 350);
        
        
        
        /*GamesControls game;
		game = new GamesControls(userInput);
		System.out.printf("Le mot est : %s%n", game.motJoueur);
		System.out.print("les indices de lettres bien positionnées sont : ");
		for (int i = 0; i < game.lettresBonPos.length; i++) {
		    System.out.print(game.lettresBonPos[i] + " ");
		}
		System.out.println();*/
        
        
    }

    
    
    
}
