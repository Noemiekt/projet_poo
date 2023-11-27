package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import java.awt.*;

public class MotusGameFrame {
    public static JFrame createGameFrame(int selectedIndex) {
        JFrame gameFrame = new JFrame("Jeu Motus");
        
     

        ImagePanel backgroundPanel = new ImagePanel("res/game.jpeg");
        gameFrame.setContentPane(backgroundPanel);
        
     // Utiliser BorderLayout pour que les panneaux s'étendent
        gameFrame.setLayout(new BorderLayout());

        JPanel gameLeftPanel = MotusGameLeftPanel.createGameLeftPanel(selectedIndex);
        JPanel gameRightPanel = MotusGameRightPanel.createGameRightPanel(gameFrame);

        

        // Ajouter les panneaux avec des contraintes pour qu'ils s'étendent
        gameFrame.add(gameLeftPanel, BorderLayout.WEST);
        gameFrame.add(gameRightPanel, BorderLayout.EAST);

        return gameFrame;
    }
}

