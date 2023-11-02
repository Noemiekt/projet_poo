package Test;

import controllers .*;

public class TestDictionnary {
	
	public static void main(String[] args) {
	
		String fileName = "/Users/sallmonearmela/Documents/2A/Projet_POO/projet_poo/projet_poo/src/Test/dictionnaire.txt"; // Provide the path to your dictionary file
        Dictionnary dictionary = new Dictionnary(fileName);
        int wordLength = 7; 
        String selectedWord = dictionary.selectRandomWord(wordLength);

        if (selectedWord != null) {
            System.out.println("Selected word: " + selectedWord);
        } else {
            System.out.println("No word of the specified length found in the dictionary.");
        }
}

}