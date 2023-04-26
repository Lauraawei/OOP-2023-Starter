package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	String[] sonnet;
	ArrayList<Word> model = new ArrayList<Word>();

	
	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}


	public void setup() {
		colorMode(HSB);
		loadFile(); 
	}

	public void keyPressed() {
		if (key == ' ') {
			sonnet = writeSonnet();
			for (String line : sonnet) 
			{
			  System.out.println(line);
			}

		  }
	}

	public String[] writeSonnet() {
		String[] sonnet = new String[14];
		for (int i = 0; i < 14; i++) {
			StringBuilder sb = new StringBuilder();
			Word word = model.get((int) random(model.size())); // pick a random starting word
			sb.append(word.getWord()); // add the starting word to the sentence
			int count = 1;
			while (count < 8 && !word.getFollows().isEmpty()) { // repeat until 8 words or no follows
				Follow follow = word.getFollows().get((int) random(word.getFollows().size())); // pick a random follow
				sb.append(" ").append(follow.getWord()); // add the follow to the sentence
				count++;
				word = findWord(follow.getWord()); // set the current word to the follow
			}
			sonnet[i] = sb.toString();
		}
		return sonnet;
	}

	public Word findWord(String word) {
		for (Word w : model) {
		  if (w.getWord().equals(word)) {
			return w;
		  }
		  
		}
		return null;
	  }	

	  public void loadFile() {
		String[] lines = loadStrings("small.txt");
		for (String line : lines) {
			String[] words = split(line, ',');
			for (String w : words) {
				w = w.replaceAll("[^\\w\\s]","");
				w = w.toLowerCase();
			}
		}
	}

	public class Follow {

		String word;
		int count;
	
		public Follow(String word, int count) {
			this.word = word;
			this.count = count;
		}
	
		public String getWord() {
			return word;
		}
	
		public int getCount() {
			return count;
		}
	
		public String toString() {
			return word + " (" + count + ")";
		}
	}

	public class Word {

		String word;
		ArrayList<Follow> follows;

		public Word(String word, ArrayList<Follow> follows) {
			this.word = word;
			this.follows = follows;
		}
	
		public String getWord() {
			return word;
		}
	
		public ArrayList<Follow> getFollows() {
			return follows;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(word).append(": [");
			for (Follow follow : follows) {
				sb.append(follow.toString()).append(", ");
			}
			if (!follows.isEmpty()) {
				sb.setLength(sb.length() - 2);
			}
			sb.append("]");
			return sb.toString();
		}
		
		
	//float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
		String[] sonnet = writeSonnet();
    for (int i = 0; i < sonnet.length; i++) {
        text(sonnet[i], width/2, height/14*(i+1));
    }
        
	}

	public void printModel() {
		for (Word word : model) {
			System.out.print(word.getWord() + ": ");
			for (Follow follow : word.getFollows()) {
				System.out.print(follow.getWord() + "(" + follow.getCount() + ") ");
			}
			System.out.println();
		}
	}

}

public static void main(String[] args) {
	PApplet.main("ie.tudublin.DANI");
}
	
}
