package com.reto.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/registration.feature",
        glue = "com.reto.stepdefinitions",
        tags = "@regression_registration",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RegisterRunner {
}
