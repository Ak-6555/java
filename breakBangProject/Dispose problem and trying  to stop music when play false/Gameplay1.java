package DemoGameLavelTwo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;



public class Gameplay1 extends JPanel implements KeyListener, ActionListener {
        
    
        private boolean play = false;
	private Timer timer;
	private int delay = 8;
	private int playerX = 310;
	private int ballposX = 350;
	private int ballposY = 617;
	private int ballxdir = -1;
	private int ballydir = -2;
	private MapGenerator1  mapob;
        
	//new
	
	private Font f, f2;
        
        
        private int totalbrick = 32;
	//second ball
	private boolean isSecondBallAppear = false;
	private int secondBallPosX = 1050;
	private int secondBallPosY = 500;
	private int secondBallDirX = -2;
	private int secondBallDirY = -2;
	private int secondBallStartBrick = 24;

	//bounsbutton
        private int bonusAY=-100;
        private int bonusBY=-100;
        private int bonusCY=-100;
        private int cnt1=0;
        private int cnt2=0;
        private int cnt3=0;
        
        //life
        private int lifeposY=-200;
        public static int life=0;
        
        //score
        public static int score = 0;
       
	
        //new 
        private static int playerSpeed = 20;
	private static int playerWidth = 100;

	// win
	private boolean isWin = false;
	private String winMessage = "You Win!";
	private String gameOverMessage = "Game Over!";

	public Gameplay1() 
        {
		 mapob = new MapGenerator1(4, 8);
           
                 playMusic("Music\\\\Game1.wav");
                
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
               
	}

