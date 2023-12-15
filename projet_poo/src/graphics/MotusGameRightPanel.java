package graphics;

import controllers.MotusVariable;
import controllers.TimerControls;
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
        gbc.insets = new Insets(0, 0, 10, 0); 
         
        JLabel timerLabel = new JLabel("00:00");
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setForeground(MotusVariable.gold); 
        Font font = new Font("Impact", Font.BOLD, 25);
        timerLabel.setFont(font);
        panel.add(timerLabel, gbc); 
        
      
        gbc.gridy++;
        JLabel label = MotusFrameUtil.createLabel("Ta proposition :");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, gbc);

        gbc.gridy++;
        MotusVariable.userInputField = new JTextField();
        MotusVariable.userInputField.setHorizontalAlignment(JTextField.CENTER);
        MotusVariable.userInputField.setColumns(20); 
        MotusVariable.userInputField.setMaximumSize(new Dimension(300, MotusFrameUtil.createButton("Validé", e -> {}).getPreferredSize().height));
        panel.add(MotusVariable.userInputField, gbc);

        gbc.gridy++;
        JButton buttonValider = MotusFrameUtil.createButton("Valider", e -> MotusGameFrameUtil.validatedButtonClick());
        panel.add(buttonValider, gbc);

        gbc.gridy++;
        JButton buttonRecommencer = MotusFrameUtil.createButton("Recommencer", e -> MotusGameFrameUtil.restartButtonClicked());
        panel.add(buttonRecommencer, gbc);

        gbc.gridy++;
        JButton buttonQuitter = MotusFrameUtil.createButton("Quitter", e -> System.exit(0));
        panel.add(buttonQuitter, gbc);
        
        
        TimerControls gameTimer = new TimerControls(60+30*(MotusVariable.nbLettre-4), timerLabel); 

        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(460, 520));
        
        return panel;
    }
}
