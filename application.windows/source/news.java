import processing.core.*; 
import processing.xml.*; 

import java.io.*; 

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
 String txt = "";
 
 float sx, sy, w = 400.0f;
 long then;
 int speed = 8;
 Rectangle monitor;

 public void setup()
 {
   GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
          GraphicsDevice devices[] = environment.getScreenDevices();
   GraphicsDevice gd = devices[0];
   GraphicsConfiguration[] gc = gd.getConfigurations();
   monitor = gc[0].getBounds();
   size(monitor.width, monitor.height);
  
   println(monitor.x + " " + monitor.y + " " + monitor.width + " " + monitor.height);

   
   try{
     String[] env = {"PYTHONPATH=/Library/Frameworks/Python.framework/Versions/2.6/lib/python2.6/site-packages/"};
   Process p = Runtime.getRuntime().exec("python /Users/holz/Desktop/bitbybit/makingsense/msapp.py", env);
   BufferedReader pError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
   BufferedReader pInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
   p.waitFor();
   String pErrorLine = "";
   while( (pErrorLine = pError.readLine()) != null)
     println(pErrorLine);
     
   
   String pInputLine = "";
   while( (pInputLine = pInput.readLine()) != null)
     txt += pInputLine + "\n";
   
 //  stream = new BufferedReader(new FileReader("/Users/holz/Desktop/bitbybit/makingsense/news.txt")); 
   } catch(Exception e) {println(e.toString());}

   font = loadFont("ChaparralPro-Regular-16.vlw"); 
   textFont(font, 16); 
   
   String curline = "";
   /*
   try{
   while( (curline = stream.readLine() ) != null)
     txt += curline + "\n";
   } catch(Exception e) {println(e);}
     
     */
   sx = PApplet.parseFloat(width)/2 - w/2;
   sy = PApplet.parseFloat(height)/2 - 100.0f;
   
   then = millis();
 }

 public void draw()
 {
   long now = millis();
   long dtl = now - then;
   then = now;
   float dt = (float) dtl / 1000.0f;
   
   sy -= speed*dt;
   
  background(0);
  text(txt, PApplet.parseInt(sx), PApplet.parseInt(sy), PApplet.parseInt(width), 10000);
 }

  static public void main(String args[]) {
    PApplet.main(new String[] { "--present", "--bgcolor=#666666", "--stop-color=#cccccc", "news" });
  }
}
