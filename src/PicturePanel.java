//Imports
import javax.swing.JOptionPane;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class PicturePanel extends JPanel{
	private BufferedImage picture;
	
	//Get picture function
	public BufferedImage getPicture() {
		return picture;
	}
	//Set picture function
	public void setPicture(BufferedImage picture) {
		this.picture = picture;
	}
	
	//Constructor for panel which makes the full size of the image cover the North part of the panel
	public PicturePanel() {
		setPreferredSize(new Dimension(290,192));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Loads an image to the screen
		try {
			BufferedImage img = picture;
			g.drawImage(img,0,0,null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Failed to load picture");
		}
	}
	

}
