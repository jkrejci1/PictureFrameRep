import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 * The class that will take in the text file of descriptions and read in the data last saved
 * @author Jack
 *
 */
public class PictureDataReader {
	
	/**
	 * The function for creating an array list of our images and their data.
	 * @param fname - Name of the text file
	 * @return - The ArrayList 
	 */
	public static ArrayList<PictureData> readPictureDataFromFile(String fname) {
		//Create the array list of picture data and read the file needed to get it
		try {
			ArrayList<PictureData> picData = new ArrayList<PictureData>();
			//Needed for picking apart the data
			String line, picFile = null, date = null, description = null; 
			String[] parts;
			Scanner fsc = new Scanner(new File(fname));
			PictureData currentPictureData = null;
			
			//Loop to read each line and put proper parts into the PictureData array
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split("\t");
				
				//Check for parts
				picFile = parts[0]; //parts[0] is the image file
				date = parts[1]; //parts[1] is the date of the selected image
				description = parts[2]; //parts[2] is the description of the current image
				
				//Add the picture date to the array list
				currentPictureData = new PictureData(picFile, date, description);
				picData.add(currentPictureData);
			}
			//Close the txt file
			fsc.close();
			//Return the array list of picture data when complete
			return picData;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
