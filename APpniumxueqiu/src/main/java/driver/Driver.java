package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class Driver {

	public static AppiumDriver<WebElement> driver;
	public static Logger log = Logger.getLogger(Driver.class);
	public static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

	public static void start() {
		GlobalConfig config = GlobalConfig.load("/data/globalConfig.yaml");
		config.appium.capabilities.keySet().forEach(key -> {
			Object value = config.appium.capabilities.get(key);
			desiredCapabilities.setCapability(key, value);
		});
//		 System.out.println("等待时间:" + config.appium.wait);

		try {
			driver = new AppiumDriver<WebElement>( new URL(config.appium.url), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//显士等待
		(new WebDriverWait(driver,6))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("com.xueqiu.android:id/tv_dis_agree"))).click();
		//隐士等待
//		driver.manage().timeouts().implicitlyWait(config.appium.wait, TimeUnit.SECONDS);

	}

	public static AppiumDriver<WebElement> getCurrentDriver(){
          return Driver.driver;
    }

}
