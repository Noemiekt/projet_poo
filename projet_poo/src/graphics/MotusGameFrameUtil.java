package graphics;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;



import javax.swing.JFrame;

import controllers.*;
import graphics.MotusIntroFrame.ImagePanel;

public class MotusGameFrameUtil {


public static JFrame errorFrame;
public static JFrame endFrame;
public static JFrame nextFrame;


    public static void validatedButtonClick() {
     
        MotusVariable.userInput = MotusVariable.userInputField.getText();
        MotusVariable.userInput = MotusVariable.userInput.toUpperCase();
        System.out.print("le mot est : " + MotusVariable.userInput );
        System.out.println();
        
        
        
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
			  Tab.modifTabVerification();
			  Tab.modifTabInput();
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
				  nextGame();
				  
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
    
    public static void looseGame() {
    	endFrame = MotusFrameUtil.createEndFrame();
		ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/perdu.jpeg");
		endFrame.setContentPane(backgroundPanel);
		MotusFrameUtil.configureAndShowMessage(endFrame, 600, 300);
    }
    
    public static void nextGame() {
    	nextFrame = MotusFrameUtil.createNextFrame();
		ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/choix.jpeg");
		nextFrame.setContentPane(backgroundPanel);
		MotusFrameUtil.configureAndShowMessage(nextFrame, 600, 300);
    }
    	
    
    public static void winGame() {
    	endFrame = MotusFrameUtil.createEndFrame();
		ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/bravo.jpeg");
		endFrame.setContentPane(backgroundPanel);
		
		JLabel label = new JLabel("Le bon mot était : " + MotusVariable.motAtrouver);
		label.setFont(new Font("Impact", Font.BOLD, 50));
        label.setForeground(MotusVariable.rose);
	    label.setHorizontalAlignment(JLabel.CENTER); // Centre le texte horizontalement
	    label.setVerticalAlignment(JLabel.BOTTOM); // Aligne le texte en bas
	    endFrame.add(label);
		MotusFrameUtil.configureAndShowMessage(endFrame, 600, 300);
    }

       
		  
	   	  
    public static void restartButtonClicked() {
    	MotusFrame.gameFrame.setVisible(false);
		MotusFrame.homeFrame = MotusHomeFrame.createHomeFrame();
		MotusFrameUtil.configureAndShowFrame(MotusFrame.homeFrame, 960, 540);
    }
}
		  
		  
		  
		  
		  
		  
		  /*
		  System.out.printf("Le mot est : %s%n", game.motJoueur);
		  System.out.print("les indices de lettres bien positionnées sont : ");
		  for (int i = 0; i < game.lettresBonPos.length; i++) {
		      System.out.print(game.lettresBonPos[i] + " ");
		  }
		  System.out.println();
		  System.out.print("les indices de lettres bonnes mais mal positionnées sont : ");
			for (int i = 0; i < game.lettresMalPos.length; i++) {
			    System.out.print(game.lettresMalPos[i] + " ");
			}
			System.out.println();
			
			Matrice mat;
			mat = new Matrice();
			
			System.out.printf("le tableau est ");
			for (int i = 0; i < mat.longueur; i++) {
				System.out.print(mat.lineVerification[i] + " ");
	        }
		  System.out.println("Saisie de l'utilisateur : " + MotusFrame.userInput);
		  
		  System.out.printf("la ligne est ");
			for (int i = 0; i < mat.longueur; i++) {
				System.out.print(mat.lineRightPlaced[i] + " ");
	        }
		  System.out.println("Saisie de l'utilisateur : " + MotusFrame.userInput);
		  
		  System.out.println("Saisie de l'utilisateur : " + MotusFrame.userInput);
		  System.out.println("Numero d'erreur : " + game.erreur_int);
		  System.out.println("Type d'erreur : " + game.erreur_string);
		  
//		  tab = new Tableau(mat.longueur);
//		  
//		  for (int i = 0; i < tab.TabRightPlaced.length; i++) { 
//	            for (int j = 0; j < tab.TabRightPlaced[i].length; j++) {
//	                System.out.print(tab.TabRightPlaced[i][j] + " ");
//	            }
//	            System.out.println();
//	        }
 * 
 */
		 
		  
    
    

    
   


