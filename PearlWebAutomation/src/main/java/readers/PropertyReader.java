package readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	public String getvaluefrompropertyreader (String key) { 
		String myreturnvalue = null;
		
		
		try (InputStream input = new FileInputStream("D:\\java eclipse\\MyProjects\\Ocean\\PearlWebAutomation\\src\\test\\resources\\property.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            //System.out.println(prop.getProperty(key));
            myreturnvalue = prop.getProperty(key);
            //prop.getProperty("db.url");
            
            
        }
		catch (IOException ex) {
            ex.printStackTrace();
       
        }
		return myreturnvalue;
		

}
	
	public static void main(String[] args) {
		
		PropertyReader abc = new PropertyReader();
		String a = abc.getvaluefrompropertyreader("SIT_UN");
		System.out.println(a);
		
		
		
		
		}
	
	
}
