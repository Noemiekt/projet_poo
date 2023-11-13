package graphics;
import controllers.*;
public class MotusGameFrameUtil {
    public static void validatedButtonClick() {
        MotusFrame.userInput = MotusFrame.userInputField.getText();
        GamesControls game;
		game = new GamesControls(MotusFrame.userInput);
		System.out.printf("Le mot est : %s%n", game.motJoueur);
		System.out.print("les indices de lettres bien positionnées sont : ");
		for (int i = 0; i < game.lettresBonPos.length; i++) {
		    System.out.print(game.lettresBonPos[i] + " ");
		}
		System.out.println();
        System.out.println("Saisie de l'utilisateur : " + MotusFrame.userInput);
    }

    public static void restartButtonClicked() {
        MotusFrame.gameFrame.setVisible(false);
        MotusFrame.homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(MotusFrame.homeFrame, 800, 350);
    }
}
