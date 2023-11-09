package graphics;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class DispTableau extends Tableau{
	
	for (int i = 0; i < nbSaisie; i++) {
	    for (int j = 0; j < selectedIndex + 4; j++) {
	        JLabel cellLabel = new JLabel(Character.toString(tableInput[i][j]));
	        // Définir la couleur de fond en fonction de TableVerification
	        if (tableVerification[i][j] == 0) {
	            cellLabel.setBackground(Color.WHITE);
	        } else if (tableVerification[i][j] == 1) {
	            cellLabel.setBackground(Color.YELLOW);
	        } else if (tableVerification[i][j] == 2) {
	            cellLabel.setBackground(Color.RED);
	        }
	        // Contours des cellules en vert sapin
	        cellLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0))); // Vert sapin
	        cellLabel.setOpaque(true);
	        gameLeftPanel.add(cellLabel);
	    }
	}

	// Afficher TableRight pour la nbSaisie + 1 ligne
	if (nbSaisie < 7) {
	    for (int j = 0; j < selectedIndex + 4; j++) {
	        JLabel cellLabel = new JLabel("");
	        // Définir la couleur de fond en fonction de TableRight
	        if (tableRight[nbSaisie][j] == 1) {
	            cellLabel.setBackground(Color.RED);
	            cellLabel.setText(Character.toString(mot.charAt(j)));
	        } else {
	            cellLabel.setBackground(new Color(245, 245, 220)); // Beige
	        }
	        // Contours des cellules en vert sapin
	        cellLabel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0))); // Vert sapin
	        cellLabel.setOpaque(true);
	        gameLeftPanel.add(cellLabel);
	    }
	}
}
