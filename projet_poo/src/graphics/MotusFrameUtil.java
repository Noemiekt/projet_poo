package graphics;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionListener;

public class MotusFrameUtil {
	
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
        titleLabel.setForeground(MotusVariable.rose);
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
    	button.setBackground(MotusVariable.rose);
        button.setOpaque(true);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(listener);
        
        return button;
    }
    
    public static JButton createButton2(String text, ActionListener listener) {
    	JButton button = new JButton(text);
    	Font font = new Font("Impact", Font.BOLD, 30);
    	button.setFont(font);
    	button.setBackground(MotusVariable.rose);
        button.setOpaque(true);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.addActionListener(listener);
        
        return button;
    }

    public static JLabel createEmptyCellLabel() {
        JLabel cellLabel = new JLabel("");
        cellLabel.setBorder(BorderFactory.createLineBorder(MotusVariable.rose,2));
        cellLabel.setOpaque(true);
        return cellLabel;
    }

    public static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        Font font = new Font("Impact", Font.BOLD, 30);
    	label.setFont(font);
        label.setForeground(MotusVariable.rose);
        return label;
    }
    
    public static JFrame createErrorFrame() {
        JFrame errorFrame = new JFrame("Error");       
        errorFrame.setLayout(new BorderLayout());
        return errorFrame;
    }
    
    public static JFrame createEndFrame() {
        JFrame endFrame = new JFrame("End");    
        endFrame.setLayout(new BorderLayout());    
        return endFrame;
    }
    
    public static JFrame createNextFrame() {
        JFrame nextFrame = new JFrame("End");
        nextFrame.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        
        gbc.gridy++;
        JButton buttonRecommencer = MotusFrameUtil.createButton("Recommencer", e -> MotusGameFrameUtil.restartButtonClicked());
        panel.add(buttonRecommencer, gbc);

        gbc.gridy++;
        JButton buttonQuitter = MotusFrameUtil.createButton("Quitter", e -> System.exit(0));
        panel.add(buttonQuitter, gbc);
        
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(460, 520));
        
        nextFrame.add(panel, BorderLayout.CENTER);
        
        return nextFrame;
    }
    
    
}

