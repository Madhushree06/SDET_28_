package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * utility for property file
 * @author Ammu
 *
 */

public class FileUtility {
	
	public String getPropertFileData(String key) throws Throwable
	{
		FileInputStream file = new FileInputStream(IpathConstants.PROPERTYFILEPATH);
		Properties property= new Properties();
		property.load(file);
		return property.getProperty(key);
		
		
	}

}
