package Utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import page.BasePage;

public class PropertiUtils {
	  static void Load() {
		  Properties properties=new Properties();
		  try {
			properties.load(BasePage.class.getResourceAsStream("log4j.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		  PropertyConfigurator.configure(properties);
	  }

}
