package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class membershipStepDefs {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private String generatedEmail;

    @Given("I have used {string} to navigate to website basketball england membership")
    public void iHaveUsedToNavigateToWebsiteBasketballEnglandMembership(String browser) {
        if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @When("I add date of birth")
    public void iAddDateOfBirth() {
        WebElement birthDay = waitForElement(By.id("dp"));
        birthDay.sendKeys("01/01/1976", Keys.ENTER);
    }

    @And("I add First Name")
    public void iAddFirstName() {
        driver.findElement(By.id("member_firstname")).sendKeys("TestAnna");
    }

    @And("I add Last Name")
    public void iAddLastName() {
        driver.findElement(By.id("member_lastname")).sendKeys("Testsson");
    }

    @And("I add email address")
    public void iAddEmailAddress() {
        generatedEmail = "test" + System.currentTimeMillis() + "@mailnesia.com";
        driver.findElement(By.id("member_emailaddress")).sendKeys(generatedEmail);
    }

    @And("I confirm email adress")
    public void iConfirmEmailAdress() {
        WebElement confirmEmail = waitForElement(By.id("member_confirmemailaddress"));
        confirmEmail.sendKeys(generatedEmail);
    }

    @And("I add password")
    public void iAddPassword() {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("testmaster1");
    }

    @And("I retype password")
    public void iRetypePassword() {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("testmaster1");
    }

    @And("I retype wrong password")
    public void iRetypeWrongPassword() {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("testmaster2");
    }

    @And("I click Fan")
    public void iClickFan() {
        driver.findElement(By.cssSelector("label[for='signup_basketballrole_19'] .box")).click();
    }

    @And("I click I have read the Terms and Conditions")
    public void iClickIHaveReadTheTermsAndConditions() {
        driver.findElement(By.cssSelector("label[for='sign_up_25'] .box")).click();
    }

    @And("I click I am aged over {string}")
    public void iClickIAmAgedOver(String arg0) {
        driver.findElement(By.cssSelector("label[for='sign_up_26'] .box")).click();
    }

    @And("I click I have read Code of Ethics and Conduct")
    public void iClickIHaveReadCodeOfEthicsAndConduct() {
        driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct'] .box")).click();
    }

    @And("I click button Confirm and join")
    public void iClickButtonConfirmAndJoin() {
        WebElement confirmButton = waitForElement(By.name("join"));
        confirmButton.click();
    }

    @And("I add my first name {string}")
    public void iAddMyName(String first) {
        driver.findElement(By.id("member_firstname")).sendKeys(first);
    }

    @And("I add my last name {string}")
    public void iAddMyLastName(String last) {
        if (last.trim().isEmpty()) { // Hanterar om last är tom eller bara har mellanslag
            return;
        }
        driver.findElement(By.id("member_lastname")).sendKeys(last);
    }

    @And("I add my password {string}")
    public void iAdd(String password) {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
    }

    @And("I retype my password {string}")
    public void iPassword(String retype) throws InterruptedException {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(retype);
    }

    @Then("I get the result membership")
    public void iGetTheResult() {
        String actualTitle = driver.getTitle();
        String expected = "Basketball England Members Area";
        assertEquals(expected, actualTitle);
    }

    @Then("I should see the error message {string}")
    public void lastNameIsRequired(String expected) {
        WebElement errorElement = driver.findElement(By.cssSelector("span[for='member_lastname']"));
        String actual = errorElement.getText();
        assertEquals(expected, actual);
    }

    @Then("I should see the error text {string}")
    public void confirmTermsAndConditions(String expected) {
        WebElement errorElement = driver.findElement(By.cssSelector("span[for='TermsAccept']"));
        String actual = errorElement.getText();
        assertEquals(expected, actual);
    }

    @Then("I should see error message {string}")
    public void passwordDidNotMatch(String expected) {
        WebElement errorElement = driver.findElement(By.cssSelector("span[for='signupunlicenced_confirmpassword']"));
        String actual = errorElement.getText();
        assertEquals(expected, actual);
    }

    @Then("I get the result {string}")
    public void iGetTheResult(String result) {
        switch (result) {
            case "success":
                assertEquals("Basketball England Members Area", driver.getTitle());
                break;
            case "error":
                verifyErrorMessage(); // Metod som kollar om rätt felmeddelande syns
                break;
            default:
                System.out.println("Unknown test result" ); //Obs För att skriva ut behövs även en mainmetod
        }
    }

    @After
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void verifyErrorMessage() {
        String errorText = "";//Skapar en tom textsträng
        if (isElementPresent(By.cssSelector("span[for='member_lastname']"))) { //Kollar om felmeddelandet för efternamn finns
            errorText = waitForElement(By.cssSelector("span[for='member_lastname']")).getText(); //Hämtar felmeddelade-texten
            assertEquals("Last Name is required", errorText);
        } else if (isElementPresent(By.cssSelector("span[for='signupunlicenced_confirmpassword']"))) {
            errorText = waitForElement(By.cssSelector("span[for='signupunlicenced_confirmpassword']")).getText();//Hämtar felmeddelade-texten
            assertEquals("Password did not match", errorText);
        }
        System.out.println("Error message: " + errorText);//För att skriva ut behövs även en mainmetod
    }

    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);//Om meddelandet hittas, returnera true.
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
