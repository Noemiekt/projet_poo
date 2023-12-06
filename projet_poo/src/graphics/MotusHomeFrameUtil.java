package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class MotusHomeFrameUtil {
	private static JComboBox<String> letterComboBox;
	
	public static JPanel createMainPanel() {
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
        letterComboBox.setSelectedIndex(0);
        
        Dimension preferredSize = new Dimension(300, 200);  
        letterComboBox.setPreferredSize(preferredSize);
        
        Font font = new Font("Impact", Font.BOLD, 20); 
        letterComboBox.setFont(font);
        
        letterComboBox.setForeground(MotusVariable.rose); 
        
        comboBoxPanel.setOpaque(false);

        comboBoxPanel.add(letterComboBox);
               
        return comboBoxPanel;
    }

    

    private static JPanel createStartButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        

        JButton startButton = MotusFrameUtil.createStartButton("Commencer", e -> handleStartButtonClick());
        startButton.setOpaque(true);
        
        Font font = new Font("Impact", Font.BOLD, 30); 
        startButton.setFont(font);
        
        startButton.setForeground(Color.WHITE);
        
        startButton.setBackground(MotusVariable.rose);

        buttonPanel.setOpaque(false);
        
        buttonPanel.add(startButton);
        
        return buttonPanel;
    }

    private static void handleStartButtonClick() {
        int selectedIndex = letterComboBox.getSelectedIndex();
        System.out.println("Saisie de l'utilisateur : " + selectedIndex);
        MotusVariable.nbLettre = selectedIndex+4;
        MotusFrame.startGame();
    }

}
