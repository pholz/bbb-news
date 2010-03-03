import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.*; 
import java.awt.image.*; 
import java.awt.event.*; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class news extends PApplet {

 BufferedReader stream;
 PFont font;

static public void main(String args[]) {
  PApplet.main(new String[] { "--present", "news" });
}

 public void setup()
 {
 // stream = new BufferedReader(new FileReader("/Users/holz/Desktop/bitbybit/makingsense/news.txt")); 
  
// The font must be located in the sketch's 
// "data" directory to load successfully
   font = loadFont("ChaparralPro-Regular-16.vlw"); 
   textFont(font, 16); 
   text("word", 15, 50);
 }

 public void draw()
 {
  
 }

}
