package page;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.Driver;

public class BasePage {
	
	static Logger log=Logger.getLogger(BasePage.class);
    static WebElement find(By locator){
          WebElement webElement=null;
          try {
        	 
			webElement=Driver.getCurrentDriver().findElement(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
          return webElement;
    }
    static WebElement findElementByAccessibilityId(String path) {
    	return Driver.getCurrentDriver().findElementByAccessibilityId("转到上一层级");
    }

    static By locate(String locator){
        if(locator.matches("/.*")||locator.matches("//")){
            return By.xpath(locator);
        }else if(locator.matches("id/")){
            return By.id(locator);
        }else {
        	return By.className(locator);
        }
    }

    static WebElement findElement(String locator) {
    	return Driver.getCurrentDriver().findElement(locate(locator));
    }
    static By text(String content){
        return By.xpath("//*[@text='"+ content + "']");
    }
   public void FindPageSource() {
		String pagesource=Driver.getCurrentDriver().getPageSource();
        System.out.println("获得的页面元素："+pagesource);
	    if(pagesource.contains("com.xueqiu.android:id/dialog_content" )) {
      	  Driver.getCurrentDriver().findElement(By.xpath("//android.widget.LinearLayout[contains(@text,'同意')]")).click();
      	  Driver.getCurrentDriver().findElement(By.id("com.xueqiu.android:id/tv_dis_agree"));
      }
      Driver.getCurrentDriver().findElement(By.id("com.xueqiu.android:id/tv_dis_agree"));
      Driver.getCurrentDriver().findElement(By.xpath("//android.widget.LinearLayout[contains(@text,'同意')]")).click();
 
//    Set<String>sets= Driver.getCurrentDriver().getContextHandles();
//    Iterator<String>iterrators= sets.iterator();
//    while(iterrators.hasNext()) {
// 	 String cuurent=  iterrators.next();
// 	 System.out.println("cuurent:"+cuurent);
//    }
   }
 
	   


}
