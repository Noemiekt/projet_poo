package graphics;

import javax.swing.*;

import controllers.MotusVariable;

import java.awt.*;

public class MotusGameLeftPanel {
	
	
	
    public static JPanel createGameLeftPanel() {
        JPanel panel = new JPanel(new GridLayout(7, MotusVariable.nbLettre));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        for (int i = 0; i < 7 * (MotusVariable.nbLettre); i++) {
        	JLabel tableau = MotusFrameUtil.createEmptyCellLabel();
            panel.add(tableau);
        }
        
        panel.setOpaque(false);     
        panel.setPreferredSize(new Dimension(460, 520));

        return panel;
    }
    
    public static JPanel UpdateLeftPanel() {
        JPanel panel = createPanel();
        Font customFont = createCustomFont();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < MotusVariable.nbLettre; j++) {
                JLabel cellLabel = createCellLabel(customFont, i, j);
                panel.add(cellLabel);
            }
        }

        setPanelProperties(panel);
        return panel;
    }

    private static JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(7, MotusVariable.nbLettre));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setOpaque(false);
        return panel;
    }

    private static Font createCustomFont() {
        return new Font("Impact", Font.BOLD, 30);
    }

    private static JLabel createCellLabel(Font customFont, int i, int j) {
        JLabel cellLabel = MotusFrameUtil.createEmptyCellLabel();

        if (MotusVariable.TabVerification[i][j] == 0) {
            configureEmptyCellLabel(cellLabel, customFont, Color.WHITE, Color.BLACK, i, j);
        } else if (MotusVariable.TabVerification[i][j] == 1) {
            configureEmptyCellLabel(cellLabel, customFont, MotusVariable.gold, Color.WHITE, i, j);
        } else if (MotusVariable.TabVerification[i][j] == 2) {
            configureEmptyCellLabel(cellLabel, customFont, MotusVariable.rose, Color.WHITE, i, j);
        } else {
            cellLabel.setBackground(Color.WHITE);
        }

        return cellLabel;
    }

    private static void configureEmptyCellLabel(JLabel cellLabel, Font customFont, Color background, Color foreground, int i, int j) {
        cellLabel.setBackground(background);
        cellLabel.setFont(customFont);
        cellLabel.setForeground(foreground);
        cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cellLabel.setText(String.valueOf(MotusVariable.TabInput[i][j]));
    }

    private static void setPanelProperties(JPanel panel) {
        panel.setPreferredSize(new Dimension(460, 520));
    }
    
}
