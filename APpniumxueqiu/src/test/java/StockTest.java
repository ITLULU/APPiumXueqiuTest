import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;
import page.StockPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StockTest {

    static MainPage mainPage;
    static StockPage stockPage;

    @BeforeAll
    static void beforeAll(){
        mainPage=MainPage.start();
        stockPage=mainPage.gotoStock();
    }
    @Test
    void 投资达人() {
    	stockPage.投资达人();
    }
    @Test
    void selectone() {
    	stockPage.selectone();
    }
    @Test
    void addselect() {
    	stockPage.addselect();
    }
    @Test
    void 查看评论() {
    	stockPage.查看评论();
    }
}
