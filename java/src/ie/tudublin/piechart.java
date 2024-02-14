package ie.tudublin;

import processing.core.PApplet;

public class piechart extends PApplet{

    float[] values = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};
    String[] fruit = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Nov", "Dec"};
    int[] angles = { 30, 10, 45, 35, 60, 38, 75, 67 };
    public void settings() {
        size(640, 360);
        noStroke();
        noLoop();  //use this to prevnt the loop from happening again and again
      }
      public void draw() {
        background(100);
        pieChart(300, angles);
      }
      
      void pieChart(float diameter, int[] data) {
        float lastAngle = 0;
        for (int i = 0; i < data.length; i++) {
            
          
          fill(random(0,255),random(0,255),random(0,255));
          arc(width/2, height/2, diameter, diameter, lastAngle, lastAngle+radians(data[i]));
          lastAngle += radians(data[i]);
            
        }
      }
    
}
