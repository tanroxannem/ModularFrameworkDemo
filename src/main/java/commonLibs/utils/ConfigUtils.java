package commonLibs.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

	/*
	 * Make a public static so we don't have to create an instance of this class,
	 * rather we should to call it directly.
	 */
	public static Properties readProperties(String filename) throws Exception {

		/*
		 * It's always a good idea to trim first because trimming will remove any white
		 * spaces if there is any.
		 */
		filename = filename.trim();

		InputStream fileReader = new FileInputStream(filename);

		Properties property = new Properties();

		/*
		 * The load() method read everything from the stream, whatever is pass there and
		 * will convert it to key value pair.
		 */
		property.load(fileReader);

		return property;
	}

}
