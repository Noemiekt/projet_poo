package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import controllers.GameControlsBegin;

import java.awt.*;

public class MotusGameFrame {
	
	
	public static JPanel gameLeftPanel;
	public static JPanel gameRightPanel;
	
    public static JFrame createGameFrame() {
        JFrame gameFrame = new JFrame("Jeu Motus");
        
        
        GameControlsBegin.initmotdebase();
        System.out.print("le mot à trouver :" + MotusVariable.motAtrouver );
       
        System.out.println();
        
        Tab.initTabInput();
        Tab.initTabVerification();
        
        

        ImagePanel backgroundPanel = new ImagePanel("res/game.jpeg");
        gameFrame.setContentPane(backgroundPanel);
        
        
        gameFrame.setLayout(new BorderLayout());
       

        gameLeftPanel = MotusGameLeftPanel.UpdateLeftPanel();
        gameRightPanel = MotusGameRightPanel.createGameRightPanel(gameFrame);

            
        gameFrame.add(gameLeftPanel, BorderLayout.WEST);
        gameFrame.add(gameRightPanel, BorderLayout.EAST);

        return gameFrame;
    }
}

