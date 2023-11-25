package graphics;
import controllers.*;
public class MotusGameFrameUtil {
 public static GamesControls game;
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
    }

    public static void restartButtonClicked() {
        MotusFrame.gameFrame.setVisible(false);
        MotusFrame.homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(MotusFrame.homeFrame, 800, 350);
    }
}
