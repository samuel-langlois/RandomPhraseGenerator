package comprehensive;

import java.io.File;
import java.io.IOException;

public class RandomPhraseGeneratorThreader2 implements Runnable{

	private GrammarGenerator3 curClass;
	
	public RandomPhraseGeneratorThreader2(String fileName, int count) throws IOException {
		File grammerFile = null;
		try {
		grammerFile = new File(fileName);
		}catch(Exception e) {
			System.out.println("Failed");
		}
		this.curClass = new GrammarGenerator3(grammerFile);
	}

	@Override
	public void run() {
		curClass.generatePhrase();//for timer
//		System.out.println(curClass.generatePhrase());
	}

}
