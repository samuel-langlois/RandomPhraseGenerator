package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;
import comprehensiveOld.*;
import comprehensive_why_delete.RandomPhraseGeneratorNoObject;

/**
 * @author Samuel Langlois and Noah Garff
 * @version December 8, 2021
 **/
public class RandomPhraseGeneratorTiming {
	private static  Random rand = new Random();
	private static ArrayList<String> nameQueue;

	public static void main(String[] args) throws IOException, InterruptedException {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		File nameTextFile = new File("src/assign09/Random-Names.txt");
		
		// Do 10000 lookups and use the average running time.
		int timesToLoop = 10;
		for (int n = 1000; n <= 20000; n += 1000) {
			GrammarWriter grammarWriter = new GrammarWriter(n/100, 1, 1);
			String[] newArgs = {"src/comprehensive/Timer_File.txt", "1", ""};
			
			int k = n/23;
			long startTime, midpointTime, stopTime;
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) {

			}
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) {

			}
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) {

			}
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) {

			}

			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++) {
				
			}

			midpointTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++) {
				for(int j=n; 0 < j ;j--)
				RandomPhraseGenerator.main(newArgs);
				
			}

			stopTime = System.nanoTime();

			double notObjectTime = (stopTime - midpointTime) / (double) timesToLoop;
//			double objectTime = (stopTime - midpointTime) / (double) timesToLoop;

			
			
			
			
			
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) {

			}
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) {

			}
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) {

			}
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) {

			}

			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++) {
				
				
			}

			midpointTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++) {
				for(int j=n; 0 < j ;j--)
					RandomPhraseGeneratorObject.main(newArgs);
			}

			stopTime = System.nanoTime();

//			double notObjectTime = (midpointTime - startTime) / (double) timesToLoop;
			double objectTime = (stopTime - midpointTime) / (double) timesToLoop;
			System.out.println(n + "\t   " + notObjectTime + "\t   " +  
									  n + "\t   " + objectTime + "\t   ");
		}
	}

		private static List<Integer> randomIntegerList(int n) {
			List<Integer> tempList = new ArrayList<Integer>();
			for(int i = 0; i < n ;i++)
				tempList.add(randomUID());
			return tempList;
		}

		private static int randomUID() {
			int randInt = rand.nextInt(1001);
//			String randUID = "";
//			for (int i = 0; i < 3; i++) {
//				randUID += rand.nextInt(10);
//			}
//			return randInt = Integer.parseInt(randUID);
			return randInt;
		}

		private static String randomName() {
			int index = rand.nextInt(nameQueue.size());
			return nameQueue.get(index);
		}


}