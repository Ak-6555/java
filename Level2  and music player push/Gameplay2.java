
package demogamecoverpage;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
         private boolean play = false;
	private Timer timer;
	private int delay = 8;

	private int playerX = 310;
        
        //ball and paddle are same position to start
        
	private int ballposX = 350;
	private int ballposY = 617;
        

	private int ballxdir = -2;
	private int ballydir = -2;
	private MapGenerator map;
	// new
	private int totalbrick = 50;
	private Font f, f2;
        
        //BRICK value     
        
            private int score = 0;
	// second ball
	private boolean isSecondBallAppear = false;
	private int secondBallPosX = 740/*240*/;
	private int secondBallPosY = 250;
	private int secondBallDirX = -2;
	private int secondBallDirY = -3;
	private int secondBallStartBrick = 25;

	// player handle speed
	
	private static int playerSpeed = 20;
	private static int playerWidth = 100;

	// win
	private boolean isWin = false;
	private String winMessage = "You Win!";
	private String gameOverMessage = "Game Over!";

	public Gameplay() {
		map = new MapGenerator(10, 10);
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
		//g.fillRect(1, 1, 692, 592);
                
		if (isWin) {
			g.setColor(Color.white);
			f2 = new Font("Arial", Font.BOLD, 26);
			g.setFont(f2);
			g.drawString(winMessage, 450, 300);
			g.drawString("Your Score: " + score, 440, 350);
			return;
		}
                 
                
		// drawingmap
		map.draw((Graphics2D) g);

		// new //Level
		g.setColor(Color.white);
		f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.drawString("Level : 2", 20, 30);
                
                //score
		g.setColor(Color.white);
		f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
                //new change score position 
		g.drawString("Your Score: " + score, 965, 30);

                
		if (ballposY > 670) {
			play = false;
			ballxdir = 0;
			ballydir = 0;
			g.setColor(Color.white);
			f2 = new Font("Arial", Font.BOLD, 26);
			g.setFont(f2);
			g.drawString(gameOverMessage, 460, 400);
                        
                        //restart option
                            g.setColor(Color.WHITE);
                            g.setFont(f);
                            g.drawString("Press Enter to Restart", 460, 440);
		}
                
		if (isSecondBallAppear) {
                    
                    //secre
                    
			if (secondBallPosY > 670) {
				secondBallDirX = 0;
				secondBallDirY = 0;
				play = false;
				g.setColor(Color.white);
				f2 = new Font("Arial", Font.BOLD, 26);
				g.setFont(f2);
                                
                                //New //change the position
				g.drawString(gameOverMessage, 460, 400);
                                
                               //restart option
                               g.setColor(Color.WHITE);
                               g.setFont(f);
                               g.drawString("Press ( Enter ) to Restart", 450, 440);
			}
                        
                        //<score
			g.setColor(new Color(5, 47, 255));
			g.fillOval(secondBallPosX, secondBallPosY, 20, 20);
		}
                

		// border
		g.setColor(Color.green);
		g.fillRect(0, 0, 3, 692);
		g.fillRect(0, 0, 1092, 3);
		g.fillRect(1091, 0, 3, 692);

		// paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 638, playerWidth, 20);
		

		/// ball
		g.setColor(new Color(5, 255, 68));
		g.fillOval(ballposX, ballposY, 20, 20);
		g.dispose();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
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

		} //new Resatrt action
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                  {
                  if(!play)
                    {
                       play = true;
                       
                       
                    playerX = 310;
                    ballposX = 400;
	            ballposY = 450;
                    ballxdir = -2;
                    ballydir = -2;
                    
                    map=new MapGenerator(10,10);
	           // new
                    totalbrick = 50;
	
                   score = 0;
	           // second ball
                   isSecondBallAppear = false;
                   secondBallPosX = 740/*240*/;
                   secondBallPosY = 250;
                   secondBallDirX = -2;
                   secondBallDirY = -3;
                   secondBallStartBrick = 25;

	           // player handle speed
	  
                   playerSpeed = 20;
                   playerWidth = 100;

	           // win
                    isWin = false;    
                       
                     repaint();

                          }


                        }

	}  

	public void moveRight() {
		play = true;
              
		playerX = playerX +playerSpeed;
                

	}

	public void moveLeft() {
		play = true;
               
                   playerX = playerX -   playerSpeed;

                    

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

			}
			if (isSecondBallAppear) {
				if (new Rectangle(secondBallPosX, secondBallPosY, 20, 20)
						.intersects(new Rectangle(playerX, 637, playerWidth, 20))) {
					secondBallDirY = (secondBallDirY * -1);

				}
			}

			// new
			A: for (int i = 0; i < map.map.length; i++) {
				for (int j = 0; j < map.map[0].length; j++) {
					if (map.map[i][j] > 0) {
						int brickX = j * map.brickwidth + 80;
						int brickY = i * map.brickheight + 40;
						int brickwidth = map.brickwidth;
						int brickheight = map.brickheight;

						Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickheight);
						Rectangle ballrect = new Rectangle(ballposX, ballposY, 20, 20);

						Rectangle brickrect = rect;
						if (ballrect.intersects(brickrect)) {
                                                      

							if(map.map[i][j]==2)
                                                                map.setBrickValue(1, i, j);
                                                                
                                                        else if(map.map[i][j]==1)
                                                        {   map.setBrickValue(0, i, j);
							totalbrick--;
                                                        }
							score = score + 20;
							if (totalbrick == 0) {
								play = false;
								isWin = true;
							}
							// second ball
							if (totalbrick == secondBallStartBrick) {
								isSecondBallAppear = true;
                                                                playerSpeed=30;
								playerWidth = 170;
								
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
				B: for (int i = 0; i < map.map.length; i++) {
					for (int j = 0; j < map.map[0].length; j++) {
						if (map.map[i][j] > 0) {
							int brickX = j * map.brickwidth + 80;
							int brickY = i * map.brickheight + 40;
							int brickwidth = map.brickwidth;
							int brickheight = map.brickheight;

							Rectangle rect = new Rectangle(brickX, brickY, brickwidth, brickheight);
							Rectangle ballrect = new Rectangle(secondBallPosX, secondBallPosY, 20, 20);

							Rectangle brickrect = rect;
							if (ballrect.intersects(brickrect)) {
                                                               
                                                               if(map.map[i][j]==2)
                                                                map.setBrickValue(1, i, j);
                                                                
                                                               else if(map.map[i][j]==1)
                                                                {   map.setBrickValue(0, i, j);
							          totalbrick--;
                                                                   }
								/*map.setBrickValue(0, i, j);
								totalbrick--;
								   */
								if (totalbrick == 0) {
									play = false;
									isWin = true;
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
			        if (ballposX > /*1170*/1070) {
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
				if (secondBallPosX > 1070/*1170*/) {
					secondBallDirX = (secondBallDirX * -1);
				}
			       }

		}

	}
}



















