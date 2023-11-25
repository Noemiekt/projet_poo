package graphics;
import controllers.*;
public class MotusGameFrameUtil {
 //private static final Object[] TabRightPlaced = null;
public static GamesControls game;
public static Tableau tab;
    public static void validatedButtonClick() {
     
        MotusFrame.userInput = MotusFrame.userInputField.getText();
        MotusFrame.userInput = MotusFrame.userInput.toUpperCase();
        
        
		  game = new GamesControls(MotusFrame.userInput);
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
		  
		  tab = new Tableau(mat.longueur);
		  
		  for (int i = 0; i < tab.TabRightPlaced.length; i++) { 
	            for (int j = 0; j < tab.TabRightPlaced[i].length; j++) {
	                System.out.print(tab.TabRightPlaced[i][j] + " ");
	            }
	            System.out.println();
	        }
		 
		  
    }
    
   
   	  
    public static void restartButtonClicked() {
        MotusFrame.gameFrame.setVisible(false);
        MotusFrame.homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(MotusFrame.homeFrame, 800, 350);
    }
}
