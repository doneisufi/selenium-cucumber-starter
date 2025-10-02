package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.net.URL;
import java.util.HashMap;

public class SampleSteps {

    WebDriver driver;

    @Given("I open the Relyens homepage")
    public void openRelyensHomePage() throws Exception {

        // BrowserStack capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");        // or "Firefox"
        caps.setCapability("browserVersion", "latest");

        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("os", "Windows");
        bstackOptions.put("osVersion", "11");
        bstackOptions.put("sessionName", "Relyens test");
        caps.setCapability("bstack:options", bstackOptions);

        // Set env variables
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

        // Remote WebDriver URL
        driver = new RemoteWebDriver(new URL(
            "https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub"), caps);

        // Open Relyens homepage
        driver.get("https://www.relyens.eu/fr/");
    }

    @Then("I should see the Relyens page title")
    public void checkTitle() {
        String title = driver.getTitle();
        assertTrue(title.contains("Assurance pour la fonction publique"));
        driver.quit();
    }
}
