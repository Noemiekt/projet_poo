package graphics;

import javax.swing.*;



public class MotusFrame {
	public static JFrame introFrame;
    public static JFrame homeFrame;
    public static JFrame gameFrame;
    
    public static void main(String[] args) {
        introFrame = MotusIntroFrame.createIntroFrame();
        MotusFrameUtil.configureAndShowFrame(introFrame, 960, 540);
    }
    
    public static void home() {
    	introFrame.setVisible(false);
        homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(homeFrame, 960, 540);

    }

    public static void startGame() {
    	homeFrame.setVisible(false);
        gameFrame = MotusGameFrame.createGameFrame();
        MotusFrameUtil.configureAndShowFrame(gameFrame, 960, 540);

    } 
}
