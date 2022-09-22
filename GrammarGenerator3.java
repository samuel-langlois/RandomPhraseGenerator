package comprehensive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

/*********************************************
 * 
 * This Class creates a HashMap from a File that is Read
 * Using a BufferReader. This Map is the Grammar for the 
 * Phrase's that can be made using the generatPhrase() which
 * creates a random phrase.
 * 
 * @author Samuel Langlois and Noah Garff
 * @version December 8, 2021
 * 
 * */
public class GrammarGenerator3 {

	private HashMap<String, ArrayList<String>> grammarMap;
	private Random rand;
	
	
	/*********************************************
	 * 
	 * This Method creates a grammarMap from a given file.
	 *  this grammarMap uses nonterminals as its keys and
	 *  assigns a production to its Associated key.
	 * 
	 * @param file - This is the given File
	 * 
	 * */
	public GrammarGenerator3(File file) throws IOException {
		grammarMap = new HashMap<String, ArrayList<String>>();
		rand = new Random();
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		//reading through the File
		while(br.ready()) {
			if(br.readLine().equals("{")) {
				
				//fining the nonterminal and using as the key for the grammarMap
				String nonTerminalKey = br.readLine();
				grammarMap.put(nonTerminalKey, new ArrayList<String>());
				String nonTerminal = nonTerminalKey;
				
				// Reading the Productions into the grammarMap using the associated nonterminal as the key
				while(!nonTerminal.equals("}")) {
					nonTerminal = br.readLine();
					if(!nonTerminal.equals("}"))
						grammarMap.get(nonTerminalKey).add(nonTerminal);
				}
			}
		}
		br.close();
	}
	
	
	/*********************************************
	 * 
	 * This method generates a random phrase using the 
	 * grammarMap to locate the next production used
	 * and stores this in a StringBuilder then returning the
	 * result.
	 * 
	 * @return phraseHolder - This contains output Random Phrase
	 * 
	 * */
	public StringBuilder generatePhrase() {
		//setting up the phrase to start
		StringBuilder phraseHolder = new StringBuilder(grammarMap.get("<start>").get(rand.nextInt(grammarMap.get("<start>").size())).toString());
		int curNTIndex = phraseHolder.indexOf("<"), 
			endNT = 0;
		String nonTerminal = "";

		while(curNTIndex != -1) {
			
			//setting the current nonterminal
			nonTerminal = phraseHolder.substring(curNTIndex, endNT = phraseHolder.indexOf(">", curNTIndex+1)+1);
			
			//getting the production list from the hashmap
			ArrayList<String> currentList = grammarMap.get(nonTerminal);
			
			//replacing the nonterminals with the production
			phraseHolder.replace(curNTIndex, endNT, currentList.get(rand.nextInt(currentList.size())));
			
			//setting up for the next nonterminal in the current phrase
			curNTIndex = phraseHolder.indexOf("<", curNTIndex);
			nonTerminal = "";
		}
		
		return phraseHolder;
	}
}
