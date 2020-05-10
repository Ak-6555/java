
package mymusicplayer;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sun.audio.*;


public class MyMusic extends JFrame implements ActionListener{
    
    private Container c;
    private JLabel lb;
    private JButton open, stop, play ;
    private JTextField txt;
    AudioStream audios;
    
    
    
    MyMusic()
    {
        init();
        
    }
    public void init()
    {
        this.setBounds(400, 200, 400,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Music Plater");
        
        c=this.getContentPane();
        c.setLayout(null);
        
        c.setBackground(new Color(52, 235, 183));
        
        lb = new JLabel (" Akash Music player ");
        lb.setBounds(140, 10, 150, 30);
        c.add(lb);
        
        txt= new JTextField();
        txt.setBounds(50, 50, 300, 30);
        c.add(txt);
        
        open =new JButton ("Open");
        open.setBounds(50, 120, 70, 40);
        c.add(open);
        
        play =new JButton ("Play");
        play.setBounds(160, 120, 70, 40);
        play.setEnabled(false);
                c.add(play);

                
        stop=new JButton ("Stop");
        stop.setBounds(280, 120, 70, 40);
        stop.setEnabled(false);
        c.add(stop);
        
        
        open.addActionListener(this);
        play.addActionListener(this);
        stop.addActionListener(this);
        txt.addActionListener(this);
        
        
    }

   
    public static void main(String[] args) {
        
        MyMusic play =new MyMusic();
      
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==open)
        {
            JFileChooser GF =new JFileChooser();
            int result = GF.showOpenDialog(null);
            File selectedfile = GF.getSelectedFile();
            txt.setText(selectedfile.getAbsolutePath());
            play.setEnabled(true);
            stop.setEnabled(true);
            
        }
        if(ae.getSource()==play)
        {
           String a =txt.getText();
           InputStream music;
           
           try
             {
                 music = new FileInputStream(new File (a));
                   audios = new AudioStream(music);
                    AudioPlayer.player.start(audios);
                       
               }
             catch(Exception e)
                           {
                           JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
                           }
            
        }
        if(ae.getSource()==stop)
        {
            AudioPlayer.player.stop(audios);
        }
        if(ae.getSource()==txt)
        {
            
        }
        
    }
    
}
