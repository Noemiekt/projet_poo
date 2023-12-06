package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import java.awt.*;


public class MotusHomeFrame {

    public static JFrame createHomeFrame() {
        JFrame frame = new JFrame("Accueil");
        frame.setLayout(new BorderLayout());

        ImagePanel backgroundPanel = new ImagePanel("res/home.jpeg");
        frame.setContentPane(backgroundPanel);

        JPanel mainPanel = MotusHomeFrameUtil.createMainPanel();
        
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(mainPanel, gbc);

        return frame;
    }

}
