package page;

import driver.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SearchPage extends BasePage{
	/**
	 * 输入框搜索内容
	 * @param keyword
	 * @return
	 */
    public SearchPage search(String keyword){
        find(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(keyword);
        return this;
    }
    /**
       * 取消
     * @return
     */
    public MainPage cancel(){
        find(By.id("action_close")).click();
        return new MainPage();
    }

    public ArrayList<String> getAll(){
        ArrayList<String> array=new ArrayList<String>();
        for(WebElement e: Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;

    }
    /**
     * 上传图片
     * @return
     */
    public SearchPage uploadPicture() {
    	find(By.id("com.xueqiu.android:id/action_upload"));
    	return this;
    }
    
    public  SearchPage gotoback() {
    	findElementByAccessibilityId("转到上一层级");
    	return this;
    }

    public SearchPage getSelecteBYOne() {
    	String path="//androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]";
    	findElement(path).click();
    	return this;
    }
    
    public SearchPage getByStock(){
        return  this;

    }

    public ArrayList<String> addSelected(){
        //appium的bug 本来resource-id与resourceId都应该支持，结果只支持了resourceId
        ArrayList<String> array=new ArrayList<String>();
        AndroidElement select=(AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(select.getAttribute("resourceId"));
        select.click();
        AndroidElement select2=(AndroidElement)find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(select2.getAttribute("resourceId"));
        return array;

    }

    public SearchPage removeSelected(){
        return this;

    }
}
