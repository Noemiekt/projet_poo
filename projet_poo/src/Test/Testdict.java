package Test;

import controllers.Dictionnary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Testdict extends JFrame {
    private static final long serialVersionUID = 1L;
	private Dictionnary dictionary;
    private JTextField wordLengthInput;
    private JButton selectWordButton;

    public Testdict(String fileName) {
        dictionary = new Dictionnary(fileName);

        setTitle("Word Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        wordLengthInput = new JTextField(10);
        selectWordButton = new JButton("Select Word");

        selectWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wordLength = Integer.parseInt(wordLengthInput.getText());
                String selectedWord = dictionary.selectRandomWord(wordLength);

                if (selectedWord != null) {
                    JOptionPane.showMessageDialog(null, "Selected word: " + selectedWord);
                } else {
                    JOptionPane.showMessageDialog(null, "No word of the specified length found in the dictionary.");
                }
            }
        });

        add(new JLabel("Enter word length:"));
        add(wordLengthInput);
        add(selectWordButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String fileName = "/Users/sallmonearmela/Documents/2A/Projet_POO/projet_poo/projet_poo/src/Test/dictionnaire.txt"; // Provide the path to your dictionary file
            new Testdict(fileName);
        });
    }
}
