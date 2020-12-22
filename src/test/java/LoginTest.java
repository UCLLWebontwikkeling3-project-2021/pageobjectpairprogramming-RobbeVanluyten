import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * @author Jerome de Meester en Robbe Vanluyten
 */

public class LoginTest {
    private WebDriver driver;
    private String path = "http://localhost:8080/Servlet";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Toegepaste informatica Jaar Vakken2\\Webontwikkeling3\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }

    public void loginAsUser() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserId("11");
        loginPage.setPassword("1234");
        loginPage.submitValid();
    }

    public void loginAsAdmin() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setUserId("4");
        loginPage.setPassword("admin");
        loginPage.submitValid();
    }
}
