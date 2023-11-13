package graphics;

public class MotusGameFrameUtil {
    public static void validatedButtonClick() {
        MotusFrame.userInput = MotusFrame.userInputField.getText();
        System.out.println("Saisie de l'utilisateur : " + MotusFrame.userInput);
    }

    public static void restartButtonClicked() {
        MotusFrame.gameFrame.setVisible(false);
        MotusFrame.homeFrame = MotusHomeFrame.createHomeFrame();
        MotusFrameUtil.configureAndShowFrame(MotusFrame.homeFrame, 800, 350);
    }
}
