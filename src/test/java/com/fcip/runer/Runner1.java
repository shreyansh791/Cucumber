package com.fcip.runer;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "features/Login12.feature" }, glue = { "com/fcip/steps" }, monochrome = true, format = {
		"html:target", "json:target/cucumber.json", "rerun:target/rerun.txt" } // Creates
																				// a
																				// text
																				// file
																				// with
																				// failed
																				// scenarios
)
public class Runner1 {

}
