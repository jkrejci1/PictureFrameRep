//Imports
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.ArrayList;

/**
 * The writer class which will write data to a text file replacing old text when a picture a saved in PictureFrame
 * @author Jack
 *
 */
public class PictureDataWriter {
	
	/**
	 * The function that will change the text in the descriptions.txt file and permanently store it when save is clicked
	 * @param imgData - The ArrayList of data for all the images
	 */
	public static void changeTextData(ArrayList<PictureData> imgData) {
		//Need to use this to open the text file
		String fname = "descriptions.txt";
		//The array given by the PictureFrame class contains all the data/new data for the description and date of each image frame
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
			for (PictureData i : imgData) {
				pw.print(i.getPicFile()+"\t");
				pw.print(i.getDate()+"\t");
				pw.print(i.getDescription()+"\n");
			}		
			pw.close();
		} catch (Exception ex) {
			System.out.println("Failed to overwrite file!");
		}
	}

}
