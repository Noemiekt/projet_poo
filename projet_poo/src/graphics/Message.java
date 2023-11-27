package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import java.awt.*;


public class Message {

    public static void BravoFrame() {
        JFrame frame = new JFrame("Accueil");
        frame.setLayout(new BorderLayout());

        ImagePanel backgroundPanel = new ImagePanel("res/bravo.jpeg");
        frame.setContentPane(backgroundPanel);
        
        MotusFrameUtil.configureAndShowFrame(frame, 960, 270);
        
    }
}
