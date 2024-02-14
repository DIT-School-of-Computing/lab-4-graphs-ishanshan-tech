package ie.tudublin;
import processing.core.PApplet;
public class graph extends PApplet{
    float x = 50; // Initial x-coordinate for the graph
    float y = 0; // Initial y-coordinate for the graph
    float[] values = {50, 220, 70, 110, 200, 400, 50, 220, 70, 110, 200, 400};
    String[] fruit = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Nov", "Dec"};
    public void settings()
    {
        size(800, 400);
    }
    public void draw()
    {
        float offsetX = 50; // Offset from the left side of the canvas
        float offsetY = height - 50; // Offset from the bottom of the canvas
        
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
          
          // Draw label for the fruit
          textAlign(CENTER);
          fill(0);
          text(fruit[i], currentX, offsetY + 20);
          
          // Draw lines connecting the points
          if (i > 0) {
            line(x, y, currentX, currentY);
          }
          
          // Update coordinates for the next point
          x = currentX;
          y = currentY;
        }
    }
}
