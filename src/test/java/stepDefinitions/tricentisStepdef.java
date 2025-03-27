package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class tricentisStepdef {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @Given("I have navigated to webshop Tricentis")
    public void iHaveNavigatedToWebshopTricentis() {
        driver = new ChromeDriver();
        //driver.manage().window().maximize(); // Maximizing the window
        driver.get("https://demowebshop.tricentis.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @When("I click at Books")
    public void iClickAtBooks() {
        WebElement findBooks = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/books']")));
        //Hitta Books
        findBooks.click(); //Klicka på texten Books
    }

    @Then("I verify something at the webpage {string}")
    public void iVerifySomethingAtTheWebpage(String expected) {
        WebElement imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='Picture of Computing and Internet']")));
        String actual = imgElement.getAttribute("alt");
        System.out.println("Text: " + actual);
        assertEquals(expected, actual);
    }

    @When("I click at {string}")
    public void iClickAt(String categories) {
        WebElement categoryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/" + categories.toLowerCase() + "']")));
        categoryLink.click();
    }


    @Then("I verify {string} at the webpage")
    public void iVerifyAtTheWebpage(String expected) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img[alt='" + expected + "']")));

        // Hämtar alt-attributet för den hittade bilden och jämför det med det förväntade värdet.
        assertEquals(expected, element.getAttribute("alt"), "Alt-texten matchar inte!");
        System.out.println("Verified: " + expected);
    }

   /* @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
