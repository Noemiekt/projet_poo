package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionnary {
	
	
    static public List<String> dictionary =new ArrayList<>(); // Liste stockant les mots du dictionnaire 
    public static Random random = new Random();; // génerateur de nombres aléatoire 

    // Constructeur de la classe Dictionary : le param : chemin vers le fichier dictionnaire  
    public Dictionnary(String fileName) {
    	loadWordsFromFile(fileName);
    }
    
    // Lire les mots à parti du fichier dictonnaire.txt
    public void loadWordsFromFile(String fileName) {
    	try {
    		// Créer un BufferedReader pour lire les mots à partir du fichier
    		BufferedReader reader = new BufferedReader(new FileReader(fileName));
    		String line;
    		
    		// Lit chaque ligne du fichier et ajoute le mot au dictionnaire 
    	    while ((line = reader.readLine()) != null) {
    	        dictionary.add(line);
    	    }
    	    reader.close();
    	}
    	catch (IOException e) {
    	    	 e.printStackTrace(); 
    	}	
    }
    

    // Méthode sélectionnant aléatoirement un mot à partir du dictionnaire
    static public String selectRandomWord(int wordLength) {
    	List<String> matchingWords = new ArrayList<>();
    	// on parcourt chaque mot de dictionnary 
        for (String word : dictionary) {
            if (word.length() == wordLength) {
                matchingWords.add(word);
            }
        }

        if (matchingWords.isEmpty()) {
            return null; // No word of the specified length found in the dictionary.
        }
        // Chosir un mot au hasard 
        int randomIndex = random.nextInt(matchingWords.size());
        return matchingWords.get(randomIndex);
    		
    }   	
}

	
	


