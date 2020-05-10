
package demogamecoverpage;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;



public class MapGenerator {
     public int map[][];
     public int brickwidth;
     public int brickheight;
     public MapGenerator(int row , int col)
      {
       
          map=new int[row][col];
          for (int i = 0; i < row; i++) {
              
              for (int j = 0; j< col; j++) {
                  
                 
            if(i<5)
            {
                if(j>=i && j<col-i-1)
                    map[i][j]=2;
                else
                    map[i][j]=0;
            }

            if(i>=5)
            {
                
                if(j>=i ||j<col-i-1)
                    map[i][j]=0;
                 
                else
                    map[i][j]=2;
            }
                  
              }
              
          }
         
          
         brickwidth=1000/col;
         brickheight=300/row;
      
             
      }     

         public void draw(Graphics2D g)
         {
             for (int i = 0; i < map.length; i++) {
                 for (int j = 0; j <map[0].length; j++) {
                    
                     if(map[i][j]==2){
                         
                         
                         g.setColor(Color.BLUE);
                         g.fillRect(j*brickwidth+80, i*brickheight+40, brickwidth, brickheight);
                    
                        g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth+80, i*brickheight+40, brickwidth, brickheight);
                     
                     
                     }
                        else  if(map[i][j]==1){
                         
                         
                         g.setColor(Color.green);
                         g.fillRect(j*brickwidth+80, i*brickheight+40, brickwidth, brickheight);
                    
                        g.setStroke(new BasicStroke(3));
                         g.setColor(Color.BLACK);
                         g.drawRect(j*brickwidth+80, i*brickheight+40, brickwidth, brickheight);
                     
                     
                     }
                 }
 
             }
         }  
         public void setBrickValue(int value , int row , int col)
         {
             map[row][col]=value;
         }
         
      }
    

