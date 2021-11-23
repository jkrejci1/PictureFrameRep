import java.util.ArrayList;
import java.awt.image.BufferedImage;

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
		
		//Call the PictureLoader class to create list of the buffered images
		ArrayList<BufferedImage> theImages = PictureLoader.loadImagesFromPictureData(imgData);
		//Used to create the frame of the app
		PictureFrame pf = new PictureFrame();
		pf.setVisible(true);
		
		//Keep check if the imgData array has processed correctly or not
		//System.out.println(theImages);
	}
}
