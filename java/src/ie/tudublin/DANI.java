package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class DANI extends PApplet {

	

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

    String[] sonnet;

    public String[] writeSonnet()
    {
        return null;
    }

	public void setup() {
		colorMode(HSB);
         
       
	}

	public void keyPressed() {

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

		



	float off = 0;

	public void draw() 
    {
		background(0);
		fill(255);
		noStroke();
		textSize(20);
        textAlign(CENTER, CENTER);
        
	}


}

