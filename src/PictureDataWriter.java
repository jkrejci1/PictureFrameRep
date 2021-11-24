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
	
	public static void changeTextData(ArrayList<PictureData> imgData) {
		//Need to use this to open the text file
		String fname = "descriptions.txt";
		String line;
		String[] parts;
		int n = 0; //Keeps track of specific line we're on tied to a specific index
		//The array given by the PictureFrame class contains all the data/new data for the description and date of each image frame
		try {
			Scanner fsc = new Scanner(new File(fname));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("test2.txt"))));
			
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split("\t");
				
				//Overwrite each line with the current data in the text file
				
				//For ALL pictures
				if (parts[0].equals(imgData.get(n).getPicFile())) {
					pw.print(imgData.get(n).getPicFile()+"\t");
					pw.print(imgData.get(n).getDate()+"\t");
					pw.print(imgData.get(n).getDescription()+"\n");
				}
				//Add one as the line will go to the next line meaning the next index
				n += 1;
			}
			fsc.close();
			pw.close();
		} catch (Exception ex) {
			System.out.println("Failed to overwrite file!");
		}
	}

	private static String File(String fname) {
		// TODO Auto-generated method stub
		return null;
	}
}
