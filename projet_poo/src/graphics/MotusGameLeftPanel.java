package graphics;

import javax.swing.*;


import java.awt.*;

public class MotusGameLeftPanel {
    public static JPanel createGameLeftPanel(int selectedIndex) {
        JPanel panel = new JPanel(new GridLayout(7, selectedIndex + 4));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        for (int i = 0; i < 7 * (selectedIndex + 4); i++) {
            JLabel cellLabel = MotusFrameUtil.createEmptyCellLabel();
            panel.add(cellLabel);
        }
        
        panel.setOpaque(false);
        
        panel.setPreferredSize(new Dimension(460, 520));

        return panel;
    }
}
