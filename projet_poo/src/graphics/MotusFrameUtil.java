package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MotusFrameUtil {
    public static void configureAndShowFrame(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    public static JLabel createTitleLabel(String text) {
        JLabel titleLabel = new JLabel(text);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 139, 139));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        return titleLabel;
    }

    public static JButton createStartButton(String text, ActionListener listener) {
        JButton startButton = new JButton(text);
        startButton.setBorder(BorderFactory.createLineBorder(new Color(0, 139, 139)));
        startButton.setForeground(new Color(255, 223, 186));
        startButton.addActionListener(listener);
        return startButton;
    }

    public static JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.setForeground(new Color(0, 139, 139));
        button.addActionListener(listener);
        return button;
    }

    public static JLabel createEmptyCellLabel() {
        JLabel cellLabel = new JLabel("");
        cellLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0)));
        cellLabel.setOpaque(true);
        cellLabel.setBackground(new Color(245, 245, 220));
        return cellLabel;
    }

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(0, 139, 139));
        return label;
    }
    
    
}

