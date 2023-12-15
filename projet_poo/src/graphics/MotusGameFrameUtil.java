package graphics;
import java.awt.BorderLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controllers.*;
import graphics.MotusIntroFrame.ImagePanel;

public class MotusGameFrameUtil {
	public static JFrame errorFrame;
	public static JFrame messFrame;
	public static JFrame nextFrame;
	
	// New user input
	public static void validatedButtonClick() {
	    processUserInput();
	}
	
	// Input processing
	private static void processUserInput() {
		// Input recovery
	    MotusVariable.userInput = MotusVariable.userInputField.getText();
	    MotusVariable.userInput = MotusVariable.userInput.toUpperCase();
	    MotusVariable.userInputField.setText("");
	
	    //Input check
	    int err = GamesControls.setErreurInt();
	    handleErrorCode(err);
	}
	
	
	private static void handleErrorCode(int err) {
	    if (err >= 1 && err <= 3) {
	        handleInvalidInputError(err);
	    } else {
	        handleValidInput();
	    }
	}
	
	
	// Input error :
	private static void handleInvalidInputError(int err) {
		// Error message display
	    Music.playMusic("res/musiques/err.wav");
	    errorFrame = MotusFrameUtil.createErrorFrame();
	    String imagePath = getImagePathBasedOnErrorCode(err);
	    ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel(imagePath);
	    errorFrame.setContentPane(backgroundPanel);
	    MotusFrameUtil.configureAndShowMessage(errorFrame, 600, 300);
	}
	
	// Find the type of error
	private static String getImagePathBasedOnErrorCode(int err) {
	    switch (err) {
	        case 1:
	            return "res/images/nonvalidelettre.jpeg";
	        case 2:
	            return "res/images/nonvalidelong.jpeg";
	        case 3:
	            return "res/images/nonvalideprems.jpeg";
	        default:
	            return "";
	    }
	}
	
	// Valid Input
	private static void handleValidInput() {
	    MotusVariable.nbEssai = MotusVariable.nbEssai + 1;
	
	    // Update table
	    Tab.modifTabInput();
	    Tab.modifTabVerification();
	
	    updateGameFrame();
	}
	
	private static void updateGameFrame() {
	    MotusFrame.gameFrame.remove(MotusGameFrame.gameLeftPanel);
	    MotusGameFrame.gameLeftPanel = MotusGameLeftPanel.UpdateLeftPanel();
	
	    MotusFrame.gameFrame.add(MotusGameFrame.gameLeftPanel, BorderLayout.WEST);
	
	    MotusFrame.gameFrame.revalidate();
	    MotusFrame.gameFrame.repaint();
	
	    if (motbon() == 0) {
	        Music.playMusic("res/musiques//yeah.wav");
	        winGame();
	    }
	
	    if (MotusVariable.nbEssai == 7) {
	        Music.playMusic("res/musiques//nul.wav");
	        looseGame();
	    }
	}

    // Check that user input is the correct word
    public static int motbon() {
    	for (int valeur : MotusVariable.TabVerification[MotusVariable.nbEssai-1]) {
            if (valeur != 2) {
            	return 1;
            }
        }
    	return 0;
    }
    
   
    public static void nextButtonClick() {
        hideCurrentFrame();
        createAndConfigureNextFrame();
        addButtonsAndPanelToNextFrame();
        configureAndShowNextFrame();
        addWindowListenerToNextFrame();
    }

    private static void hideCurrentFrame() {
        messFrame.setVisible(false);
    }

    private static void createAndConfigureNextFrame() {
        nextFrame = MotusFrameUtil.createNextFrame();
        ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/images/choix.jpeg");
        nextFrame.setContentPane(backgroundPanel);
    }

    private static void addButtonsAndPanelToNextFrame() {
        JPanel panel = createButtonPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
        nextFrame.add(panel, BorderLayout.CENTER);
    }

    private static JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        
        JButton buttonRecommencer = MotusFrameUtil.createButton("Recommencer", e -> closeAndRestart());
        panel.add(buttonRecommencer, gbc);

        gbc.gridy++;
        JButton buttonQuitter = MotusFrameUtil.createButton("Quitter", e -> System.exit(0));
        panel.add(buttonQuitter, gbc);
        
        panel.setOpaque(false);
        return panel;
    }

    private static void configureAndShowNextFrame() {
        MotusFrameUtil.configureAndShowMessage(nextFrame, 600, 300);
    }

    private static void addWindowListenerToNextFrame() {
        nextFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                nextFrame.setVisible(false);
                MotusFrame.home();
            }
        });
    }

    // Update the Score
    public static void addScore() {
    	if (MotusVariable.TabScore[0][1]==null) {
    		int score=(7-MotusVariable.nbEssai)*MotusVariable.nbLettre*TimerControls.secondsRemaining;
    		MotusVariable.TabScore[0][1]=Integer.toString(score);; 
    	}
    	else {
    		int score=(7-MotusVariable.nbEssai)*MotusVariable.nbLettre*TimerControls.secondsRemaining;
    		if (score>Integer.parseInt(MotusVariable.TabScore[0][1])) {
    			MotusVariable.TabScore[0][1]=Integer.toString(score);; 
    		}
    	}
    }
    public static void endGame(String imagePath) {
        stopGameTimer();
        
        messFrame = MotusFrameUtil.createEndFrame();
        setupEndFrame(imagePath);
        addComponentsToPanel();
        configureAndShowEndFrame();
    }

    private static void stopGameTimer() {
        TimerControls.cancelTimer();
        TimerControls.purgeTimer();
    }

    private static void setupEndFrame(String imagePath) {
        ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel(imagePath);
        messFrame.setContentPane(backgroundPanel);
    }

    private static void addComponentsToPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        
        JLabel label = MotusFrameUtil.createLabel("Le bon mot :");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, gbc);
        
        gbc.gridy++;
        JLabel label2 = MotusFrameUtil.createLabel(MotusVariable.motAtrouver);
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label2, gbc);
        gbc.gridy++;
        JButton button = MotusFrameUtil.createButton("Next", e -> nextButtonClick());
        panel.add(button, gbc);
 
        
        panel.setOpaque(false);
        messFrame.add(panel, BorderLayout.SOUTH);
    }

  

    private static void configureAndShowEndFrame() {
        MotusFrameUtil.configureAndShowMessage(messFrame, 600, 300);
        
        messFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                messFrame.setVisible(false);
                MotusFrame.home();
            }
        });
    }

    public static void winGame() {
    	TimerControls.cancelTimer();	
    	addScore();
    	TimerControls.purgeTimer();
        endGame("res/images/bravo.jpeg");
    }

    public static void looseGame() {
    	TimerControls.cancelTimer();
    	TimerControls.purgeTimer();
        endGame("res/images/perdu.jpeg");
    }

    
    public static void closeAndRestart() {
    	nextFrame.setVisible(false);
    	restartButtonClicked();
    }
		  
	   	  
    public static void restartButtonClicked() {
    	Music.stopMusic("res/musiques/justken.wav");
    	Music.stopMusic("res/musiques/song.wav");
    	Music.playMusic("res/musiques/home.wav");
    	MotusFrame.gameFrame.setVisible(false);
    	TimerControls.cancelTimer();
    	TimerControls.purgeTimer();
		MotusFrame.homeFrame = MotusHomeFrame.createHomeFrame();
		MotusFrameUtil.configureAndShowFrame(MotusFrame.homeFrame, 960, 540);
    }
}
		  
		  
		  
		  
		  
		  
		 