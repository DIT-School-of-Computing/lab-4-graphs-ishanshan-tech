package ie.tudublin;

import processing.core.PApplet;
public class barchart  extends PApplet{
    float x =50;
    float y=200;
    
    float[] values = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};
    String[] month = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
   
    public void settings()
	{
        size(800,640);
  
        
    }



    public void draw()
	{
        background(0);
        strokeWeight(24);
        stroke(255);
        strokeCap(SQUARE);
        textAlign(CENTER);
        textSize(24);
        for (int u = 0; u <= 120; u += 10) {
            textAlign(RIGHT);
            textSize(24);
            text(u, 40, map(u, 0, 150, 480, 0) + 10);
           
          }
        for(int i=0; i<11; i++) {
          float x = 80 + i * 50; // Adjust spacing between months
          strokeWeight(5);
          stroke(255,255,0);
          line(0, 500, 640, 500);
         
           
         
          
          line(50, 0, 50, 500);
          stroke(255,0,255);
          strokeWeight(40);
          float y = map(values[i], 0, 400, 500, height/2); 
       
          line(x, 500, x, y);
          
          text(month[i], x, 540);
        }

    }


    
}
