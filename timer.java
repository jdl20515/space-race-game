import javax.swing.*;
import java.awt.*;
public class timer
{
        private int startX = 165;
        private int startY = 100;
        private int width = 15;
        private int height = 200;
        private Rectangle timer;
        private int shrink = 1;
        private int max = 20;
        private int count = 0;
        private int cycles = 0;
        private boolean threeCycles = false;
        


public boolean getCycle()
{
    if (threeCycles)
    {
        threeCycles = false;
        return true;
    }
    return false;
}



public timer()
{
timer = new Rectangle(startX, startY, width, height);

} 

public void drawRectangle(Graphics g, Timer t)
{
   Graphics2D g2 = (Graphics2D) g; 
   g2.setColor(Color.red);
  
   if(count>=max)
   {
    timer.y = timer.y + shrink;
    timer.height = timer.height - shrink;
    count = 0;
    cycles++;
   }
    if (cycles >=9)
   {
       threeCycles = true;
       cycles = 0;
   }

   count++;
  
   g2.fill(timer);
   if(timer.height <= 0)
   {
       Font font = new Font("Impact", Font.BOLD, 30);
        g2.setFont(font);
        g2.setColor(Color.red);
        g2.drawString(("Time is up! Game over!"), 10, 100);
   }
   
  }



}