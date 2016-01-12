package by.gsu.epamlab.services;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class FileReader {
	public String fileName;
	public String key2;
	public int len;
	public String[] keys;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String[] getLen(){
		getLoadSettings();
		for(String tmp: keys){
			System.out.println(tmp);
		}
		
		return keys;
	}
	
	private void getLoadSettings(){
		ResourceBundle resourcesBundle = ResourceBundle.getBundle(fileName);
		
		String key = resourcesBundle.getString("numbers");
		 keys = key.split(",");
		//String key = "ffdfdf";
		this.len = keys.length; 
		 
		
	}
	public String[] getFriendsAsArray(){
	    return new String[]{"Васька", "Петька", "Ленка"};
	}
}
