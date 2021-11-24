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
	
	public static void changeTextData(ArrayList<PictureData> imgData, int n) {
		//Need to use this to open the text file
		String fname = "descriptions.txt";
		String line;
		String[] parts;
		//The array given by the PictureFrame class contains all the data/new data for the description and date of each image frame
		try {
			Scanner fsc = new Scanner(new File(fname));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("test2.txt"))));
			
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split("\t");

				//Overwrite each line with the current data in the text file
				
				//For Picture 1
				if (parts[0].equals(imgData.get(0).getPicFile())) {
					pw.print(imgData.get(0).getPicFile()+"\t");
					pw.print(imgData.get(0).getDate()+"\t");
					pw.print(imgData.get(0).getDescription()+"\n");
				
				//For Picture 2
				} else if (parts[0].equals(imgData.get(1).getPicFile())) {
					pw.print(imgData.get(1).getPicFile()+"\t");
					pw.print(imgData.get(1).getDate()+"\t");
					pw.print(imgData.get(1).getDescription()+"\n");
				
				//For Picture 3
				} else if (parts[0].equals(imgData.get(2).getPicFile())) {
					pw.print(imgData.get(2).getPicFile()+"\t");
					pw.print(imgData.get(2).getDate()+"\t");
					pw.print(imgData.get(2).getDescription()+"\n");
					
				//For Picture 4
				} else if (parts[0].equals(imgData.get(3).getPicFile())) {
					pw.print(imgData.get(3).getPicFile()+"\t");
					pw.print(imgData.get(3).getDate()+"\t");
					pw.print(imgData.get(3).getDescription()+"\n");
				}
				
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
