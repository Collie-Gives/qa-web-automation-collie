package com.reto.stepdefinitions;

import com.reto.interactions.AddOption;
import com.reto.interactions.FillPaymentBillingFrame;
import com.reto.interactions.SwagBagSelection;
import com.reto.interactions.Wait;
import com.reto.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.Register.LABEL_THANK_YOU;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DonationStepDefinition {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("The user performs the donation process successfully with the following test data")
    @Step("TEST CASE ERIK")
    public void theUserPerformsTheDonationProcessSuccessfullyWithTheFollowingTestData(List<Map<String, String>> information) {
        getInstance().getDatosPrueba().put("urlDonation", information.get(0).get("urlDonation"));
        getInstance().getDatosPrueba().put("userDonation", information.get(0).get("userDonation"));
        getInstance().getDatosPrueba().put("passwordDonation", information.get(0).get("passwordDonation"));
        getInstance().getDatosPrueba().put("donation_value", information.get(0).get("donation_value"));
        getInstance().getDatosPrueba().put("donation_period", information.get(0).get("donation_period"));
        getInstance().getDatosPrueba().put("employer_match", information.get(0).get("employer_match"));
        getInstance().getDatosPrueba().put("end_date_donation", information.get(0).get("end_date_donation"));
        getInstance().getDatosPrueba().put("number_card", information.get(0).get("number_card"));
        getInstance().getDatosPrueba().put("expiry_date", information.get(0).get("expiry_date"));
        getInstance().getDatosPrueba().put("security_code", information.get(0).get("security_code"));
        getInstance().getDatosPrueba().put("country", information.get(0).get("country"));
        getInstance().getDatosPrueba().put("full_name_billing", information.get(0).get("full_name_billing"));
        getInstance().getDatosPrueba().put("address_line_billing", information.get(0).get("address_line_billing"));
        getInstance().getDatosPrueba().put("city_billing", information.get(0).get("city_billing"));
        getInstance().getDatosPrueba().put("state_billing", information.get(0).get("state_billing"));
        getInstance().getDatosPrueba().put("zip_code_billing", information.get(0).get("zip_code_billing"));

        theActorCalled("User").attemptsTo(Open.url(getInstance().getDatosPrueba().get("urlDonation")));
        theActorInTheSpotlight().attemptsTo(LoginDonation.inApp());
        theActorInTheSpotlight().attemptsTo(FillDonation.inApp());
        theActorInTheSpotlight().attemptsTo(FillPaymentBillingFrame.inAppFrame());
        theActorInTheSpotlight().attemptsTo(Ensure.that(LABEL_THANK_YOU).isDisplayed());

    }

}
