package graphics;

import javax.swing.*;
import java.awt.*;


public class MotusGameRightPanel {
    public static JPanel createGameRightPanel(JFrame frame) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0); // Espacement en bas

        JLabel label = MotusFrameUtil.createLabel("Ta proposition :");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, gbc);

        gbc.gridy++;
        MotusFrame.userInputField = new JTextField();
        MotusFrame.userInputField.setHorizontalAlignment(JTextField.CENTER);
        MotusFrame.userInputField.setColumns(20); // Ajustez le nombre de colonnes selon vos besoins
        MotusFrame.userInputField.setMaximumSize(new Dimension(300, MotusFrameUtil.createButton("Validé", e -> {}).getPreferredSize().height));
        panel.add(MotusFrame.userInputField, gbc);

        gbc.gridy++;
        JButton buttonValider = MotusFrameUtil.createButton("Validé", e -> MotusGameFrameUtil.validatedButtonClick());
        panel.add(buttonValider, gbc);

        gbc.gridy++;
        JButton buttonRecommencer = MotusFrameUtil.createButton("Recommencer", e -> MotusGameFrameUtil.restartButtonClicked());
        panel.add(buttonRecommencer, gbc);

        gbc.gridy++;
        JButton buttonQuitter = MotusFrameUtil.createButton("Quitter", e -> System.exit(0));
        panel.add(buttonQuitter, gbc);

        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(460, 520));

        return panel;
    }
}
