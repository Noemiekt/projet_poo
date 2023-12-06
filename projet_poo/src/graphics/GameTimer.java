package graphics;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
	Timer timer;
	int secondsRemaining;
    JLabel timerLabel;
    
    public GameTimer(int totalSeconds, JLabel label) {
        this.secondsRemaining = totalSeconds;
        this.timerLabel = label;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                updateLabel();
                secondsRemaining--;
                if (secondsRemaining <= 0) {
                    timer.cancel();
                    // Ajoutez ici ce qui doit se passer quand le temps est écoulé
                }
            }
        }, 0, 1000);
    }
    
    private void updateLabel() {
        int minutes = secondsRemaining / 60;
        int seconds = secondsRemaining % 60;
        String timeText = String.format("%02d:%02d", minutes, seconds);
        SwingUtilities.invokeLater(() -> timerLabel.setText(timeText));
    }
}


