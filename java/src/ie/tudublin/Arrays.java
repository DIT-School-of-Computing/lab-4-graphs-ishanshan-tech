package ie.tudublin;

import processing.core.PApplet;



public class Arrays extends PApplet
{
	int mode = 0;
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

	float[] rainfall = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};
	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}
	
	public float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e - d;

		float howFar = a - b;
		return d + (howFar / r1) * r2;
	}

	void randomize()
	{
		for (int i = 0; i < rainfall.length; i++) {
			rainfall[i] = random(500);
		}
	}

	public void settings()
	{
		size(500, 500);

		String[] m1 = months;
		months[0] = "XXX";
		print(m1[0]);
		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : m1) {
			println(s);
		}

		int minIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] > rainfall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");
		
		
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		float avg = tot / (float) rainfall.length;

		// a b-c d-e;
		println(map1(5, 0, 10, 0, 100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26, 25, 35, 0, 100));
		// 10 


	}

	public void setup() {
		colorMode(HSB);
		background(0);
		randomize();
		
		
	}

	
	public void draw()
	{	background(0); // Clear the background
    

		switch (mode) {
			case 0:{
				bar();
				break;
			}
			case 1: {
				trend_line();
				break;
			}
			default:{
				print("Hello");
			}
			
		


	
		

		


	}
}

	private void bar(){
	background(0); // Clear the background
      strokeWeight(24);
      stroke(255);
      strokeCap(SQUARE);
      textAlign(CENTER);
      textSize(16); // Decrease text size
      for (int u = 0; u <= 120; u += 10) {
          textAlign(RIGHT);
          textSize(16); 
          text(u, 40, map(u, 0, 150, 480, 0) + 10);
      }
	  
      for(int i=0; i<12; i++) { // Changed loop condition to iterate over all 12 months
          float x = 50 + i * 35; // Adjust spacing between months, reduced from 50 to 35
          strokeWeight(5);
          stroke(255,255,0);
          line(0, 500, width, 500); // Adjusted height for line
		  
          //line(30, 0, 30, height);
          stroke(255,0,255);
          strokeWeight(20); // Reduced stroke weight for bars
          float y = map(rainfall[i], 0, 400, height, 0); // Adjusted map function for y-axis
	
          line(x, 480, x, y);
          text(months[i], x, height -10); // Adjusted position for month labels
      }
  }

  private void trend_line() {
    background(0);
    float x1 = 50; // Initial x-coordinate for the graph
    float y1 = 0; 
    for (int t = 0; t <= 120; t += 10) {
        textAlign(RIGHT);
        textSize(24);
        text(t, 40, map(t, 0, 120, height - 50, 50) + 10); // Map y-axis labels vertically
    }
    float offsetX = 50; 
    float offsetY = height - 50; 
    
    // Draw axes
    stroke(0);
    line(offsetX, offsetY, width - offsetX, offsetY); // x-axis
    line(offsetX, offsetY, offsetX, 50); // y-axis
    
    // Draw graph line
    stroke(0, 0, 255); // Set color to blue
    strokeWeight(2); // Set stroke weight for the line
    textSize(12); // Set text size
    for (int i = 0; i < 12; i++) {
        // Calculate coordinates for the current point
        float currentX = map(i, 0, rainfall.length - 1, offsetX, width - offsetX);
        float currentY = map(rainfall[i], 0, 400, offsetY, 50); // Map values to y-coordinates
        
        // Draw point
        point(currentX, currentY);
        
        textAlign(CENTER);
        fill(255); // Set text color to white
        text(months[i], currentX, offsetY + 20); // Display month names
        
        if (i > 0) {
            line(x1, y1, currentX, currentY);
        }
        
        x1 = currentX;
        y1 = currentY;
    }
}

}
  
	
		


