package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MotusIntroFrame {

    public static JFrame createIntroFrame() {
        JFrame introFrame = new JFrame("Introduction");
        introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        introFrame.setLayout(new BorderLayout());

        ImagePanel backgroundPanel = createBackgroundPanel("res/motus.jpeg");
        introFrame.setContentPane(backgroundPanel);

        JLabel clickLabel = createClickLabel("Click to start the game");
        introFrame.add(clickLabel, BorderLayout.NORTH);

        addClickAction(introFrame);

        return introFrame;
    }

    private static ImagePanel createBackgroundPanel(String imagePath) {
        ImagePanel backgroundPanel = new ImagePanel(imagePath);
        backgroundPanel.setLayout(new BorderLayout());
        return backgroundPanel;
    }

    private static JLabel createClickLabel(String text) {
        JLabel clickLabel = new JLabel(text);
        clickLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        clickLabel.setForeground(Color.BLACK);
        clickLabel.setHorizontalAlignment(JLabel.CENTER);
        return clickLabel;
    }

    private static void addClickAction(JFrame frame) {
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MotusFrame.home();
            }
        });
    }


    private static class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel(String imagePath) {
            this.backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MotusIntroFrame::createIntroFrame);
    }
}
