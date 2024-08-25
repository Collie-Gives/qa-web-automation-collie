package com.reto.stepdefinitions;

import com.reto.tasks.FillCreateCampaign;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.Home.ICON_CAMPAIGN;
import static com.reto.userinterfaces.Login.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CampaignStepDefinition {
    private String jsonFilePath = "src/test/resources/data.json";

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that login with the following credentials {string}")
    public void thatLoginWithTheFollowingCredentials(String user) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONObject jsonObject = new JSONObject(content);
            if (jsonObject.has(user)) {
                String url = jsonObject.get("url_login").toString();
                String password = jsonObject.getJSONObject(user).get("password").toString();
                String email = jsonObject.getJSONObject(user).get("email").toString();
                getInstance().getDatosPrueba().put("url_login", url);
                getInstance().getDatosPrueba().put("password", password);
                getInstance().getDatosPrueba().put("email", email);
            } else {
                System.out.println("Los valores a buscar no se encontró en el archivo JSON.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        theActorCalled("User").attemptsTo(
                Open.url(getInstance().getDatosPrueba().get("url_login"))
        );
        theActorInTheSpotlight().attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("email")).into(TXT_EMAIL_LOGIN));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("password")).into(TXT_PASSWORD_LOGIN));
        theActorInTheSpotlight().attemptsTo(Click.on(BOTON_LOGIN_LOGIN));
        theActorInTheSpotlight().attemptsTo(Ensure.that(ICON_CAMPAIGN).isDisplayed());
    }


     @When("create a new campaign with the following data")
     public void createNewCampaignWithTheFollowingData(List<Map<String, String>> information) {
         getInstance().getDatosPrueba().put("city", information.get(0).get("city"));
         getInstance().getDatosPrueba().put("state", information.get(0).get("state"));
         getInstance().getDatosPrueba().put("star_date", information.get(0).get("star_date"));
         getInstance().getDatosPrueba().put("end_date", information.get(0).get("end_date"));
         getInstance().getDatosPrueba().put("fundraising", information.get(0).get("fundraising"));
         getInstance().getDatosPrueba().put("attendees", information.get(0).get("attendees"));
         getInstance().getDatosPrueba().put("teams", information.get(0).get("teams"));
         theActorInTheSpotlight().attemptsTo(
                 FillCreateCampaign.inApp()
         );
     }

     /*
    @Then("Payment confirmation is successful")
    public void paymentConfirmationIsSuccessful() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_THANK_YOU).isDisplayed());
    }

     */

}
