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
		setTitle("Picture Frame");
		setBounds(100,150,290,400); //Sets at (100,150) from the top left at 290 pixels wide and 400 pixels tall
		
	}
	
	/**
	 * Used for setting up graphical user interface
	 */
	public PictureFrame() {
		setupGUI();
	}
}
