package graphics;

import javax.swing.*;


public class MotusFrame {
	public static JFrame introFrame;
    public static JFrame homeFrame;
    public static JFrame gameFrame;
    public static JFrame scoreFrame;
    
    public static void main(String[] args) {
    	MotusVariable.TabScore[0][0]="Meilleur Score";
        introFrame = MotusIntroFrame.createIntroFrame();
        MotusFrameUtil.configureAndShowFrame(introFrame, 960, 540);
    }
    
    public static void home() {
        homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(homeFrame, 960, 540);

    }

    public static void startGame() {
    	homeFrame.setVisible(false);
        gameFrame = MotusGameFrame.createGameFrame();
        MotusFrameUtil.configureAndShowFrame(gameFrame, 960, 540);

    } 
}
