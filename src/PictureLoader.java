import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
/**
 * This class is used to create an array list of our pictures for the application.
 * @author Jack
 *
 */
public class PictureLoader {
	
	public static ArrayList<BufferedImage> loadImagesFromPictureData(ArrayList<PictureData> imgData) {
		BufferedImage imageFile = null;
		String imageFromFile;
	
		//Create an array list for the images themselves to be loaded in
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		
		//Use the picture data to created a Buffered Image array of the images
		for (PictureData i : imgData) {
			imageFromFile = i.getPicFile();
			try {
				imageFile = ImageIO.read(new File(imageFromFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			images.add(imageFile);
		}
		return images;
	}
}
