package controllers;

import javax.swing.*;

import graphics.GameTimer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerControls {
	public static Timer timer;
	public static int secondsRemaining;
    JLabel timerLabel;
    
    public TimerControls() {
    	secondsRemaining = 100;
    }

    
    public TimerControls(int totalSeconds, JLabel label) {
        secondsRemaining = totalSeconds;
        this.timerLabel = label;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                updateLabel();
                secondsRemaining--;
                if ((secondsRemaining <= 0)&&(timer != null)) {
                    timer.cancel();
                    GameTimer.endTime();
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
    
    private void updateLabel() {
        int minutes = secondsRemaining / 60;
        int seconds = secondsRemaining % 60;
        String timeText = String.format("%02d:%02d", minutes, seconds);
        SwingUtilities.invokeLater(() -> timerLabel.setText(timeText));
    }

}
