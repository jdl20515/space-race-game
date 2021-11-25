import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class debris   
{
       
        
    private int xMax;
    private int yMax;
    private int startX;
    private int startY;
    private int speed;
    private Color color;
    private int size;
    private int xDirection = 1;
    private boolean show = false;
    private int count = 0;


   

    public debris (int xm, int ym, int sx, int sy, int sp, int si, Color c)
    {
        xMax = xm;
        yMax = ym;
        startX = startX = (int) (Math. random() * xMax + 0);
        startY = startY = (int) (Math. random() * yMax + 0);
        speed = speed = (int) (Math. random() * 10 + 1);
        size = (int) (Math. random() * 20 + 1);
        color = c;
    
    }
    
    public int getDebrisX()
    {
        return startX;
    }
    
    public int getDebrisY()
    {
        return startY;
    }

    public int getDebrisSize()
    {
        return size;
    }
    
    public void setShow()
    {
        show = true;
    }
    
     public boolean getShow()
    {
        return show;
    }
    
    public void moveDebris(Graphics g)
    {
        
   
        if(show)
        {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(color);
            g2.fillOval(startX,startY,size, size);
            count++;
            if(count>3){
                startX += speed * xDirection;
                count = 0;
            }
            
            
        } 
            if (startX + size > xMax)
            {
                xDirection = -1;
                
            }
            
            
            if (startX < 0)
            {
                xDirection = 1;
            }
        }
    }