
/**
 * Model Class - Fields for filename, data, description of an image
 * @author Jack
 *
 */
public class PictureData {
	private String fileName;
	private String date;
	private String description;
	public String getFileName() {
		return fileName;
	}
	
	//Getters and Setters
	
	//Getter/Setter for fileName
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	//Getter/Setter for date
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	//Getter/Setter for description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
