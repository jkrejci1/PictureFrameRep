//Imports
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	
	
	/**
	 * This is the function that will set up the graphical user interface
	 * @param theImages - The buffered image array list of all the images to be used.
	 * @param imgData - The array list that contains all the data (file names, dates, descriptions) of each image 
	 */
	public void setupGUI(ArrayList<BufferedImage> theImages, ArrayList<PictureData> imgData) {

		setTitle("Picture Frame"); //Appears at the top bar
		setBounds(100,150,290,400); //Sets at (100,150) from the top left at 290 pixels wide and 400 pixels tall
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Exit when the user hits close
		Container c = getContentPane();
		c.setLayout(new BorderLayout()); //Set to a border layout
		
		//Have drawing Picture Panel do its work
		PicturePanel panPic = new PicturePanel();
		//This will be for the start of what images are shown, it automatically loads the first one
		//Original picture
		c.add(panPic,"North");
		//The north will be used for the picture so it's dimmensions match the size of the picture
		panPic.setPicture(theImages.get(0));
		//c.add(panPic.CENTER,BorderLayout.NORTH); //Question for adding a boarder layout to center		
		
		//Now create the center frame which contains a boarder layout as well
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		//Add it to the content pane
		c.add(panCenter, "Center");
		//Make and insert the text field for the original picture date
		JTextField dateText = new JTextField(imgData.get(0).getDate());
		panCenter.add(dateText, "North");
		//Make and insert the text area for the description of the picture
		JTextArea descriptionText = new JTextArea(imgData.get(0).getDescription());
		panCenter.add(descriptionText, "Center");
		
		//Create the three buttons which will be used to save the data, click next, or click previous
		//Create JPanel for the south that will contain the three buttons
		JPanel southButtons = new JPanel();
		//May have to use a boarder layout for the southButtons panel where we use west, center, east for the buttons
		southButtons.setLayout(new FlowLayout());
		//Add it to the content pane
		panCenter.add(southButtons, "South");
		//Create the three buttons to be used
		//Previous button
		JButton btnPrev = new JButton("Previous");
		
		//Save button
		JButton btnSave = new JButton("Save");
		
		//Next button
		JButton btnNext = new JButton("Next");
		
		//Now insert the buttons into the correct locations of the frame
		//For the previous button
		southButtons.add(btnPrev);
		//For the save button
		southButtons.add(btnSave);
		//For the Next button
		
		southButtons.add(btnNext);
		
		//Now we need to create the action events for when the button is clicked, using the counter to keep tracking of nexts (addition) previous (subtraction) and saves
		//Use functions for next, previous, and save (For save we need to change data in text file when changed, use the PictureDataWriter class)
		
		//Action event for clicking the next button
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Remove the old picture
				panPic.remove(panPic);
				//The north will be used for the picture so it's dimensions match the size of the picture
				panPic.setPicture(theImages.get(1));
				repaint(); //Call repaint to refresh which will cause a swap of the old picture with the new one
				
			}
		});
		
		//Action event for clicking the previous button
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add what happens when you press the next button here
				JOptionPane.showMessageDialog(null,"You pressed previous!");
			}
		});
		
		//Action event for clicking save
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add what happens when you press the next button here
				JOptionPane.showMessageDialog(null,"You pressed save!");
			}
		});
	}

	
	/**
	 * Private border layout object to be used
	 * @return null
	 */
	private Object BorderLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Used for setting up graphical user interface
	 */
	public PictureFrame() {
		setupGUI(null,null);
	}
	
	/**
	 * Sets up GUI using our information we need
	 * @param theImages
	 */
	public PictureFrame(ArrayList<BufferedImage> theImages, ArrayList<PictureData> imgData) {
		setupGUI(theImages, imgData);
	}
}
