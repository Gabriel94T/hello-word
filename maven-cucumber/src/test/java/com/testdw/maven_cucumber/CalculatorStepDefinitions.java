package com.testdw.maven_cucumber;

import static org.assertj.core.api.Assertions.assertThat;

import com.testdw.maven_cucumber.calculator.Calculator;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorStepDefinitions {
	
	Calculator calculator;
	int result;
	
	@Given("^I have a calculator$")
	public void i_have_a_calculator()  {
	   calculator = new Calculator();
	}

	@When("^I add (\\d+) and (\\d+)$")
	public void i_add_and(int a, int b)  {
	    result = calculator.add(a,b);
	}

	@Then("^I should get (\\d+)$")
	public void i_should_get(int expectedResult)  {
	    assertThat(result).isEqualTo(expectedResult);
	}
	
	

}
