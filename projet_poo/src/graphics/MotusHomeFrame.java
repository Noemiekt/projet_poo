package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import java.awt.*;


public class MotusHomeFrame {
    private static JComboBox<String> letterComboBox;

    public static JFrame createHomeFrame() {
        JFrame frame = new JFrame("Accueil");
        frame.setLayout(new BorderLayout());

        ImagePanel backgroundPanel = new ImagePanel("res/home.jpeg");
        frame.setContentPane(backgroundPanel);

        JPanel mainPanel = createMainPanel();
        
        // Utiliser GridBagLayout pour centrer mainPanel
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(mainPanel, gbc);

        return frame;
    }

    private static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        
        mainPanel.setOpaque(false);

        mainPanel.add(createComboBoxPanel(), gbc);

        gbc.gridy++;
        mainPanel.add(createStartButtonPanel(), gbc);

        return mainPanel;
    }

    private static JPanel createComboBoxPanel() {
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        String[] letterCounts = {"Mot de 4 lettres", "Mot de 5 lettres", "Mot de 6 lettres", "Mot de 7 lettres", "Mot de 8 lettres", "Mot de 9 lettres"};
        letterComboBox = new JComboBox<>(letterCounts);
        configureComboBox(letterComboBox);
        
        Dimension preferredSize = new Dimension(300, 200);  
        letterComboBox.setPreferredSize(preferredSize);
        
        // Modifier la police et la couleur du texte dans la JComboBox
        Font font = new Font("Impact", Font.BOLD, 20); // ajustez selon vos besoins
        letterComboBox.setFont(font);
        
        Color myColor = Color.decode("#ff32af");

        // Couleur du texte
        letterComboBox.setForeground(myColor); // ajustez selon vos besoins
        
        comboBoxPanel.setOpaque(false);

        comboBoxPanel.add(letterComboBox);
        
        
        
        return comboBoxPanel;
    }

    private static void configureComboBox(JComboBox<String> comboBox) {
        comboBox.setSelectedIndex(0);
    }

    private static JPanel createStartButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        


        JButton startButton = MotusFrameUtil.createStartButton("Commencer", e -> handleStartButtonClick());
        startButton.setOpaque(true);
        
        // Modifier la police et la couleur du texte dans la JComboBox
        Font font = new Font("Impact", Font.BOLD, 30); // ajustez selon vos besoins
        startButton.setFont(font);
        
        // Définir la couleur de la police en blanc
        startButton.setForeground(Color.WHITE);
        
        // Définir la couleur de fond en rose
        Color roseColor = Color.decode("#ff32af");
        startButton.setBackground(roseColor);

        buttonPanel.setOpaque(false);
        
        
        buttonPanel.add(startButton);
        
        return buttonPanel;
    }

    private static void handleStartButtonClick() {
        int selectedIndex = letterComboBox.getSelectedIndex();
        System.out.println("Saisie de l'utilisateur : " + selectedIndex);
        MotusFrame.nbLettre = selectedIndex;
        MotusFrame.startGame(selectedIndex);
    }
}
