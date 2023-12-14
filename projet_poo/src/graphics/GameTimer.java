package graphics;

import javax.swing.*;

import graphics.MotusIntroFrame.ImagePanel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
	public static Timer timer;
	public static int secondsRemaining;
    JLabel timerLabel;
    
    public GameTimer() {
    	secondsRemaining = 100;
    }

    
    public GameTimer(int totalSeconds, JLabel label) {
        secondsRemaining = totalSeconds;
        this.timerLabel = label;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                updateLabel();
                secondsRemaining--;
                if ((secondsRemaining <= 0)&&(timer != null)) {
                    timer.cancel();
                    endTime();
                }
            }
        }, 0, 1000);
    }
    
    public static void cancelTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }
    
    public static void purgeTimer() {
        if (timer != null) {
            timer.purge();
        }
    }
    
    public static void endTime() {
        stopAndPlayMusic();
        setupEndFrame();
        addComponentsToEndFrame();
        configureAndShowEndFrame();
        addWindowListenerToEndFrame();
    }

    private static void stopAndPlayMusic() {
        Music.stopMusic("./song.wav");
        Music.playMusic("./justken.wav");
    }

    private static void setupEndFrame() {
        MotusGameFrameUtil.messFrame = MotusFrameUtil.createEndFrame();
        ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/temps.jpeg");
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

    
    private void updateLabel() {
        int minutes = secondsRemaining / 60;
        int seconds = secondsRemaining % 60;
        String timeText = String.format("%02d:%02d", minutes, seconds);
        SwingUtilities.invokeLater(() -> timerLabel.setText(timeText));
    }
}


