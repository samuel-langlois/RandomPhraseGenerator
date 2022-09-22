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
public class RandomPhraseGenerator4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//gets the file for the Grammar of the random phrase
		
		
		// Constructs the Grammar Class
		
		RandomPhraseGeneratorThreader2 thread = new RandomPhraseGeneratorThreader2(args[0], Integer.parseInt(args[1])); 
		Integer treaderCount = Integer.parseInt(args[1]) / 2;
		if (Integer.parseInt(args[1]) >= 30) {
		Thread[] t = new Thread[3];
		t[0] = new Thread(thread);
		t[1] = new Thread(thread);
		t[2] = new Thread(thread);
		int remander = Integer.parseInt(args[1])%3;
		for(int i = Integer.parseInt(args[1]); i > remander ;i-=3) {
		t[0].run();
		t[1].run();
		t[2].run();
		}
		if(remander == 1) {
			t[0].run();
		}
		else {
			t[0].run();
			t[1].run();
		}
		}
		else if(Integer.parseInt(args[1]) >= 20) {
			Thread[] t = new Thread[2];
			t[0] = new Thread(thread);
			t[1] = new Thread(thread);
			int remander = Integer.parseInt(args[1])%2;
			for(int i = Integer.parseInt(args[1]); i > remander ;i-=2) {
			t[0].run();
			t[1].run();
			}
			if(remander == 1) {
				t[0].run();
			}
		}
		else {
			Thread t = new Thread(thread);
			for(int i = Integer.parseInt(args[1]); i > 0 ;i--) {
			t.run();
			}
			
		}
		
//		if((Integer.parseInt(args[1]) / 2) + (Integer.parseInt(args[1]) / 2) == Integer.parseInt(args[1])) {
//		t = new Thread[treaderCount];
//		for(int i = 0; i < Integer.parseInt(args[1]) ;i++) {
//			t[i] = new Thread(thread);
//			t[i].run();
//			
//		}
//		
//		}
//		else {
//			
//		}
		
		
			
//		GrammarGenerator grammarClass = new GrammarGenerator(grammerFile);
//		
//		//looping though to create random phrases
//		for(int i = Integer.parseInt(args[1]); i>0 ;i--) {
////			if(i != 1)
////				System.out.println(grammarClass.generatePhrase());
////			else
////				System.out.print(grammarClass.generatePhrase());//so there is not an extra line at the end
//			
//			grammarClass.generatePhrase(); //this is use for timer
			
//		}
		
	}
}
