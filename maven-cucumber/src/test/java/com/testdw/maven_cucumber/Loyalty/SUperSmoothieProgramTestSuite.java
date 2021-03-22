package com.testdw.maven_cucumber.Loyalty;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= "pretty", features = "classpath:features/loyalty_cards",  glue = "com.testdw.maven_cucumber")
public class SUperSmoothieProgramTestSuite {

	
}
