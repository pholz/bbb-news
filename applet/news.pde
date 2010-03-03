 BufferedReader stream;
 PFont font;

static public void main(String args[]) {
  PApplet.main(new String[] { "--present", "news" });
}

 void setup()
 {
 // stream = new BufferedReader(new FileReader("/Users/holz/Desktop/bitbybit/makingsense/news.txt")); 
  
// The font must be located in the sketch's 
// "data" directory to load successfully
   font = loadFont("ChaparralPro-Regular-16.vlw"); 
   textFont(font, 16); 
   text("word", 15, 50);
 }

 void draw()
 {
  
 }
