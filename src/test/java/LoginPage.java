import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Jerome de Meester en Robbe Vanluyten
 */

public class LoginPage extends Page {

    @FindBy(id="logInPersonid")
    private WebElement userIdField;

    @FindBy(id="logInPassword")
    private WebElement passwordField;

    @FindBy(id="logIN")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get(path + "?command=Home");
    }

    public void setUserId(String userId) {
        userIdField.clear();
        userIdField.sendKeys(userId);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public HomePage submitValid() {
        logInButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }
    public void loginAsUser() {
        setUserId("11");
        setPassword("1234");
        submitValid();
    }

    public void loginAsAdmin() {
        setUserId("4");
        setPassword("admin");
        submitValid();
    }

}
