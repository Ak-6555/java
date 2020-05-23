
package DemoGameLavelTwo;


import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main1 extends JFrame {
    
    Main1()
    {
        initcomponent();
    }
    
    public void initcomponent()
    {
           this.setBounds(10, 10,1100, 700);
           this. setResizable(false);
           this.setLocation(150, 5);
           this. setVisible(true);
           this.setTitle("Break Bang");
           
        Gameplay1 gameplay = new Gameplay1();   
       
        
        this.getContentPane().setBackground(Color.BLACK);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(gameplay);
        
          ImageIcon icon = new ImageIcon("src/icon.jpg");
               this.setIconImage(icon.getImage());   
               
    }
        
    
    
    public static void main(String[] args) {
        Main1 obj=new Main1();
        
         
        
               
    } 
    
}
