
package breakBangProject.DemoGameLavelTwo;


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Main1 extends JFrame {
	AudioFormat audioFormat;
	static AudioInputStream audioInputStream;
	static Clip clip;
	SourceDataLine sourceDataLine;
	boolean stopPlayback = false;
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
           
        Gameplay1 gameplay = new Gameplay1(this);   
       
        
        this.getContentPane().setBackground(Color.BLACK);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(gameplay);
        
		ImageIcon icon = new ImageIcon("src/icon.jpg");
		this.setIconImage(icon.getImage());
		playMusic();
	}
	public static void playMusic() {
		stopMusic();
		String filePath = "src/breakBangProject/Music/Game1.wav";
		InputStream music;
		try {
			music = new FileInputStream(new File(filePath));
			File file = new File(filePath);
			
			URL url = file.toURI().toURL();//this.getClass().getClassLoader().getResource("gameover.wav");
//	        System.out.println(url); 
	        audioInputStream = AudioSystem.getAudioInputStream(url);
            DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
            clip = (Clip) AudioSystem.getLine(info);
 
            clip.open(audioInputStream);
            clip.start();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static void playMusic(String filepath) {
		InputStream music;
		try {
			music = new FileInputStream(new File(filepath));
			File file = new File(filepath);
			
			URL url = file.toURI().toURL();//this.getClass().getClassLoader().getResource("gameover.wav");
//	        System.out.println(url); 
	        AudioInputStream audioInputStream1 = AudioSystem.getAudioInputStream(url);
            DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream1.getFormat());
            Clip clip1 = (Clip) AudioSystem.getLine(info);
            clip1.open(audioInputStream1);
            clip1.start();
		} catch (Exception e) {
			
		}

	}
	
	public static void stopMusic() {
		if(clip != null) {
			clip.stop();
		}
		
	}

    public static void main(String[] args) {
        Main1 obj=new Main1();
    } 
    
}
