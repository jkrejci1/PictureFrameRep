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
	
	public void setupGUI(ArrayList<BufferedImage> theImages) {

		setTitle("Picture Frame"); //Appears at the top bar
		setBounds(100,150,290,400); //Sets at (100,150) from the top left at 290 pixels wide and 400 pixels tall
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit when the user hits close
		Container c = getContentPane();
		c.setLayout(new BorderLayout()); //Set to a border layout
		
		//Have drawing Picture Panel do its work
		PicturePanel panPic = new PicturePanel();
		//This will be for the start of what images are shown, it automatically loads the first one
		c.add(panPic,"North");
		//The north will be used for the picture so it's dimmensions match the size of the picture
		panPic.setPicture(theImages.get(0));
		//c.add(panPic.CENTER,BorderLayout.NORTH); //Question for adding a boarder layout to center		
		
		//Now create the center frame which contains a boarder layout as well
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
	}
	
	private Object BorderLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Used for setting up graphical user interface
	 */
	public PictureFrame() {
		setupGUI(null);
	}
	public PictureFrame(ArrayList<BufferedImage> theImages) {
		setupGUI(theImages);
	}
}
