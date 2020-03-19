
package gameprojectbreakbang;



import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	
	public static void main(String[]  args) {
		
		JFrame MyFrame = new JFrame("Break Bang");
                
                 //GamePanel thePanel = new GamePanel();
                 
             		MyFrame.setSize(WIDTH, HEIGHT);
               
             
             
		 
                MyFrame.getContentPane().setBackground(Color.BLUE);
		MyFrame.setLocationRelativeTo(null);
                
               
		MyFrame.setResizable(false);
             
             
               ImageIcon icon = new ImageIcon("F:\\Java project\\GameProjectBreakBang\\ICON.png");
               MyFrame.setIconImage(icon.getImage());       
                  
		
		MyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
		MyFrame.setVisible(true);
               
                thePanel.playGame();
                 
                       MyFrame.add(thePanel);
		
	
	}
	
}



