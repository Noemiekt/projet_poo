package graphics;

import javax.swing.*;
import java.awt.*;

public class MotusGameFrame {
    public static JFrame createGameFrame(int selectedIndex) {
        JFrame gameFrame = new JFrame("Jeu Motus");

        JPanel gameLeftPanel = MotusGameLeftPanel.createGameLeftPanel(selectedIndex);
        JPanel gameRightPanel = MotusGameRightPanel.createGameRightPanel(gameFrame);

        JSplitPane gameSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gameLeftPanel, gameRightPanel);
        gameSplitPane.setResizeWeight(0.5);

        gameFrame.add(gameSplitPane, BorderLayout.CENTER);
        return gameFrame;
    }

}

