package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MotusFrame {
    public static void main(String[] args) {
        JFrame homeFrame = createHomeFrame();
        homeFrame.setSize(800, 350); // Définir la taille de la fenêtre d'accueil
        homeFrame.setVisible(true); // Rendre la fenêtre d'accueil visible
    }

    private static JFrame createHomeFrame() {
        JFrame frame = new JFrame("Acceuil");
        frame.setLayout(new BorderLayout());

        // Créer un panneau principal avec un fond rose pâle
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 223, 186)); // Rose pâle

        // Ajouter un titre en haut
        JLabel titleLabel = new JLabel("Jeux du Motus");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Style du texte
        titleLabel.setForeground(new Color(0, 139, 139)); // Bleu turquoise
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Centrer le texte
        mainPanel.add(titleLabel);

        // Créer un panneau pour la liste déroulante
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setBackground(new Color(255, 223, 186)); // Rose pâle
        comboBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrer les composants

        String[] letterCounts = {"Mot de 4 lettres", "Mot de 5 lettres", "Mot de 6 lettres", "Mot de 7 lettres", "Mot de 8 lettres", "Mot de 9 lettres"};
        JComboBox<String> letterComboBox = new JComboBox<>(letterCounts);
        letterComboBox.setSelectedIndex(0);
        letterComboBox.setBorder(BorderFactory.createLineBorder(new Color(0, 139, 139))); // Contours en bleu turquoise
        letterComboBox.setForeground(new Color(0, 139, 139)); // Texte en bleu turquoise
        comboBoxPanel.add(letterComboBox);

        // Créer un panneau pour le bouton "Commencer"
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0, 139, 139)); // Rose pâle
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrer le bouton

        JButton startButton = new JButton("Commencer");
        startButton.setBorder(BorderFactory.createLineBorder(new Color(0, 139, 139))); // Contours en bleu turquoise
        startButton.setForeground(new Color(255, 223, 186)); // Texte en bleu turquoise
        buttonPanel.add(startButton);

        // Ajouter un écouteur d'événements au bouton de démarrage
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = letterComboBox.getSelectedIndex();
                frame.setVisible(false); // Masquer la fenêtre d'accueil
                createGameFrame(selectedIndex); // Créer et afficher la nouvelle fenêtre avec le tableau
            }
        });

        // Ajouter les panneaux au panneau principal
        mainPanel.add(comboBoxPanel);
        mainPanel.add(buttonPanel);

        frame.add(mainPanel, BorderLayout.CENTER);
        return frame;
    }



    private static void createGameFrame(int selectedIndex) {
        JFrame frame = new JFrame("Jeu Motus");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Couleur de fond générale de la page en marron foncé
        frame.getContentPane().setBackground(new Color(139, 69, 19)); // Marron foncé

        JPanel gameLeftPanel = new JPanel(new GridLayout(7, selectedIndex + 4));
        // Ajouter une marge aux cellules du tableau
        gameLeftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Marge de 10 pixels

        for (int i = 0; i < 7 * (selectedIndex + 4); i++) {
            JLabel cellLabel = new JLabel("");
            // Contours des cellules en vert sapin
            cellLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0))); // Vert sapin
            cellLabel.setOpaque(true);
            // Fond des cellules en beige
            cellLabel.setBackground(new Color(245, 245, 220)); // Beige
            gameLeftPanel.add(cellLabel);
        }

        JPanel gameRightPanel = new JPanel(new GridLayout(4, 1));
        gameRightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Marge de 10 pixels

        // Section "Ta proposition"
        JLabel propositionLabel = new JLabel("Ta proposition :");
        propositionLabel.setForeground(new Color(0, 139, 139)); // Texte en bleu turquoise
        gameRightPanel.add(propositionLabel);

        // Section de saisie
        JTextField inputField = new JTextField(20);
        gameRightPanel.add(inputField);

        // Bouton "Recommencer"
        JButton restartButton = new JButton("Recommencer");
        restartButton.setForeground(new Color(0, 139, 139)); // Texte en bleu turquoise
        gameRightPanel.add(restartButton);

        // Bouton "Quitter"
        JButton quitButton = new JButton("Quitter");
        quitButton.setForeground(new Color(0, 139, 139)); // Texte en bleu turquoise
        gameRightPanel.add(quitButton);

        JSplitPane gameSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gameLeftPanel, gameRightPanel);
        gameSplitPane.setResizeWeight(0.5);

        frame.add(gameSplitPane, BorderLayout.CENTER);
        frame.setSize(800, 350);
        frame.setVisible(true);
    }




}
