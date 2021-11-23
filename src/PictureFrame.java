//Imports
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
//CAN USE CTRL-->SHIFT-->O to automatically put missing inputs
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PictureFrame extends JFrame {
	
	public void setupGUI() {
		//Declare and initialize the variable for the text file
		String fname = "descriptions.txt";
		
		//Used to read the text file being used to the program for our creation
		ArrayList<PictureData> imgData = PictureDataReader.readPictureDataFromFile(fname);
		
		//Call the PictureLoader class to create list of the buffered images
		ArrayList<BufferedImage> theImages = PictureLoader.loadImagesFromPictureData(imgData);
		
		
		setTitle("Picture Frame"); //Appears at the top bar
		setBounds(100,150,290,400); //Sets at (100,150) from the top left at 290 pixels wide and 400 pixels tall
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit when the user hits close
		Container c = getContentPane();
		c.setLayout(new BorderLayout()); //Set to a border layout
		
		//Have drawing Picture Panel do its work
		PicturePanel panPic = new PicturePanel();
		panPic.setPicture(theImages.get(0));
		c.add(panPic,BorderLayout.CENTER);
		
		
	}
	
	/**
	 * Used for setting up graphical user interface
	 */
	public PictureFrame() {
		setupGUI();
	}
}
