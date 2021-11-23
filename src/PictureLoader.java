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
	
	/**
	 * Function that loads the images onto the buffered image array list.
	 * @param imgData - The array list of picture data which will be needed to add images to the buffered image array list.
	 * @return
	 */
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
				e.printStackTrace();
			}
			images.add(imageFile);
		}
		return images;
	}
}
