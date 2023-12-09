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
        // Arrêter le Timer
        if (timer != null) {
            timer.cancel();
        }
    }
    
    public static void purgeTimer() {
        // Arrêter le Timer
        if (timer != null) {
            timer.purge();
        }
    }
    
    public static void endTime() {
    	MotusGameFrameUtil.messFrame = MotusFrameUtil.createEndFrame();
		ImagePanel backgroundPanel = MotusIntroFrame.createBackgroundPanel("res/temps.jpeg");
		MotusGameFrameUtil.messFrame.setContentPane(backgroundPanel);
		
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
		
		
		MotusFrameUtil.configureAndShowMessage(MotusGameFrameUtil.messFrame, 600, 300);
		
		MotusGameFrameUtil.messFrame.addWindowListener(new WindowAdapter() {
	        @Override
	         public void windowClosing(WindowEvent e) {
	              // Appel de la fonction home() lorsque l'utilisateur ferme la fenêtre
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


