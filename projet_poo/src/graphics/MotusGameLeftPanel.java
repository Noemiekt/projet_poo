package graphics;

import javax.swing.*;


import java.awt.*;

public class MotusGameLeftPanel {
	
	
	
    public static JPanel createGameLeftPanel() {
        JPanel panel = new JPanel(new GridLayout(7, MotusVariable.nbLettre));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        for (int i = 0; i < 7 * (MotusVariable.nbLettre); i++) {
        	JLabel tableau = MotusFrameUtil.createEmptyCellLabel();
            panel.add(tableau);
        }
        
        panel.setOpaque(false);
        
        panel.setPreferredSize(new Dimension(460, 520));

        return panel;
    }
    
    public static void afficherTableau2D(char[][] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                System.out.print(tableau[i][j] + " ");
            }
            System.out.println(); // Nouvelle ligne après chaque ligne du tableau
        }
    }
    
    public static void afficherTableau(int[][] tableau) {
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                System.out.print(tableau[i][j] + " ");
            }
            System.out.println(); // Nouvelle ligne après chaque ligne du tableau
        }
    }
    
    
	public static JPanel UpdateLeftPanel() {
		JPanel panel = new JPanel(new GridLayout(7, MotusVariable.nbLettre));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		
		Font customFont = new Font("Impact", Font.BOLD, 30);  // Remplacez "Arial" par la police que vous souhaitez

		
        for (int i = 0; i < 7 ; i++) {
        	for	(int j = 0; j < MotusVariable.nbLettre; j++)
	        	
	        	if (MotusVariable.TabVerification[i][j]==0) {
	        		JLabel cellLabel = MotusFrameUtil.createEmptyCellLabel();
	        		cellLabel.setBackground(Color.WHITE);
	        		cellLabel.setFont(customFont);
	        		cellLabel.setForeground(Color.BLACK);
	        		cellLabel.setHorizontalAlignment(SwingConstants.CENTER); 
	        		cellLabel.setText(String.valueOf(MotusVariable.TabInput[i][j]));
	        		panel.add(cellLabel);
	        	}
        		
	        	else if (MotusVariable.TabVerification[i][j]==1) {
	        		JLabel cellLabel = MotusFrameUtil.createEmptyCellLabel();
	        		cellLabel.setBackground(MotusVariable.gold);
	        		cellLabel.setFont(customFont);
	        		cellLabel.setForeground(Color.WHITE);
	        		cellLabel.setHorizontalAlignment(SwingConstants.CENTER); 
	        		cellLabel.setText(String.valueOf(MotusVariable.TabInput[i][j]));
	        		panel.add(cellLabel);
	        	}
        	
	        	else if (MotusVariable.TabVerification[i][j]==2) {	        		   		
	        		JLabel cellLabel = MotusFrameUtil.createEmptyCellLabel();
	        		cellLabel.setBackground(MotusVariable.rose);
	        		cellLabel.setFont(customFont);
	        		cellLabel.setForeground(Color.WHITE);
	        		cellLabel.setHorizontalAlignment(SwingConstants.CENTER); 
	        		cellLabel.setText(String.valueOf(MotusVariable.TabInput[i][j]));
	        		panel.add(cellLabel);
	        	}
	        	else {
	        		JLabel cellLabel = MotusFrameUtil.createEmptyCellLabel();
	        		cellLabel.setBackground(Color.WHITE);
	        		panel.add(cellLabel);
	        	}
        	
        	
        }
        
        panel.setOpaque(false);
        
        panel.setPreferredSize(new Dimension(460, 520));
        
        return panel;


    }
    
    
    
    
}
