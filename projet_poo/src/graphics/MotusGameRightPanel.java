package graphics;

import javax.swing.*;
import java.awt.*;

public class MotusGameRightPanel {
    public static JPanel createGameRightPanel(JFrame frame) {
        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(MotusFrameUtil.createLabel("Ta proposition :"));
        MotusFrame.userInputField = new JTextField(20);
        panel.add(MotusFrame.userInputField);
        panel.add(MotusFrameUtil.createButton("Validé", e -> MotusGameFrameUtil.validatedButtonClick()));
        panel.add(MotusFrameUtil.createButton("Recommencer", e -> MotusGameFrameUtil.restartButtonClicked()));
        panel.add(MotusFrameUtil.createButton("Quitter", e -> System.exit(0)));

        return panel;
    }
}

