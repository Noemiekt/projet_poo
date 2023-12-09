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


    public static void validatedButtonClick() {
     
        MotusVariable.userInput = MotusVariable.userInputField.getText();
        MotusVariable.userInput = MotusVariable.userInput.toUpperCase();
        System.out.print("le mot est : " + MotusVariable.userInput );
        System.out.println();
        
        MotusVariable.userInputField.setText("");
        
		  int err = GamesControls.setErreurInt();
		  
		  if (err==1) {
			  errorFrame = MotusFrameUtil.createErrorFrame();
		      ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/nonvalidelettre.jpeg");
		      errorFrame.setContentPane(backgroundPanel);
		      MotusFrameUtil.configureAndShowMessage(errorFrame, 600, 300);
		  }
		  
		  else if (err==2) {
			  errorFrame = MotusFrameUtil.createErrorFrame();
			  ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/nonvalidelong.jpeg");
		      errorFrame.setContentPane(backgroundPanel);
		      MotusFrameUtil.configureAndShowMessage(errorFrame, 600, 300);
		  }
		  
		  else if (err==3) {
			  errorFrame = MotusFrameUtil.createErrorFrame();
			  ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/nonvalideprems.jpeg");
		      errorFrame.setContentPane(backgroundPanel);
		      MotusFrameUtil.configureAndShowMessage(errorFrame, 600, 300);
		  }
		  
		  else {
			  MotusVariable.nbEssai=MotusVariable.nbEssai+1;
			  
			  Tab.modifTabInput();
			  Tab.modifTabVerification();
			  
			  MotusGameLeftPanel.afficherTableau(MotusVariable.TabVerification);
			  MotusGameLeftPanel.afficherTableau2D(MotusVariable.TabInput);
			  
			  //Recharger le tableau
			  MotusFrame.gameFrame.remove(MotusGameFrame.gameLeftPanel);
			  MotusGameFrame.gameLeftPanel = MotusGameLeftPanel.UpdateLeftPanel();

			  MotusFrame.gameFrame.add(MotusGameFrame.gameLeftPanel, BorderLayout.WEST);

			  MotusFrame.gameFrame.revalidate();
			  MotusFrame.gameFrame.repaint();
			  
			  if (motbon()==0) {
				  winGame();
				  
			  }
			  if (MotusVariable.nbEssai==7) {
				  looseGame();		  
			  }
			  
			  

			  
		  }
    }
    
    public static int motbon() {
    	for (int valeur : MotusVariable.TabVerification[MotusVariable.nbEssai-1]) {
            if (valeur != 2) {
            	return 1;
            }
        }
    	return 0;
    }
    
   
    
    public static void nextButtonClick() {
    	messFrame.setVisible(false);
    	nextFrame = MotusFrameUtil.createNextFrame();
		ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/choix.jpeg");
		nextFrame.setContentPane(backgroundPanel);
		
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
        
        
        nextFrame.add(panel, BorderLayout.SOUTH);
		
		
		MotusFrameUtil.configureAndShowMessage(nextFrame, 600, 300);
		
		nextFrame.addWindowListener(new WindowAdapter() {
	        @Override
	         public void windowClosing(WindowEvent e) {
	              // Appel de la fonction home() lorsque l'utilisateur ferme la fenêtre
	        	nextFrame.setVisible(false);
	            MotusFrame.home();
	          }
		  });
    
    }
    	
    public static void addScore() {
    	if (MotusVariable.TabScore[0][1]==null) {
    		int score=(7-MotusVariable.nbEssai)*MotusVariable.nbLettre*GameTimer.secondsRemaining;
    		MotusVariable.TabScore[0][1]=Integer.toString(score);; 
    	}
    	else {
    		int score=(7-MotusVariable.nbEssai)*MotusVariable.nbLettre*GameTimer.secondsRemaining;
    		if (score>Integer.parseInt(MotusVariable.TabScore[0][1])) {
    			MotusVariable.TabScore[0][1]=Integer.toString(score);; 
    		}
    	}
    }
    
    public static void winGame() {
    	GameTimer.cancelTimer();	
    	addScore();
    	GameTimer.purgeTimer();
    	
    	messFrame = MotusFrameUtil.createEndFrame();
		ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/bravo.jpeg");
		messFrame.setContentPane(backgroundPanel);
		
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
        JButton buttonValider = MotusFrameUtil.createButton("Next", e -> nextButtonClick());
        panel.setOpaque(false);
        panel.add(buttonValider, gbc);
        
        messFrame.add(panel, BorderLayout.SOUTH);
		
		
		MotusFrameUtil.configureAndShowMessage(messFrame, 600, 300);
		
		messFrame.addWindowListener(new WindowAdapter() {
	        @Override
	         public void windowClosing(WindowEvent e) {
	              // Appel de la fonction home() lorsque l'utilisateur ferme la fenêtre
	        	messFrame.setVisible(false);
	            MotusFrame.home();
	          }
		  });
    }
    
    public static void looseGame() {
    	GameTimer.cancelTimer();
    	GameTimer.purgeTimer();
    	messFrame = MotusFrameUtil.createEndFrame();
		ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/perdu.jpeg");
		messFrame.setContentPane(backgroundPanel);
		
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
        JButton buttonValider = MotusFrameUtil.createButton("Next", e ->nextButtonClick());
        panel.setOpaque(false);
        panel.add(buttonValider, gbc);
        
        messFrame.add(panel, BorderLayout.SOUTH);
		
		
		MotusFrameUtil.configureAndShowMessage(messFrame, 600, 300);
		
		messFrame.addWindowListener(new WindowAdapter() {
	        @Override
	         public void windowClosing(WindowEvent e) {
	              // Appel de la fonction home() lorsque l'utilisateur ferme la fenêtre
	        	messFrame.setVisible(false);
	            MotusFrame.home();
	          }
		  });
    }
    
    
    public static void closeAndRestart() {
    	nextFrame.setVisible(false);
    	restartButtonClicked();
    }
		  
	   	  
    public static void restartButtonClicked() {
    	MotusFrame.gameFrame.setVisible(false);
    	GameTimer.cancelTimer();
    	GameTimer.purgeTimer();
		MotusFrame.homeFrame = MotusHomeFrame.createHomeFrame();
		MotusFrameUtil.configureAndShowFrame(MotusFrame.homeFrame, 960, 540);
    }
}
		  
		  
		  
		  
		  
		  
		 