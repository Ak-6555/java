package demogamecoverpage;



import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Interface2 extends JFrame implements ActionListener {
   
    private Container c;
    private ImageIcon ic,icp,ich,ichc,ics,icr,con;
    private JLabel imglabel;
    private JButton btnqn,btnhelp,btnexit,btnmain;
    private Font font;
    
    
    Interface2()
            
    {
        init();
    }
     public void init()
     { 
         this.setBounds(150, 5, 1100, 700);
         this.setVisible(true);
         this.setResizable(false);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setTitle("Break Bang");
         
         con =new ImageIcon("src/icon.jpg");
         this.setIconImage(con.getImage());
         
         c=this.getContentPane();
         c.setLayout(null);
         
          
        
          font= new Font("TimesRoman" ,Font.BOLD,20);
         
       
         
          btnqn =new JButton ();
          icp=new ImageIcon("src/Co.jpg");
          btnqn.setBounds(475,360,icp.getIconWidth(), icp.getIconHeight());
          btnqn.setIcon(icp);
        
          c.add(btnqn);
        
       
        
          
          btnhelp =new JButton ();
          ich=new ImageIcon("src/Hp2.jpg");
          btnhelp.setBounds(475,360+ icp.getIconHeight(),icp.getIconWidth(), icp.getIconHeight());
          btnhelp.setIcon(ich);
          c.add(btnhelp);
          
         
     
          btnexit =new JButton ();
          ics=new ImageIcon("src/Exit.jpg");
          btnexit.setBounds(475,360+ 2 *icp.getIconHeight(),icp.getIconWidth(), icp.getIconHeight());
         btnexit.setIcon(ics);
          c.add(btnexit);
          
       
          
          btnmain=new JButton ();
          ichc=new ImageIcon("src/MM.jpg");
          btnmain.setBounds(475,360+ 3*icp.getIconHeight(),icp.getIconWidth(), icp.getIconHeight());
          btnmain.setIcon(ichc);
          c.add(btnmain);
           
          
          
          ic=new ImageIcon("src/BACKKK2.jpg");
          imglabel = new JLabel(ic);
          imglabel.setBounds(0, 0,ic.getIconWidth(),ic.getIconHeight());
          c.add(imglabel);
         

          
          btnqn.addActionListener(this);
          btnhelp.addActionListener(this);
          btnexit.addActionListener(this);
          btnmain.addActionListener(this);
          
          
         
         
     }
    public static void main(String[] args) {
        
        Interface2 menu=new Interface2();
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(btnqn==e.getSource())
        {
            dispose();
           Main letsplay =new Main();
           letsplay.setVisible(true);
           
        }
        else if(btnexit==e.getSource())
        {
            
            JOptionPane.showMessageDialog(null, "Exit the Break Bang");
            dispose();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           
        }
        if(btnhelp==e.getSource())
        {
            
            JOptionPane.showMessageDialog(null, "We appreciate your interest in playing this game."
                    + "\nHere are detailed instructions to maneuver you:\n There are three levels of the game,"
                    + "\nthat will be unlocked only if you win the previous levels.\nThe first level is accessible to all by default."
                    + "\n\nRules of the game:\n\nUse your cursor or keys to move the paddle to and fro in accordance with "
                    + "\nthe motion of the ball so that the ball can land on the paddle after hitting the bricks."
                    + "\nIf the ball gets misplaced instead of landing,"
                    + "\nthe game gets over and final score is put on the display."
                    + "\nIf you manage to break all the bricks successfully,\n"
                    + " you get to play in the next level.Enjoy!  ");
            
        }
     
        if(btnmain==e.getSource())
        {
            
            JOptionPane.showMessageDialog(null, "Main Menu");
//             this.hide();
//             Interface1 backframe= new  Interface1();
//             backframe.setVisible(true);
             
            
        }
        
        
        
        
    }
    
    
}
