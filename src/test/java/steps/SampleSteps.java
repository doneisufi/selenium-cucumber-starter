package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class SampleSteps {

    WebDriver driver;

    @Given("I open the Relyens homepage")
    public void openRelyensHomePage() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true); // run in headless mode
        driver = new FirefoxDriver(options);

        // Open the Relyens homepage
        driver.get("https://www.relyens.eu/fr/");
    }

    @Then("I should see the Relyens page title")
    public void checkTitle() {
        String title = driver.getTitle();
        assertEquals("ASSURANCE ET MANAGEMENT DES RISQUES", title); 
        driver.quit();
    }
}
