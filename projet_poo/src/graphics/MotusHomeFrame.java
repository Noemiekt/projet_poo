package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import java.awt.*;


public class MotusHomeFrame {

    public static JFrame createHomeFrame() {
        JFrame frame = new JFrame("Accueil");
        frame.setLayout(new BorderLayout());

        ImagePanel backgroundPanel = new ImagePanel("res/images/home.jpeg");
        frame.setContentPane(backgroundPanel);

        JPanel mainPanel = MotusHomeFrameUtil.createMainPanel();

        frame.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        frame.add(mainPanel, BorderLayout.SOUTH);

        return frame;
    }

}
