package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MotusFramebis {
	
	private static int nbLettre;
	public static JFrame homeFrame;
	public static JFrame gameFrame;
	
	//Home Frame 

    public static void main(String[] args) {
        homeFrame = createHomeFrame();
        configureAndShowFrame(homeFrame, 800, 350);
    }

    private static JFrame createHomeFrame() {
        JFrame frame = new JFrame("Accueil");
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = createMainPanel();
        frame.add(mainPanel, BorderLayout.CENTER);

        return frame;
    }

    private static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 223, 186));
        mainPanel.add(createTitleLabel());
        mainPanel.add(createComboBoxPanel());
        mainPanel.add(createStartButtonPanel());
        return mainPanel;
    }

    private static JLabel createTitleLabel() {
        JLabel titleLabel = new JLabel("Jeux du Motus");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 139, 139));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        return titleLabel;
    }

    private static JPanel createComboBoxPanel() {
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setBackground(new Color(255, 223, 186));
        comboBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        String[] letterCounts = {"Mot de 4 lettres", "Mot de 5 lettres", "Mot de 6 lettres", "Mot de 7 lettres", "Mot de 8 lettres", "Mot de 9 lettres"};
        JComboBox<String> letterComboBox = new JComboBox<>(letterCounts);
        configureComboBox(letterComboBox);

        comboBoxPanel.add(letterComboBox);
        return comboBoxPanel;
    }

    private static void configureComboBox(JComboBox<String> comboBox) {
        comboBox.setSelectedIndex(0);
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(0, 139, 139)));
        comboBox.setForeground(new Color(0, 139, 139));
    }

    private static JPanel createStartButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0, 139, 139));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton startButton = createStartButton();
        buttonPanel.add(startButton);
        return buttonPanel;
    }

    private static JButton createStartButton() {
        JButton startButton = new JButton("Commencer");
        startButton.setBorder(BorderFactory.createLineBorder(new Color(0, 139, 139)));
        startButton.setForeground(new Color(255, 223, 186));
        startButton.addActionListener(e -> handleStartButtonClick());
        return startButton;
    }

    private static void handleStartButtonClick() {
        homeFrame.setVisible(false);
        createGameFrame(nbLettre);   
    }
    
    
    //Game Frame
    private static void createGameFrame(int selectedIndex) {
        gameFrame = new JFrame("Jeu Motus");
        configureAndShowFrame(gameFrame, 800, 350);
        

        JPanel gameLeftPanel = createGameLeftPanel(selectedIndex);
        JPanel gameRightPanel = createGameRightPanel(gameFrame);

        JSplitPane gameSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gameLeftPanel, gameRightPanel);
        gameSplitPane.setResizeWeight(0.5);

        gameFrame.add(gameSplitPane, BorderLayout.CENTER);
        gameFrame.setSize(800, 350);
        gameFrame.setVisible(true);
    }

    private static JPanel createGameLeftPanel(int selectedIndex) {
        JPanel panel = new JPanel(new GridLayout(7, selectedIndex + 4));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 7 * (selectedIndex + 4); i++) {
            JLabel cellLabel = createEmptyCellLabel();
            panel.add(cellLabel);
        }

        return panel;
    }

    private static JLabel createEmptyCellLabel() {
        JLabel cellLabel = new JLabel("");
        cellLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0)));
        cellLabel.setOpaque(true);
        cellLabel.setBackground(new Color(245, 245, 220));
        return cellLabel;
    }

    private static JPanel createGameRightPanel(JFrame frame) {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(createLabel("Ta proposition :"));
        panel.add(new JTextField(20));
        panel.add(createButton("Recommencer", e -> restartButtonClicked()));
        panel.add(createButton("Quitter", e -> System.exit(0)));

        return panel;
    }

    private static JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(new Color(0, 139, 139));
        return label;
    }

    private static JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.setForeground(new Color(0, 139, 139));
        button.addActionListener(listener);
        return button;
    }

    private static void restartButtonClicked() {
    	gameFrame.setVisible(false);
    	homeFrame = createHomeFrame();
        configureAndShowFrame(homeFrame, 800, 350);
        
    }


    
    private static void configureAndShowFrame(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }

    
}

