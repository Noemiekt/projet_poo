package graphics;
import javax.swing.JFrame;

import controllers.*;
import graphics.MotusIntroFrame.ImagePanel;
public class MotusGameFrameUtil {
 //private static final Object[] TabRightPlaced = null;
public static GamesControls game;
public static Tableau tab;
public static JFrame errorFrame;

    public static void validatedButtonClick() {
     
        MotusFrame.userInput = MotusFrame.userInputField.getText();
        MotusFrame.userInput = MotusFrame.userInput.toUpperCase();
        
        
		  game = new GamesControls(MotusFrame.userInput);
		  

		  String err_string =game.erreur_string;
		  
		  if (game.erreur_int==1) {
			  errorFrame = MotusFrameUtil.createErrorFrame();
		      ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/nonvalidelettre.jpeg");
		      errorFrame.setContentPane(backgroundPanel);
		      MotusFrameUtil.configureAndShowMessage(errorFrame, 600, 300);
		  }
		  
		  if (game.erreur_int==2) {
			  errorFrame = MotusFrameUtil.createErrorFrame();
			  ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/nonvalidelong.jpeg");
		      errorFrame.setContentPane(backgroundPanel);
		      MotusFrameUtil.configureAndShowMessage(errorFrame, 600, 300);
		  }
		  
		  if (game.erreur_int==3) {
			  errorFrame = MotusFrameUtil.createErrorFrame();
			  ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/nonvalideprems.jpeg");
		      errorFrame.setContentPane(backgroundPanel);
		      MotusFrameUtil.configureAndShowMessage(errorFrame, 600, 300);
		  }
		  
		  
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
		 
		  
    }
    
   
   	  
    public static void restartButtonClicked() {
        MotusFrame.gameFrame.setVisible(false);
        MotusFrame.homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(MotusFrame.homeFrame, 960, 540);
    }
}
