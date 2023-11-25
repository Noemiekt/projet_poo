package graphics;

import javax.swing.*;

import controllers.GameControlsBegin;
import controllers.GamesControls;

import controllers.*;

import java.awt.*;

public class MotusFrame {
	public static int nbLettre;
	public static JFrame introFrame;
    public static JFrame homeFrame;
    public static JFrame gameFrame;
    public static String userInput;
    public static JTextField userInputField;
    
    public static void main(String[] args) {
        introFrame = MotusIntroFrame.createIntroFrame();
        MotusFrameUtil.configureAndShowFrame(introFrame, 960, 540);
    }
    
    public static void home() {
    	introFrame.setVisible(false);
        homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(homeFrame, 960, 540);

    }

    public static void startGame(int selectedIndex) {
    	homeFrame.setVisible(false);
        gameFrame = MotusGameFrame.createGameFrame(selectedIndex);
        MotusFrameUtil.configureAndShowFrame(gameFrame, 960, 540);

    }
 

    
    
    
}
