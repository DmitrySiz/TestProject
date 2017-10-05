import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class IbPage{
    private WebDriver webDriver;
    private String login;
    private String password;
    private final String URL = "https://ib.rencredit.ru/#/login";

    @FindBy(name = "username")
    WebElement loginField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(css = ".transfer_sms-confirmation_cell > button")
    WebElement buttonEnter;

    @FindBy(css = "div.empty-data-error > div.empty-data-error__text")
    WebElement failMessage;

    IbPage(WebDriver webDriver, String login, String password) {
        this.webDriver = webDriver;
        this.login = login;
        this.password = password;
        PageFactory.initElements(webDriver, this);
    }


    void gotoIbPage() {
        webDriver.get(URL);
    }

    void enterLogin(String login) {
        ExpectedConditions.elementToBeClickable(loginField);
        loginField.clear();
        loginField.sendKeys(login);
    }

    void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    void clickEnterButton() throws InterruptedException {
        Thread.sleep(1000);
        buttonEnter.click();
    }

    Boolean checkFailMessage() {
        return failMessage.isDisplayed();
    }
}
