package com.reto.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/registration_selecting_campaign.feature",
        glue = "com.reto.stepdefinitions",
        tags = "@E2E_REGISTRATION_SELECTING_CAMPAIGN",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RegisterSelectCampaignRunner {
}
