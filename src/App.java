import java.util.ArrayList;

/**
 * Main Class - Used for the creation of everything, also used for the reading of the file for PictureData
 * @author Jack
 *
 */
public class App {
	public static void main(String[] args) {
		//Declare and initialize the variable for the text file
		String fname = "descriptions.txt";
		
		//Used to read the text file being used to the program for our creation
		ArrayList<PictureData> imgData = PictureDataReader.readPictureDataFromFile(fname);
		
		//Used to create the frame of the app
		PictureFrame pf = new PictureFrame();
		
		//Keep check if the imgData array has processed correctly or not
		System.out.println(imgData);
	}
}
