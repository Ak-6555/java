
package breakBangProject.DemoGameLavelTwo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class MapGenerator1 {
    public int map[][];
    public int brickwidth;
     public int brickheight;
      public MapGenerator1(int row,int col)
      {
          map=new int[row][col];
          for (int i = 0; i < map.length; i++) {
              for (int j = 0; j < map[0].length; j++) {
                  map[i][j]=1;
                  
                  
              }
              
          }
          
         brickwidth=940/col;
         brickheight=160/row;
      }
         public void draw(Graphics2D g)
         {
             for (int i = 0; i < map.length; i++) {
                 for (int j = 0; j <map[0].length; j++) {
                    
                     if(map[i][j]>0){
                         g.setColor(Color.BLUE);
                         g.fillRect(j*brickwidth+80, i*brickheight+70, brickwidth, brickheight);
                    
                        g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth+80, i*brickheight+70, brickwidth, brickheight);
                     
                     
                     }
                 }
 
             }
         }
         public void setBrickValue(int value , int row , int col)
         {
             map[row][col]=value;
         }
         
      }
    

