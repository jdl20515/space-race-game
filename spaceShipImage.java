import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class spaceShipImage   {
        private URL imgSpaceShip;
        private BufferedImage image;
        
        private int xMax;
        private int yMax;
        private int startX ;
        private int startY ;
        private int imageSize = 40;
        private int speed = 2;
        private int score = 0;
        
        
 
   public spaceShipImage(int xm, int ym, int sx, int sy)
   
   {
      xMax=xm;
      yMax=ym;
      startX = sx;
      startY = yMax-imageSize;
     
      try
      {

          imgSpaceShip= new URL("https://codehs.com/uploads/7b9bf6755ffac965340c94e2a38b6fe2");
         image = ImageIO.read(imgSpaceShip);
      } 
      catch (IOException e)
      {
          System.out.println("Not able to open file apple ");
      }
   }
   
   
   public int getScore()
   {
       return score;
   }
   
   public int getSpaceShipX()
   {
       return startX;
   }
  
   public int getSpaceShipSize()
   {
       return imageSize;
   }
   
   public int getSpaceShipY()
   {
       return startY;
   }
   
   public void returnSpaceShip()
   {
       startY = 280;
   }
   
   public void draw(Graphics g, boolean up, boolean down)
   {
       Graphics2D g2 = (Graphics2D) g;
       
        if(up)
     {
         startY -= speed;
          if (startY + imageSize < 0)
         {
             score ++;
             startY = 310;
         }
     }
     
        if(down)
     {
         if(startY < 305 - imageSize)
         {
             startY += speed;
         }

     }
       
         g2.drawImage(image, startX, startY, imageSize, imageSize, null);
          
   }
   
    
}