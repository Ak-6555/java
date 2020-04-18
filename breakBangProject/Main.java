
package breakBangProject;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame obj = new JFrame("Break Bang");
		Gameplay gameplay = new Gameplay();

		obj.setBounds(10, 10, 700, 600);
		obj.setResizable(false);
		obj.setLocation(300, 70);
		obj.setVisible(true);

		obj.getContentPane().setBackground(Color.BLACK);

		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		obj.add(gameplay);

		ImageIcon icon = new ImageIcon("src/icon.png");
		obj.setIconImage(icon.getImage());

	}

}
