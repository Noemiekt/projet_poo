package graphics;

import javax.swing.*;
import java.awt.*;

public class MotusFrame {
	public static int nbLettre;
    public static JFrame homeFrame;
    public static JFrame gameFrame;
    public static String userInput;
    public static JTextField userInputField;

    public static void main(String[] args) {
        homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(homeFrame, 800, 350);
    }

    public static void startGame(int selectedIndex) {
    	homeFrame.setVisible(false);
        gameFrame = MotusGameFrame.createGameFrame(selectedIndex);
        MotusFrameUtil.configureAndShowFrame(gameFrame, 800, 350);

    }
}
