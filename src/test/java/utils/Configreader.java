package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configreader {

	private static 	Properties prop;
	public static Properties getprop() throws IOException
	{
		FileInputStream file=new FileInputStream("src/test/resources/config.properties");
		prop=new Properties();
		prop.load(file);
		return prop;
		
	}
	public static String getkey(String key) throws IOException {
		return getprop().getProperty(key);
	}
}
