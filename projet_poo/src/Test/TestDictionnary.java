package Test;

import controllers .*;

public class TestDictionnary {
	
	public static void main(String[] args) {
	
		String fileName = "src/Test/dictionnaire.txt"; // Provide the path to your dictionary file
        Dictionnary dictionary = new Dictionnary(fileName);
        int wordLength = 4; 
        String selectedWord = dictionary.selectRandomWord(wordLength);

        if (selectedWord != null) {
            System.out.println("Selected word: " + selectedWord);
        } else {
            System.out.println("No word of the specified length found in the dictionary.");
        }
}

}