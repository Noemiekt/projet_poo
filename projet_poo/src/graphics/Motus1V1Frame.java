package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import controllers.GameControlsBegin;

import java.awt.*;

public class Motus1V1Frame {
	
	
	public static JPanel gameLeftPanel;
	public static JPanel gameRightPanel;
	
    public static JFrame createGameFrame() {
        
        MotusVariable.nbEssai=0;
        
        GameControlsBegin.initmotdebase();
        System.out.print("le mot à trouver :" + MotusVariable.motAtrouver );
        System.out.println();
        
        Tab.initTabInput();
        Tab.initTabVerification();
        
        //Premier joueur 
        JFrame gameFrame = new JFrame("Jeu Motus");
        
        ImagePanel backgroundPanel = new ImagePanel("res/images/game.jpeg");
        gameFrame.setContentPane(backgroundPanel);      
        gameFrame.setLayout(new BorderLayout());
       
        gameLeftPanel = MotusGameLeftPanel.UpdateLeftPanel();
        gameRightPanel = MotusGameRightPanel.createGameRightPanel(gameFrame);
        
        gameRightPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        gameFrame.add(gameLeftPanel, BorderLayout.WEST);
        gameFrame.add(gameRightPanel, BorderLayout.EAST);
        
        return gameFrame;

    }
    
}