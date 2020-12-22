import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/*
 * @author Jerome de Meester en Robbe Vanluyten
 */


public class PersonOverviewTest {
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

    @Test
    public void test_Overview_NotLoggedIn_ShowsError() {
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.hasErrorMessage("You have insufficient rights to have a look at the requested page."));
    }

    @Test
    public void test_Overview_LoggedInAsUser_ShowsError() {
       LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginAsUser();
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Home", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.hasErrorMessage("You have insufficient rights to have a look at the requested page."));
    }

    @Test
    public void test_Overview_LoggedInAsAdmin_ShowsOverviewPage() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginAsAdmin();
        PersonOverviewPage personOverviewPage = PageFactory.initElements(driver, PersonOverviewPage.class);
        assertEquals("Overview", personOverviewPage.getTitle());
        assertTrue(personOverviewPage.containsUserWithEmail("admin@gmail.com"));
        assertTrue(personOverviewPage.containsUserWithFirstName("ADMIN"));
        assertTrue(personOverviewPage.containsUserWithLastName("ADMIN"));
    }


}
