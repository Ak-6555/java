
package breakBangProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements KeyListener,ActionListener {
 
    private boolean play=false;
    private int score=0;
    private int totalBricks=21;
    private Timer timer;
    private int delay =8;
    
    private int playerX=310;
    private int ballposX=120;
    private int ballposY=350;
    private int ballxdir=-1;
    private int ballydir=-2;
    private MapGenerator map;
   // private final Timer timer;
    
    public Gameplay()
    {
        map=new MapGenerator(3,7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
    }
    public void paint(Graphics g)
    {     
        //background
        g.setColor(Color.BLACK);
        g.fillRect(1,1, 692,592);
        
        //drawingmap
        map.draw((Graphics2D)g);
        
           //border
        g.setColor(Color.green);
        g.fillRect(0,0,3, 592);
        g.fillRect(0,0,692, 3);
        g.fillRect(691,0,3, 592);
       
             //paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 538, 100, 25);
             //px,558,100,8
        
             ///ball
        g.setColor(Color.red);
        g.fillOval(ballposX,ballposY,20,20);
        g.dispose();
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       if(e.getKeyCode()==KeyEvent.VK_RIGHT)
       { if(playerX>=600)
            playerX=600;
          else
           moveRight();
       }
       if(e.getKeyCode()==KeyEvent.VK_LEFT)
       {
          if(playerX<10)
              playerX=10;
          else
              moveLeft();
                     
       }
  
    }
public void moveRight()
{
    play=true;
    playerX=playerX+20;
    
}
public void moveLeft()
{
    play=true;
    playerX=playerX-20;
    
}
    
    
    
    
    @Override
    public void keyReleased(KeyEvent e) {
      
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e)
    {
        repaint();
        timer.start();
        if(play)
        {   
            if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8)))
            {
                ballydir=ballydir-ballydir;
                
            }
            
            
            ballposX=ballposX+ballxdir;
            ballposY=ballposY+ballydir;
            if(ballposX < 0)
            {
              ballxdir= ballxdir-ballxdir;
             
            }
            if(ballposY < 0)
            {
              ballydir= ballydir-ballydir;
             
            }
            if(ballposX < 670)
            {
              ballxdir= ballxdir-ballxdir;
             
            }
            
            
            
        }
        
        
    }
}
    
    
    


        
