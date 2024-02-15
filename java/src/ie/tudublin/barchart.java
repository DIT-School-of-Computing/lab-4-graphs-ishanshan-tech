package ie.tudublin;

import processing.core.PApplet;
public class barchart  extends PApplet{
    float x =50;
    float y=200;
 
    float[] values = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};
    String[] month = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
   
    public void settings()
	{
        size(500,500);
  
        
    }


  
    public void draw() {
      background(0); // Clear the background
      strokeWeight(24);
      stroke(255);
      strokeCap(SQUARE);
      textAlign(CENTER);
      textSize(16); // Decrease text size
      for (int u = 0; u <= 120; u += 10) {
          textAlign(RIGHT);
          textSize(16); // Decrease text size
          text(u, 40, map(u, 0, 150, 480, 0) + 10);
      }
      for(int i=0; i<12; i++) { // Changed loop condition to iterate over all 12 months
          float x = 50 + i * 35; // Adjust spacing between months, reduced from 50 to 35
          strokeWeight(5);
          stroke(255,255,0);
          line(0, height, width, height); // Adjusted height for line
          line(40, 0, 40, height);
          stroke(255,0,255);
          strokeWeight(20); // Reduced stroke weight for bars
          float y = map(values[i], 0, 400, height, 0); // Adjusted map function for y-axis
          line(x, height, x, y);
          text(month[i], x, height + 20); // Adjusted position for month labels
      }
  }
  

    
}
