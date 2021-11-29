
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
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Class that displays the picture frame to the user and handles the events that the user chooses
 * @author Jack
 *
 */
public class PictureFrame extends JFrame {
	private int currentIndex = 0;
	

	/**
	 * This is the function that will set up the graphical user interface
	 * 
	 * @param theImages - The buffered image array list of all the images to be
	 *                  used.
	 * @param imgData   - The array list that contains all the data (file names,
	 *                  dates, descriptions) of each image
	 */
	public void setupGUI(ArrayList<BufferedImage> theImages, ArrayList<PictureData> imgData) {

		setTitle("Picture Frame"); // Appears at the top bar
		setBounds(100, 150, 290, 400); // Sets at (100,150) from the top left at 290 pixels wide and 400 pixels tall
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Exit when the user hits close

		// Load in the menu in the GUI
		// Set up the menu with what we'd like to have items for
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenu mnuHelp = new JMenu("Help");

		// Add the file and help items at the top in the main menu
		mbar.add(mnuFile);
		mbar.add(mnuHelp);

		// Set the items you want to include in "File" then add them to it
		JMenuItem miSave = new JMenuItem("Save");
		mnuFile.add(miSave);

		JMenuItem miExit = new JMenuItem("Exit");
		mnuFile.add(miExit);
		
		//Set the about item which will be included in "About"
		JMenuItem miAbout = new JMenuItem("About");
		mnuHelp.add(miAbout);
		
		// Used for the border layout
		Container c = getContentPane();
		c.setLayout(new BorderLayout()); // Set to a border layout

		// Have drawing Picture Panel do its work
		PicturePanel panPic = new PicturePanel();
		// This will be for the start of what images are shown, it automatically loads
		// the first one
		// Original picture
		c.add(panPic, "North");
		// The north will be used for the picture so it's dimensions match the size of the picture
		panPic.setPicture(theImages.get(0));

		// Now create the center frame which contains a boarder layout as well
		JPanel panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		// Add it to the content pane
		c.add(panCenter, "Center");
		// Make and insert the text field for the original picture date
		JTextField dateText = new JTextField(imgData.get(0).getDate());
		panCenter.add(dateText, "North");
		// Make and insert the text area for the description of the picture
		JTextArea descriptionText = new JTextArea(imgData.get(0).getDescription());
		panCenter.add(descriptionText, "Center");
		// Need to set LineWrap and WrapStyleWord to true in order for full words to
		// appear on next line when space runs out
		descriptionText.setLineWrap(true);
		descriptionText.setWrapStyleWord(true);
		// Create the three buttons which will be used to save the data, click next, or click previous
		// Then create JPanel for the south that will contain the three buttons
		JPanel southButtons = new JPanel();
		// May have to use a boarder layout for the southButtons panel where we use west, center, east for the buttons
		southButtons.setLayout(new FlowLayout());
		// Add it to the content pane
		panCenter.add(southButtons, "South");

		// Create the three buttons to be used
		// Previous button
		JButton btnPrev = new JButton("Previous");
		// Save button
		JButton btnSave = new JButton("Save");
		// Next button
		JButton btnNext = new JButton("Next");

		// Now insert the buttons into the correct locations of the frame
		// For the previous button
		southButtons.add(btnPrev);
		// For the save button
		southButtons.add(btnSave);
		// For the Next button
		southButtons.add(btnNext);

		
		// Now we need to create the action events for when a button is clicked
		// Action event for clicking the next button
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (panPic.getPicture().equals(theImages.get(currentIndex))) {
					// adds 1 to current index whenever the next button is pressed, and if it gets
					// greater than the last index it resets the index to zero
					currentIndex += 1;
					if (currentIndex > 3) {
						currentIndex = 0;
					}
					// Remove the current picture, description, and date
					panPic.remove(panPic);
					// Add the picture, description, and date of the second picture
					// For the picture
					panPic.setPicture(theImages.get(currentIndex));
					// For the date
					dateText.setText(imgData.get(currentIndex).getDate());
					panCenter.add(dateText, "North");
					// For the description
					descriptionText.setText(imgData.get(currentIndex).getDescription());
					panCenter.add(descriptionText, "Center");

				}
				repaint(); // Call repaint to refresh which will cause a swap of the old picture with the new one
			}

		});

		// Action event for clicking the previous button
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (panPic.getPicture().equals(theImages.get(currentIndex))) {
					// adds 1 to current index whenever the next button is pressed, and if it gets
					// greater than the last index it resets the index to zero
					currentIndex -= 1;
					if (currentIndex < 0) {
						currentIndex = 3;
					}
					// Remove the current picture, description, and date
					panPic.remove(panPic);
					// Add the picture, description, and date of the second picture
					// For the picture
					panPic.setPicture(theImages.get(currentIndex));
					// For the date
					dateText.setText(imgData.get(currentIndex).getDate());
					panCenter.add(dateText, "North");
					// For the description
					descriptionText.setText(imgData.get(currentIndex).getDescription());
					panCenter.add(descriptionText, "Center");

				}
				repaint(); // Call repaint to refresh which will cause a swap of the old picture with the
							// new one
			}
		});

		// Action event for clicking save
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panPic.getPicture().equals(theImages.get(currentIndex))) {
					// Need to change the dateText and descriptionText to what is now there
					// Below will successfully switch dateText and descriptionText for the picture
					dateText.setText(dateText.getText());
					descriptionText.setText(descriptionText.getText());
					// Need to reset the date and description for the imgData array with what we
					// changed it to
					imgData.get(currentIndex).setDate(dateText.getText());
					imgData.get(currentIndex).setDescription(descriptionText.getText());
					// Now we need to send this data to the writer to change them in the text file
					// permanently
					PictureDataWriter.changeTextData(imgData);
				}
			}
		});
		
		
		//Setup the main menu's action events
		//Create the action even for when you click exit
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Create the action event for when you click save
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panPic.getPicture().equals(theImages.get(currentIndex))) {
					//Need to change the dateText and descriptionText to what is now there
					//Below will successfully switch dateText and descriptionText for the picture
					dateText.setText(dateText.getText());
					descriptionText.setText(descriptionText.getText());
					//Need to reset the date and description for the imgData array with what we changed it to
					imgData.get(currentIndex).setDate(dateText.getText());
					imgData.get(currentIndex).setDescription(descriptionText.getText());
					//Now we need to send this data to the writer to change them in the text file permanently 
					PictureDataWriter.changeTextData(imgData);
				}
			}
		});
		
		//Create the action event for when you click about in "Help"
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create a pop up message with information
				JOptionPane.showMessageDialog(null, "Created by Jack Krejci in November, 2021");
			}
		});
		
		//Have the main menu all set up
		setJMenuBar(mbar);
	}
		
	/**
	 * Used for setting up graphical user interface
	 */
	public PictureFrame() {
		setupGUI(null, null);
	}

	/**
	 * Sets up GUI using our information we need
	 * 
	 * @param theImages
	 */
	public PictureFrame(ArrayList<BufferedImage> theImages, ArrayList<PictureData> imgData) {
		setupGUI(theImages, imgData);
	}
}
