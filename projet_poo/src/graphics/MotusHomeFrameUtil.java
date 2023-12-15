package graphics;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import graphics.MotusIntroFrame.ImagePanel;

public class MotusHomeFrameUtil {
	private static JComboBox<String> letterComboBoxLet;
	private static JComboBox<String> letterComboBoxLang;
	
	public static JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new GridBagLayout());       
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_END;
        gbc.insets = new Insets(0, 0, 10, 0);
        
        mainPanel.setOpaque(false);

        mainPanel.add(createComboBoxPanelNbLet(), gbc);
          
        gbc.gridy++;
        mainPanel.add(createComboBoxPanelLang(), gbc);

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
	    MotusFrame.scoreFrame = createScoreFrame();
	    addScoreFrameComponents();
	    configureAndShowScoreFrame();
	}

	private static JFrame createScoreFrame() {
	    JFrame scoreFrame = new JFrame("Score");
	    ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/images/score.jpeg");
	    scoreFrame.setContentPane(backgroundPanel);
	    return scoreFrame;
	}

	private static void addScoreFrameComponents() {
	    JPanel panel = createScorePanel();
	    addLabelsToScorePanel(panel);
	    MotusFrame.scoreFrame.add(panel);
	    addWindowListenerToScoreFrame();
	}

	private static JPanel createScorePanel() {
	    JPanel panel = new JPanel(new GridLayout(7, MotusVariable.nbLettre));
	    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    panel.setOpaque(false);
	    return panel;
	}

	private static void addLabelsToScorePanel(JPanel panel) {  
	    for (int i = 0; i < 2; i++) {
	        JLabel cellLabel = createScoreCellLabel(i);
	        cellLabel.setBackground(Color.WHITE);
	        panel.add(cellLabel);
	    }
	}

	private static JLabel createScoreCellLabel(int index) {
		Font customFont = new Font("Impact", Font.BOLD, 30);
	    JLabel cellLabel = MotusFrameUtil.createEmptyCellLabel();
	    
	    if (MotusVariable.TabScore[0][index] != null) {
	    	cellLabel.setBackground(Color.WHITE);
	        cellLabel.setFont(customFont);
	        cellLabel.setForeground(MotusVariable.rose);
	        cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        cellLabel.setText(String.valueOf(MotusVariable.TabScore[0][index]));
	    }
	    
	    return cellLabel;
	}

	private static void addWindowListenerToScoreFrame() {
	    MotusFrame.scoreFrame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            MotusFrame.scoreFrame.setVisible(false);
	        }
	    });
	}

	private static void configureAndShowScoreFrame() {
	    MotusFrameUtil.configureAndShowMessage(MotusFrame.scoreFrame, 600, 300);
	}


    private static JPanel createComboBoxPanelNbLet() {
        JPanel comboBoxPanelLet = new JPanel();
        comboBoxPanelLet.setLayout(new FlowLayout(FlowLayout.CENTER));

        String[] letterCounts = {"Mot de 4 lettres", "Mot de 5 lettres", "Mot de 6 lettres", "Mot de 7 lettres", "Mot de 8 lettres", "Mot de 9 lettres"};
        letterComboBoxLet = new JComboBox<>(letterCounts);
        letterComboBoxLet.setSelectedIndex(0);
        
        Font font = new Font("Impact", Font.BOLD, 20); 
        letterComboBoxLet.setFont(font);    
        letterComboBoxLet.setForeground(MotusVariable.rose); 
        
        comboBoxPanelLet.setOpaque(false);
        comboBoxPanelLet.add(letterComboBoxLet);            
        return comboBoxPanelLet;
    }
    
    private static JPanel createComboBoxPanelLang() {
        JPanel comboBoxPanelLang = new JPanel();
        comboBoxPanelLang.setLayout(new FlowLayout(FlowLayout.CENTER));

        String[] letterCounts = {"Français", "Anglais", "Espagnol"};
        letterComboBoxLang = new JComboBox<>(letterCounts);
        letterComboBoxLang.setSelectedIndex(0);
               
        Font font = new Font("Impact", Font.BOLD, 20); 
        letterComboBoxLang.setFont(font);
        letterComboBoxLang.setForeground(MotusVariable.rose); 
        
        comboBoxPanelLang.setOpaque(false);
        comboBoxPanelLang.add(letterComboBoxLang);
               
        return comboBoxPanelLang;
    }
    

    private static void handle1V1ButtonClick() {
    	MotusVariable.oneVone=1;
    	handleStartButtonClick();
    	
    }

    private static void handleStartButtonClick() {
        int selectedIndex = letterComboBoxLet.getSelectedIndex();
        MotusVariable.nbLettre = selectedIndex+4;
        MotusVariable.indLangue=letterComboBoxLang.getSelectedIndex();
        MotusFrame.startGame();
    }

}
