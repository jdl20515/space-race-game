import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class spaceRaceRunner extends JPanel  implements KeyListener

{
    
    /**************************************************************
     * 
     *  Define all variales in this section
     * 
     * ************************************************************/

    private boolean firstTime = true;
    
    

    private int yMax, xMax;
    
    private Timer t;
    
    private spaceShipImage myShip1;
    private spaceShipImage myShip2;
    private debris myDebris;
    private debris[] myDebrisArray = new debris[5];
    private timer myTimer;

    

    
    public boolean leftUp = false;
    public boolean leftDown = false;
    public boolean rightUp = false;
    public boolean rightDown = false;
    
    private int score1 = 0;
    private int score2 = 0;
    private int startX=50, startY = 50, speed = 2,  size = 10, red = 0, blue  = 0, green = 0;
    private Color myColor;


    private boolean threeCycle = false; 
    private int threecycleCount = 0;
    private int debrisCount;

    


  
public spaceRaceRunner ()
{
    this.setFocusable(true);
    this.addKeyListener(this);
}


public void start_timer()
{
      t = new Timer(10, new Listener());
      t.start();
}

 
public void paintComponent (Graphics g)
{
      Graphics2D g2 = (Graphics2D) g; 
        
        
        
      if (firstTime)
      {
      xMax = getWidth();
      yMax = getHeight();
      
      myShip1 = new spaceShipImage(xMax, yMax, 100, 250);
      myShip2 = new spaceShipImage(xMax, yMax, 200, 250);
      myTimer = new timer();

 
   
     for (int i = 0; i < myDebrisArray.length; i++)
        {
            startX = (int) (Math. random() * xMax + 0);
            startY = (int) (Math. random() * yMax + 0);
            speed = (int) (Math. random() * 10 + 1);
            size = (int) (Math. random() * 20 + 1);
            red= (int) (Math. random() * 255+ 0);
            green = (int) (Math. random() * 255+ 0);
            blue = (int) (Math. random() * 255+ 0);
            myColor = new Color(red, green, blue);
            myDebrisArray[i] = new debris (xMax, yMax, startX, startY, speed, size,myColor);
        }
    myDebrisArray[0].setShow();

    
      firstTime= false;
      }
      
      
     
      setBackground(Color.black);
      super.paintComponent(g);
      
     for (int i = 0; i < myDebrisArray.length; i++)
      {
      myDebrisArray[i].moveDebris(g);
      }


        
      myShip1.draw(g, leftUp, leftDown);
      myShip2.draw(g, rightUp, rightDown);
      myTimer.drawRectangle(g, t);
     
        Font font = new Font("Impact", Font.BOLD, 40);
        g2.setFont(font);
        g2.setColor(Color.white);
        g2.drawString(Integer.toString(myShip1.getScore()), 50, 300);
        g2.drawString(Integer.toString(myShip2.getScore()), 250, 300);

    
    
    testCollision();
    testCollision2();
    threeCycle = myTimer.getCycle();
    if (threeCycle)
      {
          threecycleCount ++;
      }

     if (threecycleCount >= 3)
      {
          threeCycle = false;
          threecycleCount = 0;			    
          debrisCount++;                          
          myDebrisArray[debrisCount].setShow();
          			
      }


}



   
   
   
private void testCollision()
   {
       for(int i = 0; i < myDebrisArray.length; i++)
       {
        
        if (myDebrisArray[i].getShow() && myDebrisArray[i].getDebrisX() + myDebrisArray[i].getDebrisSize()
        > myShip1.getSpaceShipX() &&
       
        myDebrisArray[i].getDebrisX() < myShip1.getSpaceShipX() 
         + myShip1.getSpaceShipSize() &&
   
        myDebrisArray[i].getDebrisY() + myDebrisArray[i].getDebrisSize() >
        myShip1.getSpaceShipY())
        {
          myShip1.returnSpaceShip();
           
        }
       }
   }

private void testCollision2()
   {
       for(int i = 0; i < myDebrisArray.length; i++)
       {
        if (myDebrisArray[i].getShow() && myDebrisArray[i].getDebrisX() + myDebrisArray[i].getDebrisSize()
        > myShip2.getSpaceShipX() &&
       
        myDebrisArray[i].getDebrisX() < myShip2.getSpaceShipX() 
         + myShip2.getSpaceShipSize() &&
   
        myDebrisArray[i].getDebrisY() + myDebrisArray[i].getDebrisSize() >
        myShip2.getSpaceShipY())
        {
          myShip2.returnSpaceShip();
           
        }
       }
   }



private class Listener implements ActionListener
{
  public void actionPerformed(ActionEvent e)
  {
     repaint();//paintImmediately(0, 0, getWidth(), getHeight());
  }
}
   

@Override
public void keyTyped(KeyEvent e) {}
                    
@Override
public void keyReleased(KeyEvent e) 
{
int keyCode = e.getKeyCode();
      	switch( keyCode ) 
{ 
          case KeyEvent.VK_W:
            leftUp = false;
            break;
         case KeyEvent.VK_S:
            leftDown = false;
            break;
         case KeyEvent.VK_UP:
            rightUp = false;
            break;   
         case KeyEvent.VK_DOWN:
            rightDown = false;
            break;   
            
         }
  }

@Override
public void keyPressed(KeyEvent e) 
{     
      int keyCode = e.getKeyCode();
      switch( keyCode ) 
{ 
         case KeyEvent.VK_W:
             leftUp = true;
            break;
         case KeyEvent.VK_S:
            leftDown = true;
            break;
         case KeyEvent.VK_UP:
            rightUp = true;
            break;   
         case KeyEvent.VK_DOWN:
            rightDown = true;
            break;   
            
      }
    }

}