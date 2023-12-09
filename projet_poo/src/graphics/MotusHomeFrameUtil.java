package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import graphics.MotusIntroFrame.ImagePanel;

public class MotusHomeFrameUtil {
	private static JComboBox<String> letterComboBox;
	private static JComboBox<String> letterComboBox2;
	
	public static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(0, 0, 10, 0);
        
        mainPanel.setOpaque(false);

        mainPanel.add(createComboBoxPanel(), gbc);
        
        
        gbc.gridy++;
        mainPanel.add(createComboBoxPanel2(), gbc);

        gbc.gridy++;
        JButton buttoncommencer = MotusFrameUtil.createButton2("Commencer", e -> handleStartButtonClick());
        mainPanel.add(buttoncommencer, gbc);
        
        gbc.gridy++;
        JButton button1V1 = MotusFrameUtil.createButton2("1V1", e -> handle1V1ButtonClick());
        mainPanel.add(button1V1, gbc);
        
        gbc.gridy++;
        JButton buttonScore = MotusFrameUtil.createButton2("Scores", e -> scoreButtonClick());
        mainPanel.add(buttonScore, gbc);
        
        gbc.gridy++;
        JButton buttonQuitter = MotusFrameUtil.createButton("Quitter", e -> System.exit(0));
        mainPanel.add(buttonQuitter, gbc);


        return mainPanel;
    }
	
	 
	public static void scoreButtonClick() {
		
		MotusFrame.scoreFrame = new JFrame("Score");
		ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/score.jpeg");
		MotusFrame.scoreFrame.setContentPane(backgroundPanel);
		
		JPanel panel = new JPanel(new GridLayout(7, MotusVariable.nbLettre));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
		Font customFont = new Font("Impact", Font.BOLD, 30);  // Remplacez "Arial" par la police que vous souhaitez
	
        for (int i = 0; i < 2 ; i++) {

        		JLabel cellLabel = MotusFrameUtil.createEmptyCellLabel();
	        	if (MotusVariable.TabScore[0][i]!=null) {
	        		cellLabel.setOpaque(false);
	        		cellLabel.setFont(customFont);
	        		cellLabel.setForeground(MotusVariable.rose);
	        		cellLabel.setHorizontalAlignment(SwingConstants.CENTER); 
	        		cellLabel.setText(String.valueOf(MotusVariable.TabScore[0][i]));
	        		
	        	}
	        	cellLabel.setOpaque(false);
	        	panel.add(cellLabel);

        }
        
        panel.setOpaque(false);
        
        MotusFrame.scoreFrame.add(panel);
        
        
        MotusFrame.scoreFrame.addWindowListener(new WindowAdapter() {
	        @Override
	         public void windowClosing(WindowEvent e) {
	        	MotusFrame.scoreFrame.setVisible(false);
	          }
		  });
        
        MotusFrameUtil.configureAndShowMessage(MotusFrame.scoreFrame, 600, 300);
        
        
        
	}

    private static JPanel createComboBoxPanel() {
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        String[] letterCounts = {"Mot de 4 lettres", "Mot de 5 lettres", "Mot de 6 lettres", "Mot de 7 lettres", "Mot de 8 lettres", "Mot de 9 lettres"};
        letterComboBox = new JComboBox<>(letterCounts);
        letterComboBox.setSelectedIndex(0);
        
        
        Font font = new Font("Impact", Font.BOLD, 20); 
        letterComboBox.setFont(font);
        
        letterComboBox.setForeground(MotusVariable.rose); 
        
        comboBoxPanel.setOpaque(false);

        comboBoxPanel.add(letterComboBox);
               
        return comboBoxPanel;
    }
    
    private static JPanel createComboBoxPanel2() {
        JPanel comboBoxPanel2 = new JPanel();
        comboBoxPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        String[] letterCounts = {"Français", "Anglais", "Allemand"};
        letterComboBox2 = new JComboBox<>(letterCounts);
        letterComboBox2.setSelectedIndex(0);
        
        
        Font font = new Font("Impact", Font.BOLD, 20); 
        letterComboBox2.setFont(font);
        
        letterComboBox2.setForeground(MotusVariable.rose); 
        
        comboBoxPanel2.setOpaque(false);

        comboBoxPanel2.add(letterComboBox2);
               
        return comboBoxPanel2;
    }
    

    

    private static void handle1V1ButtonClick() {
    	MotusVariable.oneVone=1;
    	handleStartButtonClick();
    	
    }

    private static void handleStartButtonClick() {
        int selectedIndex = letterComboBox.getSelectedIndex();
        MotusVariable.nbLettre = selectedIndex+4;
        MotusVariable.indLangue=letterComboBox2.getSelectedIndex();
        MotusFrame.startGame();
    }

}
