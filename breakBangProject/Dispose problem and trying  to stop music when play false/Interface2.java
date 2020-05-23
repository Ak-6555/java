package DemoGameLavelTwo;



import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Interface2 extends JFrame implements ActionListener {
   
    private Container c;
    private ImageIcon icon,iconplay,iconhelp,iconmm,iconexit,iconbackground;
    private JLabel imglabel;
    private JButton btncontinue,btnhelp,btnexit,btnmain,btnscore,btnlife;
    private Font f;
    
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
         
         icon =new ImageIcon("src/icon.jpg");
         this.setIconImage(icon.getImage());
         
         c=this.getContentPane();
         c.setLayout(null);
         
          
         
       
         
          btncontinue =new JButton ();
          iconplay=new ImageIcon("src/Co.jpg");
          btncontinue.setBounds(473,360, iconplay.getIconWidth(),  iconplay.getIconHeight());
          btncontinue.setIcon( iconplay);
        
          c.add(btncontinue);
        
       
        
          
          btnhelp =new JButton ();
          iconhelp=new ImageIcon("src/Hp2.jpg");
          btnhelp.setBounds(473,360+  iconplay.getIconHeight(), iconplay.getIconWidth(),  iconplay.getIconHeight());
          btnhelp.setIcon( iconhelp);
          c.add(btnhelp);
          
         
     
          btnexit =new JButton ();
          iconexit=new ImageIcon("src/Exit.jpg");
          btnexit.setBounds(473,360+ 2 * iconplay.getIconHeight(), iconplay.getIconWidth(),  iconplay.getIconHeight());
          btnexit.setIcon(iconexit);
          c.add(btnexit);
          
       
          
          btnmain=new JButton ();
          iconmm=new ImageIcon("src/MM.jpg");
          btnmain.setBounds(473,360+ 3* iconplay.getIconHeight(), iconplay.getIconWidth(),  iconplay.getIconHeight());
          btnmain.setIcon(iconmm);
          c.add(btnmain);
           
          

          btnscore = new JButton("Your Score : "+Gameplay1.score);
          btnscore.setBackground(Color.GREEN);
          f= new Font("Arial",Font.CENTER_BASELINE,16);
          btnscore.setFont(f);
          btnscore.setBounds(170,400, 220, 40);
          c.add(btnscore);
          
         
          btnlife = new JButton("life : "+ Gameplay1.life);
          btnlife.setBackground(Color.GREEN);
          f= new Font("Arial",Font.CENTER_BASELINE,16);
          btnlife.setFont(f);
          btnlife.setBounds(750,400, 200, 40);
          c.add(btnlife);
          
          iconbackground=new ImageIcon("src/BACKKK2.jpg");
          imglabel = new JLabel(iconbackground);
          imglabel.setBounds(0, 0,iconbackground.getIconWidth(),iconbackground.getIconHeight());
          c.add(imglabel);
          
          

          
          btncontinue.addActionListener(this);
          btnhelp.addActionListener(this);
          btnexit.addActionListener(this);
          btnmain.addActionListener(this);
          
          
         
         
     }
    public static void main(String[] args) {
        
        Interface2 menu=new Interface2();
         playMusic("Music\\\\Intro.wav");
        
    }
     
     //imtroSound
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
         JOptionPane.showMessageDialog(null, "Sound Error");
     }
      
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(btncontinue==e.getSource())
        {
           dispose();
           Main2 letsplay =new Main2();
           letsplay.setVisible(true);
           
        }
        else if(btnexit==e.getSource())
        { 
             ImageIcon exiticon= new ImageIcon("src/exiticon.jpg");
             JOptionPane.showMessageDialog(null, "Exit the Break Bang","Exit",0,exiticon);
             dispose();
             setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             
           
        }
        if(btnhelp==e.getSource())
        {
            ImageIcon helpicon = new ImageIcon("src/hicon.jpg");
            JOptionPane.showMessageDialog(null, "We appreciate your interest in playing this game."
                    + "\nHere are detailed instructions to maneuver you:\n There are three levels of the game,"
                    + "\nthat will be unlocked only if you win the previous levels.\nThe first level is accessible to all by default."
                    + "\n\nRules of the game:\n\nUse your cursor or keys to move the paddle to and fro in accordance with "
                    + "\nthe motion of the ball so that the ball can land on the paddle after hitting the bricks."
                    + "\nIf the ball gets misplaced instead of landing,"
                    + "\nthe game gets over and final score is put on the display."
                    + "\nIf you manage to break all the bricks successfully,\n"
                    + " you get to play in the next level.Enjoy!  ","Help",1,helpicon);
            
        }
     
        if(btnmain==e.getSource())
        {
            ImageIcon mainicon = new ImageIcon("src/mainicon.jpg");
            JOptionPane.showMessageDialog(null, "Main Menu","Main Menu",1,mainicon);
            dispose();
            Interface1 backframe= new  Interface1();
            backframe.setVisible(true);
             
            
        }
        
        
        
        
    }
    
    
}
