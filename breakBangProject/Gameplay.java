
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
    private Timer timer;
    private int delay =8;
    
    private int playerX=310;
    private int ballposX=120;
    private int ballposY=350;
    private int ballxdir=-1;
    private int ballydir=-2;
    private MapGenerator map;
   //new
    private int totalbrick=21;
    private int score =0;
    private Font f,f2;
    
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
	    
	   //new   //score 
        g.setColor(Color.white);
        f= new Font("Arial", Font.BOLD, 14); 
        g.setFont(f);
        g.drawString("Your Score: "+score,510,30);
        if(ballposY>570)
        {
           play = false;
           ballxdir=0;
           ballydir=0;
           g.setColor(Color.white);
           f2= new Font("Arial",Font.BOLD,26);
           g.setFont(f2);
           g.drawString("Game Over! ", 250, 300);
        }
           
        
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
                ballydir = (ballydir * -1);
                
            }
		//new
           A:for (int i = 0; i < map.map.length; i++) { 
                for (int j = 0; j <map.map[0].length; j++) {
                    if(map.map[i][j]>0)
                    {
                     int brickX=j*map.brickwidth+80;
                     int brickY=i*map.brickheight+50;
                     int brickwidth=map.brickwidth;
                     int brickheight=map.brickheight;
                     
                        
                    Rectangle rect = new Rectangle(brickX,brickY,brickwidth,brickheight);
                    Rectangle ballrect = new Rectangle(ballposX,ballposY,20,20);
                    Rectangle brickrect =rect;
                    if(ballrect.intersects(brickrect))
                    {
                        map.setBrickValue(0, i, j);
                        totalbrick++;
                        score=score+10;
                        
                        if(ballposX+19<=brickrect.x||ballposX+1>=brickrect.x+brickrect.width)
                        {
                            ballxdir= -ballxdir;
                        }
                        else{
                            ballydir= -ballydir;
                          }
                        break A;
                      }
                     
                    }
                    
                }
                
            }

			ballposX = ballposX + ballxdir;
			ballposY = ballposY + ballydir;
            System.out.println(ballposX + " " + ballposY + " " + ballxdir + " " + ballydir);
            if(ballposX < 0)
            {
//              ballxdir= ballxdir-ballxdir;
              ballxdir = (ballxdir * -1);
             
            }
            if(ballposY < 0)
            {
//              ballydir= ballydir-ballydir;
              ballydir = (ballydir * -1);
             
            }
            if(ballposX > 670)
            {
              ballxdir = (ballxdir * -1); 
            }
           
            
            
        }
        
        
    }
}
    
    
    


        
