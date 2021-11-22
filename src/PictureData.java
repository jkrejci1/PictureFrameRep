
/**
 * Model Class - Fields for filename, data, description of an image
 * @author Jack
 *
 */
public class PictureData {
	private String picFile;
	private String date;
	private String description;

	//Getters and Setters
	
	//Getter/Setter for fileName
	public String getPicFile() {
		return picFile;
	}
	public void setPicFile(String fileName) {
		this.picFile = fileName;
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
	
	//Non-default constructor 
	public PictureData() {
		picFile = "";
		date = "";
		description = "";
	}
	
	//Default constructor
	public PictureData(String picFile, String date, String description) {
		setPicFile(picFile);
		setDate(date);
		setDescription(description);
	}
	
	//To String function
	@Override
	public String toString() {
		return String.format("%s %s %s", picFile, date, description);
	}
}
