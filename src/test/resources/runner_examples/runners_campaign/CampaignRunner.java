package features.runner_examples.runners_campaign;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/create_campaign.feature",
        glue = "com.reto.stepdefinitions",
        tags = "@regression",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CampaignRunner {
}
