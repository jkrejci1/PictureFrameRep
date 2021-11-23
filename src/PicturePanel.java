//Imports
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage; //Buffered prevents flicker. It's stored in memory
import javax.imageio.ImageIO;
import java.io.File; //For the picture
import javax.swing.JOptionPane;

//CAN USE CTRL-->SHIFT-->O to automatically put missing inputs
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PicturePanel extends JPanel{
	private BufferedImage picture;
	
	//Set picture function
	public void setPicture(BufferedImage picture) {
		this.picture = picture;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Loads an image to the screen
		try {
			BufferedImage img = picture;
			g.drawImage(img,0,0,null);
		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Failed to load image");
		}
	}

}
