package graphics;

import javax.swing.*;

import controllers.MotusVariable;

public class MotusFrame {
	public static JFrame introFrame;
    public static JFrame homeFrame;
    public static JFrame gameFrame;
    public static JFrame scoreFrame;
    
    public static void intro() {
    	MotusVariable.TabScore[0][0]="Meilleur Score";
    	MotusVariable.Tab1V1[0][0]="Joueur 1";
    	MotusVariable.Tab1V1[0][2]="Joueur 2";
        introFrame = MotusIntroFrame.createIntroFrame();
        MotusFrameUtil.configureAndShowFrame(introFrame, 960, 540);
    }
    
    public static void home() {	
    	Music.stopMusic("res/musiques/song.wav");
    	Music.playMusic("res/musiques/home.wav");
        homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(homeFrame, 960, 540);
    }

    public static void startGame() {	
    	Music.stopMusic("res/musiques/home.wav");
    	Music.playMusic("res/musiques/song.wav");
    	homeFrame.setVisible(false);
        gameFrame = MotusGameFrame.createGameFrame();
        MotusFrameUtil.configureAndShowFrame(gameFrame, 960, 540);

    } 
    

}
