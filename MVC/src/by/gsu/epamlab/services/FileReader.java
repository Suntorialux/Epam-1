package by.gsu.epamlab.services;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class FileReader {
	public String fileName;
	public String key2;
	public int len;
	public String[] keys;
	public String type;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getLen(){
		getLoadSettings();
		
		
		return keys;
	}
	
	private void getLoadSettings(){
		ResourceBundle resourcesBundle = ResourceBundle.getBundle(fileName);
		
		String key = resourcesBundle.getString("numbers");
		String type = resourcesBundle.getString("control").trim();
		
		keys = key.split("[,\\s]+");
		this.type = type;
		this.len = keys.length; 
		 
		
	}
	
}
