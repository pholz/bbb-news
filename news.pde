 import java.io.*;
 import java.util.*;

 BufferedReader stream;
 PFont font;
 String txt = "";
 
 float sx, sy, w = 400.0;
 long then;
 int speed = 8;
 Rectangle monitor;
 ArrayList images;

 void setup()
 {
   images = new ArrayList();
   
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
   InputStream is = p.getInputStream();
   BufferedReader pInput = new BufferedReader(new InputStreamReader(is, "UTF-8"));
   p.waitFor();
   String pErrorLine = "";
   while( (pErrorLine = pError.readLine()) != null)
     println(pErrorLine);
     
  // println(is.getEncoding());
   String pInputLine = "";
   while( (pInputLine = pInput.readLine()) != null){
     println(pInputLine);
     txt += pInputLine + "\n";
   }
   
   Process p2 = Runtime.getRuntime().exec("python /Users/holz/Desktop/bitbybit/makingsense/exp.py", env);
   BufferedReader pImages = new BufferedReader(new InputStreamReader(p2.getInputStream(), "UTF-8"));
   
   String pImgLine = "";
   while( (pImgLine = pImages.readLine()) != null){
       images.add( loadImage(pImgLine, "jpg") );
   }
   
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
   sx = float(width)/2 - w/2;
   sy = float(height)/2 - 100.0f;
   
   then = millis();
   
   
 }

 void draw()
 {
   long now = millis();
   long dtl = now - then;
   then = now;
   float dt = (float) dtl / 1000.0f;
   
   sy -= speed*dt;
   
    background(0);
    text(txt, int(sx), int(sy), int(width), 10000);
    
    for(int i = 0; i < images.size(); i++){
       image((PImage)images.get(i), (int)sx - 110, int(sy) + i*100); 
    }
 }
