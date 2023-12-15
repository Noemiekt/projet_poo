package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameTimer {
	
    public static void endTime() {
    	Motus1V1Util.addScore1V1(0);
        stopAndPlayMusic();
        setupEndFrame();
        addComponentsToEndFrame();
        configureAndShowEndFrame();
        addWindowListenerToEndFrame();
    }

    private static void stopAndPlayMusic() {
        Music.stopMusic("res/musiques/song.wav");
        Music.playMusic("res/musiques/justken.wav");
    }

    private static void setupEndFrame() {
        MotusGameFrameUtil.messFrame = MotusFrameUtil.createEndFrame();
        ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/images/temps.jpeg");
        MotusGameFrameUtil.messFrame.setContentPane(backgroundPanel);
    }

    private static void addComponentsToEndFrame() {
        JPanel panel = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 10, 0);
        
        JButton buttonValider = MotusFrameUtil.createButton("Next", e -> MotusGameFrameUtil.nextButtonClick());
        panel.setOpaque(false);
        panel.add(buttonValider, gbc);
        
        MotusGameFrameUtil.messFrame.add(panel, BorderLayout.SOUTH);
    }

    private static void configureAndShowEndFrame() {
        MotusFrameUtil.configureAndShowMessage(MotusGameFrameUtil.messFrame, 600, 300);
    }

    private static void addWindowListenerToEndFrame() {
        MotusGameFrameUtil.messFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MotusGameFrameUtil.messFrame.setVisible(false);
                MotusFrame.home();
            }
        });
    }

    
    
}


