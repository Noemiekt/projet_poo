package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionnary {
	
    static public List<String> dictionary =new ArrayList<>(); 
    public static Random random = new Random();; 

    public Dictionnary(String fileName) {
    	loadWordsFromFile(fileName);
    }
    
  
    public void loadWordsFromFile(String fileName) {
    	try {
    		BufferedReader reader = new BufferedReader(new FileReader(fileName));
    		String line;
    		
    	    while ((line = reader.readLine()) != null) {
    	        dictionary.add(line);
    	    }
    	    reader.close();
    	}
    	catch (IOException e) {
    	    	 e.printStackTrace(); 
    	}	
    }
    
    public String selectRandomWord(int wordLength) {
    	List<String> matchingWords = new ArrayList<>();
        for (String word : dictionary) {
            if (word.length() == wordLength) {
                matchingWords.add(word);
            }
        }

        if (matchingWords.isEmpty()) {
            return null; 
        }
        int randomIndex = random.nextInt(matchingWords.size());
        return matchingWords.get(randomIndex);
    		
    }   	
}

	
	


