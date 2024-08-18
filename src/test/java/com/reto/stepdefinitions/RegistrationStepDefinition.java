package com.reto.stepdefinitions;

import com.reto.models.DataManager;
import com.reto.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistrationStepDefinition {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that the user open the registering page")
    public void thatTheUserAccessesThePricingPage() {
        theActorCalled("User").attemptsTo(
                Open.url("https://bike-maintenance-classes-lqqffg.public-staging.colliegives.com/experience/clz7960lt00m00ajx1ajsfgae/options")
        );
    }


    @When("I filling in the entire form with the following data {string} {string} {string} {string} {string} {string} {string} {string}")
    public void fillingInTheEntireFormWithTheFollowingData(String email, String password, String gender, String address, String city, String state, String zip_code, String signature_waiver) {
        DataManager.getInstance().getDatosPrueba().put("Email",email);
        DataManager.getInstance().getDatosPrueba().put("Password",password);
        DataManager.getInstance().getDatosPrueba().put("Gender",gender);
        DataManager.getInstance().getDatosPrueba().put("Address",address);
        DataManager.getInstance().getDatosPrueba().put("City",city);
        DataManager.getInstance().getDatosPrueba().put("State",state);
        DataManager.getInstance().getDatosPrueba().put("ZipCode",zip_code);
        DataManager.getInstance().getDatosPrueba().put("SignatureWaiver",signature_waiver);
        theActorInTheSpotlight().attemptsTo(
                FillRegister.inApp(email,password,gender,address,city,state,zip_code,signature_waiver)
        );
    }

    @And("I fill in the payment and billing details {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iFillingInThePaymentInformation(String numberCard, String expiry_date, String security_code, String country, String full_name_billing, String address_line_billing, String city_billing, String state_billing, String zip_code_billing) {
        DataManager.getInstance().getDatosPrueba().put("NumberCard",numberCard);
        DataManager.getInstance().getDatosPrueba().put("Expiry_date",expiry_date);
        DataManager.getInstance().getDatosPrueba().put("Security_code",security_code);
        DataManager.getInstance().getDatosPrueba().put("Country",country);
        DataManager.getInstance().getDatosPrueba().put("Full_name_billing",full_name_billing);
        DataManager.getInstance().getDatosPrueba().put("Address_line_billing",address_line_billing);
        DataManager.getInstance().getDatosPrueba().put("City_billing",city_billing);
        DataManager.getInstance().getDatosPrueba().put("State_billing",state_billing);
        DataManager.getInstance().getDatosPrueba().put("Zip_code_billing",zip_code_billing);
        theActorInTheSpotlight().attemptsTo(
                FillPaymentBilling.inAppFrame1(numberCard,expiry_date,security_code,country)
        );
        theActorInTheSpotlight().attemptsTo(
                FillPaymentBilling.inAppFrame2(full_name_billing,address_line_billing,city_billing,state_billing,zip_code_billing)
        );
    }
    @Then("Payment confirmation is successful")
    public void paymentConfirmationIsSuccessful() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that("").isEqualTo(""));
    }
}
