package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * @author Admin
 *
 */

public class FileUtility {
	public String property_data(String P_path,String name) throws Throwable{
		FileInputStream fis=new FileInputStream(P_path);
		Properties p=new Properties();
		p.load(fis);
		String data=p.getProperty(name);
	
		
		return data;
		
	}
}

