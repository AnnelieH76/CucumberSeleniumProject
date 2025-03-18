package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class stepDefsAdd {

    private static WebDriver driver;

    @Given("I have the first number {int}")
    public void iHaveTheFirstNumber(int first) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php");//gettermetod som hämtar sidan
        WebElement consentButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]/p"));
        consentButton.click();
        Thread.sleep(2000); // Vänta kort efter klicket
        WebElement field = driver.findElement(By.name("n01"));
        field.sendKeys(Integer.toString(first));
    }

    @And("I have the second number {int}")
    public void iHaveTheSecondNumber(int second)  throws InterruptedException{
        WebElement field2 = driver.findElement(By.name("n02"));
        field2.sendKeys(Integer.toString(second));
        Thread.sleep(2000); // Vänta kort efter klicket
    }

    @When("I add the numbers")
    public void iAddTheNumbers() {
        driver.findElement(By.cssSelector("[value='Find Addition']")).click();
    }

    @Then("I receive the result {int}")
    public void iReceiveTheResult(int expected) {
        WebElement field = driver.findElement(By.name("answer"));
        String actual = field.getAttribute("value");

        System.out.println("I receive the result: " + actual);

        assertEquals(Integer.toString(expected), actual);
    }

    @After
    public static void tearDown(){
        driver.quit();
    }

}