	public void paint(Graphics g) {
		// background
		g.setColor(Color.BLACK);
		g.fillRect(1, 1, 1092, 692);
                 

		// drawingmap
		 mapob.draw((Graphics2D) g);

	       //Level
		g.setColor(Color.white);
		f = new Font("Arial", Font.PLAIN, 14);
		g.setFont(f);
		g.drawString("Level : 1", 20, 30);
                
                //score
		g.setColor(Color.white);
		f = new Font("Arial", Font.PLAIN, 14);
		g.setFont(f);
                //new change score position 
		g.drawString("Score: " + score, 975, 30);
                
                
                if(ballposY>670 && life!=0)
                {
                    play=false;
                    isSecondBallAppear=false;
                   
                    g.setColor(Color.WHITE);
                    g.setFont(f);
                    g.drawString("Life"+life, 500, 310);
                    g.setColor(Color.WHITE);
                    g.setFont(f);
                    g.drawString("Press ( Enter ) to Continue", 450, 340);
                }
                
		if (ballposY > 670&& life==0) {
			play = false;
                        isSecondBallAppear = false;
			ballxdir = 0;
			ballydir = 0;
			g.setColor(Color.white);
			f2 = new Font("Arial", Font.PLAIN, 26);
			g.setFont(f2);
			g.drawString(gameOverMessage, 460, 300);
                        
                        //restart option
                         g.setColor(Color.WHITE);
                         g.setFont(f);
                         g.drawString("Press ( Enter ) to Restart", 450, 340);
                         
		}
                
		if (isSecondBallAppear)
                {
                    
                       //score
			g.setColor(Color.BLUE);
			g.fillOval(secondBallPosX, secondBallPosY, 20, 20);
                       
                }
                if(secondBallPosY>670 && life!=0)
                {
                    play=false;
                    isSecondBallAppear = false;
                    g.setColor(Color.WHITE);
                    g.setFont(f);
                    g.drawString("Life : "+life, 500, 310);
                    g.setColor(Color.WHITE);
                    g.setFont(f);
                    g.drawString("Press ( Enter ) to Continue", 450, 340);
                }
			
                if (secondBallPosY > 670 &&life==0) {
                            
                       play = false;
                       isSecondBallAppear = false;
                       
                       secondBallDirX = 0;
			secondBallDirY = 0;
			g.setColor(Color.white);
			f2 = new Font("Arial", Font.PLAIN, 26);
			g.setFont(f2);                                
                            //New/change the position
			g.drawString(gameOverMessage , 460, 300);
                              
                           //restart option
                        g.setColor(Color.WHITE);
                        g.setFont(f);
                        g.drawString("Press ( Enter ) to Restart", 450, 340);
			}
                        
                 //Life
		g.setColor(Color.white);
		f = new Font("Arial", Font.PLAIN, 14);
		g.setFont(f);
		g.drawString("Life : "+life, 915, 30);       
		
                
                //bonusiobject
                
                //A
                g.setColor(new Color(219, 9, 72));
                g.fill3DRect(100, bonusAY, 60, 30 ,true);
                g.setColor( Color.WHITE);
                f = new Font("Arial", Font.PLAIN, 18);
                g.setFont(f);
                g.drawString("500+", 110,bonusAY+20);
                
                //B
                g.setColor(new Color(0, 207, 204));
                g.fill3DRect(400,bonusBY, 70, 30,true);
                g.setColor( Color.WHITE);
                f = new Font("Arial", Font.PLAIN, 18);;
                g.setFont(f);
                g.drawString("1000+", 410,bonusBY+20);
                
                //C
                g.setColor(new Color(219, 9, 72));
                g.fill3DRect(900,bonusCY, 70, 30,true);
                g.setColor( Color.WHITE);
                f = new Font("Arial", Font.PLAIN, 18);
                g.setFont(f);
                g.drawString("2000+", 910,bonusCY+20);
                
                
                //life
                int[] px={601,655,628};
                int[] py={lifeposY,lifeposY,lifeposY+32};
                
                g.setColor(new Color(219, 9, 72));
                g.fillOval(600, lifeposY-21, 30, 30);
                
                g.setColor(new Color(219, 9, 72));
                g.fillOval(626, lifeposY-21, 30, 30);
                
                g.setColor(new Color(219, 9, 72));
                g.fillPolygon(px, py, px.length);
                
               

		// border
                g.setColor(new Color(9, 219, 58));
		g.fillRect(0, 0, 3, 692);
		g.fillRect(0, 0, 1092, 3);
		g.fillRect(1091, 0, 3, 692);

		// paddle
		g.setColor(new Color(9, 219, 58));
		g.fillRect(playerX, 638, playerWidth, 20);
		

		//ball
		g.setColor(new Color(9, 219, 58));
		g.fillOval(ballposX, ballposY, 20, 20);
		g.dispose();
	   }
           public static void playMusic(String filepath)
           {
           InputStream music;
           try
           {
           music = new FileInputStream(new File(filepath));
           AudioStream audios =new AudioStream(music);
           AudioPlayer.player.start(audios);

           }
           catch(Exception e)
           {
           JOptionPane.showMessageDialog(null, "Error");
           }
      
      
          }
           
         
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) 
        {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
			if (playerX >=1000)
				playerX = 1000;
			else
				moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
                {
			if (playerX < 10)
				playerX = 10;
			else
				moveLeft();

		}
                if(e.getKeyCode()==KeyEvent.VK_ENTER && life==1)
                {
                    if(!play)
                    {
                    play=true;
                    isSecondBallAppear=true;
                    life--;

                             
                   
                    ballposX = 350;
	            ballposY = 617;
                    ballxdir = -1;
                    ballydir = -2;
                    
                    secondBallPosX = 1050;
                    secondBallPosY = 500;
                    secondBallDirX = -2;
                    secondBallDirY = -2;
                    secondBallStartBrick = 24;
                        
                    }
                }
                //new Resatrt action
                if(e.getKeyCode()==KeyEvent.VK_ENTER && totalbrick!=0)
                  {
                  if(!play)
                    {
                        
                    play = true;
                       
                       
                       
                    playerX = 310;
                    ballposX = 350;
	            ballposY = 617;
                    ballxdir = -1;
                    ballydir = -2;
                    
                    mapob=new MapGenerator1(4,8);
	            //new
                    totalbrick = 32;
	
                    score = 0;
                   
                    //bonusobject
                    bonusAY=-100;
                    bonusBY=-100;
                    bonusCY=-100;
                    cnt1=0;
                    cnt2=0;
                    cnt3=0;
                    
                    life=0;
                  
                    //life
                    lifeposY=-200;

	           //second ball
                   isSecondBallAppear = false;
                   secondBallPosX = 1050;
                   secondBallPosY = 500;
                   secondBallDirX = -2;
                   secondBallDirY = -2;
                   secondBallStartBrick = 24;

	           //player handle speed
	  
                   playerSpeed = 20;
                   playerWidth = 100;

	            //win
                    isWin = false;    
                       
                     repaint();

                          }


                        }

                
                
                

	 }
        
        
        
        

	  public void moveRight()
          {
		play = true;
                
               
                    playerX = playerX + playerSpeed;
                    

	    }

	  public void moveLeft()
          {
		play = true;
               
		playerX = playerX - playerSpeed;
              
                  
	   }

	  @Override
	  public void keyReleased(KeyEvent e) {
 
	  }

	  @Override
	  public void actionPerformed(java.awt.event.ActionEvent e) {
		
                repaint();
		timer.start();
		if (play) {
			if (new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
				ballydir = (ballydir * -1);
                                    playMusic("Music\\\\hitt.wav");
                         
			}
			if (isSecondBallAppear) {
				if (new Rectangle(secondBallPosX, secondBallPosY, 20, 20)
						.intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
					secondBallDirY = (secondBallDirY * -1);
                                            playMusic("Music\\\\hitt.wav");

				}
			}

			// new
			A: for (int i = 0; i <  mapob.map.length; i++) {
				for (int j = 0; j <  mapob.map[0].length; j++) {
					if ( mapob.map[i][j] > 0) {
						int brickX = j *  mapob.brickwidth + 80;
						int brickY = i *  mapob.brickheight + 70;
						int brickwidth =  mapob.brickwidth;
						int brickheight =  mapob.brickheight;

						Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickheight);
						Rectangle ballrect = new Rectangle(ballposX, ballposY, 20, 20);

						Rectangle brickrect = rect;
						if (ballrect.intersects(brickrect)) {
							 mapob.setBrickValue(0, i, j);
							totalbrick--;
                                                      playMusic("Music\\\\hitperfect.wav");

							score = score + 10;
							if (totalbrick == secondBallStartBrick) {
								isSecondBallAppear = true;
								playerWidth = 170;
                                                                playerSpeed=30;
								
							}
                                                        if (totalbrick == 0) 
                                                              {
									play = false;
									isWin = true;
                                                                        
                                                                    
                                                                Interface2 level2= new Interface2();
                                                                level2.setVisible(true);     
								}
							

							if (ballposX + 19 <= brickrect.x || ballposX + 1 >= brickrect.x + brickrect.width) {
								ballxdir = -ballxdir;
							} else {
								ballydir = -ballydir;
							}
							break A;
						}

					}

				}

			}

			if (isSecondBallAppear) {
				B: for (int i = 0; i <  mapob.map.length; i++) {
					for (int j = 0; j <  mapob.map[0].length; j++) {
						if ( mapob.map[i][j] > 0) {
							int brickX = j *  mapob.brickwidth + 80;
							int brickY = i *  mapob.brickheight + 70;
							int brickwidth =  mapob.brickwidth;
							int brickheight =  mapob.brickheight;

							Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickheight);
							Rectangle ballrect = new Rectangle(secondBallPosX, secondBallPosY, 20, 20);

							Rectangle brickrect = rect;
							if (ballrect.intersects(brickrect)) {
								 mapob.setBrickValue(0, i, j);
								totalbrick--;
                                                                
						             playMusic("Music\\\\hitperfect.wav");
                                                             
								if (totalbrick == 0) {
									play = false;
									isWin = true;
                                                                        
                                                               
                                                                Interface2 level2= new Interface2();
                                                                level2.setVisible(true);     
								}

								score = score + 30;

								if (secondBallPosX + 19 <= brickrect.x
										|| secondBallPosX + 1 >= brickrect.x + brickrect.width) {
									secondBallDirX = -secondBallDirX;
								} else {
									secondBallDirY = -secondBallDirY;
								}
								break B;
							}

						}

					}

				}
			}
                              //FIRST BALL
                               ballposX = ballposX + ballxdir;
			       ballposY = ballposY + ballydir;
            
                                if (ballposX < 0) {
			 	ballxdir = (ballxdir * -1);


			        }
			        if (ballposY < 0) {
				ballydir = (ballydir * -1);

			        }
			        if (ballposX > 1070) {
				ballxdir = (ballxdir * -1);
			        }
                                //SCOND BALL
			        if (isSecondBallAppear) {
				secondBallPosX = secondBallPosX + secondBallDirX;
				secondBallPosY = secondBallPosY + secondBallDirY;
                                
				if (secondBallPosX < 0) {
					secondBallDirX = (secondBallDirX * -1);

				}
				if (secondBallPosY < 0) {
					secondBallDirY = (secondBallDirY * -1);

				}
				if (secondBallPosX > 1070) {
					secondBallDirX = (secondBallDirX * -1);
				}
			       }
                                //bonusbutton
                                if(totalbrick<=24)
                                { 
                                    bonusAY=bonusAY+1;
                                    if(cnt1==0)
                                    {
                                    if (new Rectangle(100, bonusAY, 60, 30 ).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
                                     score=score+500;
                                     cnt1++;
                                    }
                                }}
                                if(totalbrick<=8)
                                {
                                    bonusBY=bonusBY+1;
                                    if(cnt2==0)
                                    {
                                    if (new Rectangle(400, bonusBY, 70, 30 ).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
                                     score=score+1000;
                                     cnt2++;
                                    }
                                    }
                                }
                                if(totalbrick<=16)
                                {
                                    bonusCY=bonusCY+1;
                                    if(cnt3==0)
                                    {
                                    if (new Rectangle(900, bonusCY, 70, 30 ).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
                                     score=score+2000;
                                     cnt3++;
                                    }
                                    }
                                }
                                
                                //life button
                                
                                if(totalbrick<=12)
                                {
                                    lifeposY = lifeposY +  2;
                                    if (new Rectangle(601,lifeposY,55,32).intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
				    
                                     life=1;
                                     
                                    }
                                }
                                
                                 
                                

		}

	}
}

