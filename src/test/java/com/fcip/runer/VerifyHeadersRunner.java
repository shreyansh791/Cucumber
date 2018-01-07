package com.fcip.runer;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/VerifyHeaders.feature", glue = { "com/fcip/steps" },
monochrome = true, format={"html:target","json:target/cucumber.json" })
public class VerifyHeadersRunner {

}
