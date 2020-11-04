package page;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidElement;

public class StockPage extends BasePage{

	public StockPage 投资达人() {
		find(By.xpath("//*[contains(@resource-id, 'com.xueqiu.android:id/tab_title') and contains(@text, '投资达人')]")).click();
	    //find(By.xpath("//*[text()='投资达人']")).click();
		return this;
	}
	//选择第一个
	public StockPage selectone() {
	     find(By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout")).click();
	     return this;
	}
	//加自选
	public StockPage addselect() {
//		find(By.id("com.xueqiu.android:id/to_choose")).click();
		find(By.xpath("//*[contains(@resource-id, 'com.xueqiu.android:id/to_choose') and contains(@text, '加自选')]")).click();
		return this;
	}
	public StockPage 定投() {
		find(By.id("com.xueqiu.android:id/fund_detail_open_aip")).click();
		return this;
	}
	//查看评论
	public StockPage 查看评论() {
		find(By.id("com.xueqiu.android:id/to_comment")).click();
		return this;
	}
}
