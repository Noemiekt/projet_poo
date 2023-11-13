package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MotusHomeFrame {
    private static JComboBox<String> letterComboBox;  // Déclarez comme un champ de classe

    public static JFrame createHomeFrame() {
        JFrame frame = new JFrame("Accueil");
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = createMainPanel();
        frame.add(mainPanel, BorderLayout.CENTER);

        return frame;
    }

    private static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 223, 186));
        mainPanel.add(MotusFrameUtil.createTitleLabel("Jeux du Motus"));
        mainPanel.add(createComboBoxPanel());
        mainPanel.add(createStartButtonPanel());
        return mainPanel;
    }

    private static JPanel createComboBoxPanel() {
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setBackground(new Color(255, 223, 186));
        comboBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        String[] letterCounts = {"Mot de 4 lettres", "Mot de 5 lettres", "Mot de 6 lettres", "Mot de 7 lettres", "Mot de 8 lettres", "Mot de 9 lettres"};
        letterComboBox = new JComboBox<>(letterCounts);  // Assignez à la variable de classe
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

        JButton startButton = MotusFrameUtil.createStartButton("Commencer", e -> handleStartButtonClick());
        buttonPanel.add(startButton);
        return buttonPanel;
    }

    private static void handleStartButtonClick() {
        int selectedIndex = letterComboBox.getSelectedIndex();  // Utilisez letterComboBox
        MotusFrame.nbLettre = selectedIndex;
        MotusFrame.startGame(selectedIndex);
    }
}
