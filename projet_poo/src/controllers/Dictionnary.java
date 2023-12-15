package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionnary {
	
    static public List<String> frenchdictionary =new ArrayList<>(); 
    static public List<String> englishdictionary =new ArrayList<>(); 
    static public List<String> spanishdictionary =new ArrayList<>(); 
    static public List<String> germandictionary =new ArrayList<>();
    
    public static Random random = new Random();

    

    public static void initDictionnary() {
    	loadWordsFromFile("res/dictionary/frenchDictionary.txt",frenchdictionary);
    	loadWordsFromFile("res/dictionary/englishDictionary.txt",englishdictionary);
    	loadWordsFromFile("res/dictionary/spanishDictionary.txt",spanishdictionary);
    	loadWordsFromFile("res/dictionary/germanDictionary.txt",germandictionary);
    }
    
  
    public static void loadWordsFromFile(String fileName, List<String> dictionary) {
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
    
    public static String selectRandomWord(int wordLength, int indLang) {
    	List<String> matchingWords = new ArrayList<>();
    	
    	List<String> dictionary;
    	
    	switch (indLang) {
        case 0:
        	dictionary=frenchdictionary;
            break;
        case 1:
        	dictionary=englishdictionary;
            break;
        case 2:
        	dictionary=spanishdictionary;
            break;
        case 3:
        	dictionary=germandictionary;
            break;
  
        default:
        	dictionary=frenchdictionary;
            break;
    }
    	
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

	
	


