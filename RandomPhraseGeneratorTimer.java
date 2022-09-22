package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*********************************************
 * 
 * This Class creates a Random Phrase from a file a
 * Specified amount of times.
 * 
 * @author Samuel Langlois and Noah Garff
 * @version December 8, 2021
 * 
 * */
public class RandomPhraseGeneratorTimer {

	public static void main(String[] args) throws IOException, InterruptedException {
		GrammarWriter aThing = new GrammarWriter(5, 5, 1);
		
		
		File grammerFile = null;
		try {
		grammerFile = aThing.getFile();
		}catch(Exception e) {
			System.out.println("Failed");
		}
		GrammarGenerator grammarClass = new GrammarGenerator(grammerFile);
		for(int i = 5; i>0 ;i--) {
			if(i != 1)
				System.out.println(grammarClass.generatePhrase());
			else
				System.out.print(grammarClass.generatePhrase());
//			grammarClass.generatePhrase(); //this is use for timer
			
		}
		
	}
}
