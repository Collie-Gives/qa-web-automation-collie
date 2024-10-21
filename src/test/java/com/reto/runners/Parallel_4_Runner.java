package com.reto.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.reto.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/cucumber.json"
        },
        //tags = "@validation_users_register or @validation_users_donation",
        tags = "@validation_users_register_group_2",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Parallel_4_Runner {
}
