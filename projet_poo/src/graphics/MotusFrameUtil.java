package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import java.awt.*;
import java.awt.event.ActionListener;

public class MotusFrameUtil {
	public static Color roseColor = Color.decode("#ff32af");
	
    public static void configureAndShowFrame(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void configureAndShowMessage(JFrame frame, int width, int height) {
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    

    public static JLabel createTitleLabel(String text) {
        JLabel titleLabel = new JLabel(text);
        titleLabel.setFont(new Font("Impact", Font.BOLD, 50));
        titleLabel.setForeground(roseColor);
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
    	Font font = new Font("Impact", Font.BOLD, 14);
    	button.setFont(font);
    	button.setBackground(roseColor);
        button.setOpaque(true);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(listener);
        
        return button;
    }

    public static JLabel createEmptyCellLabel() {
        JLabel cellLabel = new JLabel("");
        cellLabel.setBorder(BorderFactory.createLineBorder(roseColor,2));
        cellLabel.setOpaque(true);
        cellLabel.setBackground(Color.WHITE);
        return cellLabel;
    }

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        Font font = new Font("Impact", Font.BOLD, 30);
    	label.setFont(font);
        label.setForeground(roseColor);
        return label;
    }
    
    public static JFrame createErrorFrame() {
        JFrame errorFrame = new JFrame("Error");
        
        errorFrame.setLayout(new BorderLayout());
        
        return errorFrame;
    }
    
    
}

