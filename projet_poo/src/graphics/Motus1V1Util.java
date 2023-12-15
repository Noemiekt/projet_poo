package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.MotusVariable;
import controllers.TimerControls;
import graphics.MotusIntroFrame.ImagePanel;

public class Motus1V1Util {
	public static JFrame playerPresentFrame;
	public static JFrame score1V1Frame;
	
	public static void createAndConfigureAnnouncePlayerFrame() {
		
		playerPresentFrame = MotusFrameUtil.createAnnouncePlayerFrame();
		ImagePanel backgroundPanel;
		if (MotusVariable.who1V1player==1) {
			backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/images/joueur1.jpeg");
		}
		else {
			MotusGameFrameUtil.erraseTab();
			backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/images/joueur2.jpeg");
		}
        
        playerPresentFrame.setContentPane(backgroundPanel);
    }
	
	public static void addButtonsAndPanelToPlayerFrame() {
        JPanel panel = createButtonPanelPlayer();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
        playerPresentFrame.add(panel, BorderLayout.CENTER);
    }
	
	
	public static JPanel createButtonPanelPlayer() {
        JPanel panel = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        
        JButton buttonRecommencer = MotusFrameUtil.createButton("Commencer", e -> closeAndRestart1V1());
        panel.add(buttonRecommencer, gbc);

        
        panel.setOpaque(false);
        return panel;
    }
	
	// Input Score 1V1
    public static void addScore1V1(int win) {
    	int score=win*(7-MotusVariable.nbEssai)*MotusVariable.nbLettre*TimerControls.secondsRemaining;
		MotusVariable.Tab1V1[0][2*MotusVariable.who1V1player-1]=Integer.toString(score);; 
    }
    
    public static void closeAndRestart1V1() {
    	playerPresentFrame.setVisible(false);
    	restartButtonClicked1V1();
    }
    
    public static void restartButtonClicked1V1() {
    	if (MotusVariable.who1V1player==2) {
	    	Music.stopMusic("res/musiques/justken.wav");
	    	Music.stopMusic("res/musiques/song.wav");
	    	Music.playMusic("res/musiques/home.wav");
	    	MotusFrame.gameFrame.setVisible(false);
	    	TimerControls.cancelTimer();
	    	TimerControls.purgeTimer();
    	}
    	
		MotusFrame.startGame();
    }
    
    public static void configureAndShowPlayerPresentFrame() {
        MotusFrameUtil.configureAndShowMessage(playerPresentFrame, 600, 300);
    }

    public static void addWindowListenerToPlayerPresentFrame() {
    	playerPresentFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	playerPresentFrame.setVisible(false);
            	MotusVariable.who1V1player=1;
	        	MotusVariable.is1V1=0;
                MotusFrame.startGame();
            }
        });
    }
    
    public static JFrame createScoreFrame1V1() {
    	JFrame score = new JFrame("Score");
	    ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/images/score1V1.jpeg");
	    score.setContentPane(backgroundPanel);
	    return score;
	}

	public static void addScoreFrameComponents1V1() {
	    JPanel panel = createScorePanel();
	    addLabelsToScorePanel(panel);
	    score1V1Frame.add(panel);
	    addWindowListenerToScoreFrame();
	}

	private static JPanel createScorePanel() {
	    JPanel panel = new JPanel(new GridLayout(7, MotusVariable.nbLettre));
	    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	    panel.setOpaque(false);
	    return panel;
	}

	private static void addLabelsToScorePanel(JPanel panel) {  
	    for (int i = 0; i < 4; i++) {
	        JLabel cellLabel = createScoreCellLabel(i);
	        cellLabel.setBackground(Color.WHITE);
	        panel.add(cellLabel);
	    }
	}

	private static JLabel createScoreCellLabel(int index) {
		Font customFont = new Font("Impact", Font.BOLD, 30);
	    JLabel cellLabel = MotusFrameUtil.createEmptyCellLabel();
	    
	    if (MotusVariable.Tab1V1[0][index] != null) {
	    	cellLabel.setBackground(Color.WHITE);
	        cellLabel.setFont(customFont);
	        cellLabel.setForeground(MotusVariable.rose);
	        cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        cellLabel.setText(String.valueOf(MotusVariable.Tab1V1[0][index]));
	    }
	    
	    return cellLabel;
	}

	private static void addWindowListenerToScoreFrame() {
		score1V1Frame.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	        	score1V1Frame.setVisible(false);
	        	MotusFrame.gameFrame.setVisible(false);
	        	MotusVariable.who1V1player=1;
	        	MotusVariable.is1V1=0;
	            MotusFrame.home();
	        }
	    });
	}

	public static void configureAndShow1V1ScoreFrame() {
	    MotusFrameUtil.configureAndShowMessage(score1V1Frame, 600, 300);
	}

}
