package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import controllers.GameControlsBegin;
import controllers.MotusVariable;
import controllers.Tab;

import java.awt.*;

public class MotusGameFrame {
	
	
	public static JPanel gameLeftPanel;
	public static JPanel gameRightPanel;
	
    public static JFrame createGameFrame() {
        JFrame gameFrame = new JFrame("Jeu Motus");
        MotusVariable.nbEssai=0;
        
        if (MotusVariable.who1V1player==1) {
        	GameControlsBegin.initmotdebase();
            System.out.print("le mot à trouver :" + MotusVariable.motAtrouver );
            System.out.println();
            Tab.initTabVerification();
        }
        
        else {
        	Tab.initTabVerification2ndplayer();
        }
        
        Tab.initTabInput();
        
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

