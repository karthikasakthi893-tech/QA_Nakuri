package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
  
	private static FileInputStream fileInputSteam;
	private static Properties property; 
	
	private static void setupProperty() {
	//	File file = new File("C:\\Users\\karth\\Desktop\\NakuriProject\\src\\main\\resources\\TestData.Properties");
		File file = new File("C:\\Users\\karth\\Desktop\\NakuriProject\\src\\main\\resources\\NakuriTestData.Properties");
		try {
			fileInputSteam = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputSteam);
		} catch (FileNotFoundException e) {
			Assert.fail("Error: Occur During File Loading");
			
		}
		catch (Exception e) {
			Assert.fail("Error: Occur During File Reading");	
		}
	}
	public static String getDataProperty(String value) {
		setupProperty();
		String data = property.getProperty(value);
		return data;
		
	}
	public static void main(String[] args) {
		System.out.println(getDataProperty("browser"));
	}
	
}
