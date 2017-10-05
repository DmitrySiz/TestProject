import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class WebTests {
    private String loginFail = "qwerty";
    private String passwordFail = "qwerty1234";
    static WebDriver driver;
    @BeforeClass
    public static void start(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void internetBankLoginFail() throws InterruptedException {
        IbPage ibPage = new IbPage(driver,loginFail,passwordFail);
        ibPage.gotoIbPage();
        ibPage.enterLogin(loginFail);
        ibPage.enterPassword(passwordFail);
        ibPage.clickEnterButton();
        Assert.assertTrue("Сообщение об ошибке отсутствует",ibPage.checkFailMessage());
    }

    @AfterClass
    public static void end(){
        driver.quit();
    }
}
