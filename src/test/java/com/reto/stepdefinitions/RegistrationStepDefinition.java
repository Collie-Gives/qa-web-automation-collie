package com.reto.stepdefinitions;

import com.reto.tasks.FillPaymentBilling;
import com.reto.tasks.FillRegister;
import com.reto.tasks.LoginRegistration;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.RegisterPage.LABEL_THANK_YOU;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistrationStepDefinition {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that the user open the registering page")
    public void thatTheUserAccessesThePricingPage(List<Map<String, String>> information) {
        getInstance().getDatosPrueba().put("email", information.get(0).get("email"));
        getInstance().getDatosPrueba().put("password", information.get(0).get("password"));
        theActorCalled("User").attemptsTo(
                Open.url("https://bike-maintenance-classes-lqqffg.public-staging.colliegives.com/experience/clz7960lt00m00ajx1ajsfgae/options")
        );
        theActorInTheSpotlight().attemptsTo(
                LoginRegistration.inApp()
        );
    }
     @When("I filling in the entire form with the following data")
     public void iFillingInTheEntireFormWithTheFollowingData(List<Map<String, String>> information) {
         getInstance().getDatosPrueba().put("phone_number", information.get(0).get("phone_number"));
         getInstance().getDatosPrueba().put("gender", information.get(0).get("gender"));
         getInstance().getDatosPrueba().put("address", information.get(0).get("address"));
         getInstance().getDatosPrueba().put("city", information.get(0).get("city"));
         getInstance().getDatosPrueba().put("state", information.get(0).get("state"));
         getInstance().getDatosPrueba().put("zip_code", information.get(0).get("zip_code"));
         getInstance().getDatosPrueba().put("signature_waiver", information.get(0).get("signature_waiver"));
         theActorInTheSpotlight().attemptsTo(
                 FillRegister.inApp()
         );
     }
    @And("I fill in the payment and billing details")
    public void iFillInThePaymentAndBillingDetails(List<Map<String, String>> information) {
        getInstance().getDatosPrueba().put("number_card", information.get(0).get("number_card"));
        getInstance().getDatosPrueba().put("expiry_date", information.get(0).get("expiry_date"));
        getInstance().getDatosPrueba().put("security_code", information.get(0).get("security_code"));
        getInstance().getDatosPrueba().put("country", information.get(0).get("country"));
        getInstance().getDatosPrueba().put("full_name_billing", information.get(0).get("full_name_billing"));
        getInstance().getDatosPrueba().put("address_line_billing", information.get(0).get("address_line_billing"));
        getInstance().getDatosPrueba().put("city_billing", information.get(0).get("city_billing"));
        getInstance().getDatosPrueba().put("state_billing", information.get(0).get("state_billing"));
        getInstance().getDatosPrueba().put("zip_code_billing", information.get(0).get("zip_code_billing"));
        theActorInTheSpotlight().attemptsTo(
                FillPaymentBilling.inAppFrame1()
        );
        theActorInTheSpotlight().attemptsTo(
                FillPaymentBilling.inAppFrame2()
        );
    }
    @Then("Payment confirmation is successful")
    public void paymentConfirmationIsSuccessful() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_THANK_YOU).isDisplayed());
    }

}
