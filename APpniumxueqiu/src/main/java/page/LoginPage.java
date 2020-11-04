package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	
	private By 手机号码登录=text("手机号");
	private By 手机号码一键登录=By.id("com.xueqiu.android:id/gt_one_login_submit_tv");
	
    private By 验证码登录=By.id("com.xueqiu.android:id/login_without_password");
    private By username=By.id("com.xueqiu.android:id/login_account");
    private By password=By.id("com.xueqiu.android:id/login_password");
    private By login=By.id("com.xueqiu.android:id/button_next");
    private By weixinlogin=By.id("com.xueqiu.android:id/weixin_login");
    private By back=By.id("com.xueqiu.android:id/iv_action_back");
   
    //账号或密码错误
    By msg=By.id("com.xueqiu.android:id/md_content");

    String message;

    public LoginPage passwordFail(String username, String password){
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(login).click();
        message=find(msg).getText();
        //点击确认按钮
        find(By.id("com.xueqiu.android:id/md_buttonDefaultPositive")).click();
        return this;
    }

    public MainPage passwordSuccess(String username, String password){
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(login).click();
        return new MainPage();
    }

    public String getMessage(){
        return message;
    }

    public ProfilePage gotoProfile(){
        //
        find(By.xpath("//*[contains(@resource-id, 'iv_close') or contains(@resource-id, 'iv_action_back')]")).click();
        return new ProfilePage();
    }

}
