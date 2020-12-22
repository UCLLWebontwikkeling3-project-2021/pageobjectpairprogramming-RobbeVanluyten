import org.openqa.selenium.WebDriver;

/*
 * @author Jerome de Meester en Robbe Vanluyten
 */

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get(path + "?command=Home");
    }
}