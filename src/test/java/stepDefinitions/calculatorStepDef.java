package stepDefinitions;

import common.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculatorStepDef {
    private Calculator calculator;

    @Given("I have two numbers {double} and {double}")
    public void iHaveTwoNumbersAnd(double first, double second) {
        calculator = new Calculator(first, second);
        System.out.println("I have two numbers");
    }

    @When("I add the two numbers")
    public void iAddTheTwoNumbers() {
        calculator.add();
        System.out.println("Adding numbers");
    }

    @When("I subtract the two numbers")
    public void iSubtractTheTwoNumbers() {
        calculator.sub();
    }

    @Then("I get a {double}")
    public void iGetTheResult(double expected) {
        double actual= calculator.getResult();
        System.out.println("Resultatet är: " + actual);
        assertEquals(expected,actual);
    }
    //test
}

