package com.muzzafar.readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.muzzafar.util.Configuration;

public class PropertyReader {
	
	public String getvaluefrompropertyreader (String key) { 
		String myreturnvalue = null;	
		try (InputStream input = new FileInputStream(Configuration.PROJECT_PATH+"/src/test/resources/property.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            myreturnvalue = prop.getProperty(key);
        }
		catch (IOException ex) {
            ex.printStackTrace();
        }
		return myreturnvalue;
}
	
/*
 * public static void main(String[] args) {
 * 
 * PropertyReader abc = new PropertyReader(); String a =
 * abc.getvaluefrompropertyreader("SIT_UN"); System.out.println(a);
 * 
 * 
 * 
 * 
 * }
 */
	
	
}
