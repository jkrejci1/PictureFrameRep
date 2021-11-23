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

//CAN USE CTRL-->SHIFT-->O to automatically put missing inputs
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PictureFrame extends JFrame {
	
	public void setupGUI() {
		setTitle("Picture Frame"); //Appears at the top bar
		setBounds(100,150,290,400); //Sets at (100,150) from the top left at 290 pixels wide and 400 pixels tall
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit when the user hits close
		Container c = getContentPane();
		c.setLayout(new BorderLayout()); //Set to a border layout
		
		
	}
	
	/**
	 * Used for setting up graphical user interface
	 */
	public PictureFrame() {
		setupGUI();
	}
}
