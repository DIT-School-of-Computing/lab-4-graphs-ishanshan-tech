package ie.tudublin;
import processing.core.PApplet;
public class graph extends PApplet{
    float x = 50; // Initial x-coordinate for the graph
    float y = 0; // Initial y-coordinate for the graph
    float[] values = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};
    String[] fruit = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Nov", "Dec"};
    public void settings()
    {
        size(800, 400);
    }
    public void draw()
    {
        background(255); // Clear the background to white
        for (int u = 0; u <= 120; u += 10) {
            textAlign(RIGHT);
            textSize(24);
            text(u, 40, map(u, 0, 120, height - 50, 50) + 10); // Map y-axis labels vertically
        }
        float offsetX = 50; 
        float offsetY = height - 50; 
        
        // Draw axes
        stroke(0);
        line(offsetX, offsetY, width - offsetX, offsetY); // x-axis
        line(offsetX, offsetY, offsetX, 50); // y-axis
        
        // Draw graph line
        stroke(0, 0, 255); // Set color to blue
        textSize(12); // Set text size
        for (int i = 0; i < 11; i++) {
          // Calculate coordinates for the current point
          float currentX = map(i, 0, values.length - 1, offsetX, width - offsetX);
          float currentY = map(values[i], 0, 400, offsetY, 50); // Map values to y-coordinates
          
          // Draw point
          point(currentX, currentY);
          

          textAlign(CENTER);
          fill(0);
          text(fruit[i], currentX, offsetY + 20);
          

          if (i > 0) {
            line(x, y, currentX, currentY);
          }
          
         
          x = currentX;
          y = currentY;
        }
    }
}
