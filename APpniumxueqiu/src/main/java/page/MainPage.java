package page;
import org.openqa.selenium.By;

import driver.Driver;

public class MainPage extends BasePage {
	//个人中心
    By profile=By.id("com.xueqiu.android:id/tab_icon");

    //主页面
    public static MainPage start(){
        Driver.start();
        return new MainPage();
    }

    //进入个人页面
    public ProfilePage gotoProfile(){
        Driver.getCurrentDriver().findElement(profile).click();
        return new ProfilePage();
    }

    //搜索页面
    public SearchPage gotoSearch(){
        find(By.id("com.xueqiu.android:id/home_search")).click();
        return new SearchPage();
    }

    //股票
    public StockPage gotoStock() {
    	find(By.xpath("//android.widget.TabWidget/android.widget.RelativeLayout[3]/android.widget.ImageView")).click();
    	return new StockPage();
    }

}
