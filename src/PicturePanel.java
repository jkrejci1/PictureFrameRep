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

public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener {
	private BufferedImage picture;
	//Create a private data member for the x, and y coords from the mouse movement and the message with it
	private String messageToShow = "(x=0, y=0)";
	private int msgX, msgY;
	
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
		
		//Set initial values for the mouse location
		addMouseListener(this);
		addMouseMotionListener(this);
		msgX = 0;
		msgY = 20; //Start y at 20 so you can actually see the coords when you open the program
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//Loads an image to the screen
		try {
			BufferedImage img = picture;
			g.drawImage(img,0,0,null);
			//For the mouse action
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Failed to load picture");
		}
		
		g.drawString(messageToShow, msgX, msgY);

	}
	
	
	//Below is for the mouse event information
	//For the mouse listener, I need mouseClicked, mousePressed, mouseReleased, mouseEnter, mouseExited
	//For MouseMotionListener, I need mouseMoved, and mouseDragged
	public void mouseClicked(MouseEvent e) {
		//For the changing of position, CHECK WHAT'S WRONG IN VIDEO
		//Set the x and y position of where you clicked of the coordinate positions when clicked
		msgX = e.getX();
		msgY = e.getY();
		
		messageToShow = String.format("(x=%d, y=%d)", msgX, msgY);
		//Now recall the pain component (forces paint component to be called)
		repaint();
		
		//Make the coords pop up in that location
	}
	
	public void mousePressed(MouseEvent e) {

	}
	
	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseEntered(MouseEvent e) {

	}
	
	public void mouseExited(MouseEvent e) {

	}
	
	public void mouseMoved(MouseEvent e) {
		messageToShow = String.format("(x=%d, y=%d)", e.getX(), e.getY());
		//Now recall the pain component (forces paint component to be called)
		repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		messageToShow = String.format("(x=%d, y=%d)", e.getX(), e.getY());
		//Now recall the pain component (forces paint component to be called)
		repaint();
	}
}
