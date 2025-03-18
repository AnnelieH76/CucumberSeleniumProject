package stepDefinitions;

import common.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    private Calculator calculator;

    @Given("I have two numbers {int} and {int}")
    public void iHaveTwoNumbersAnd(int first, int second) {

        calculator = new Calculator(first, second);
        System.out.println("I have two numbers");
    }

    @When("I add the two numbers")
    public void iAddTheTwoNumbers() {
        calculator.add();
        System.out.println("Adding numbers");
    }

    @Then("I get the result {int}")
    public void iGetTheResult(int expected) {
        int actual= calculator.getResult();
        assertEquals(expected,actual);
    }
}
