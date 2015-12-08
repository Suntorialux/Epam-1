package by.gsu.epamlab.bll;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import by.gsu.epamlab.model.Test;


public class CsvReader implements Readers<Test> {
	
	
	
	private Scanner scanner = null;
	

	public CsvReader(Scanner scanner) {
		this.scanner = scanner;
	}



	@Override
	public Test read() {
		
		
		Test tests = null;
		
		String csvLine = scanner.nextLine();
		String [] tmp = csvLine.split(";");
		try {
			tests =  new Test(tmp[0],tmp[1],tmp[2],tmp[3]);
		} catch (ParseException | NumberFormatException e) {
			System.err.println("Incorrect data for student: " + tmp[0] + " test - " + tmp[1]);
		}
		return tests;
	}

}
