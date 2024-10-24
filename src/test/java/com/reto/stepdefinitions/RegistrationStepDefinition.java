package com.reto.stepdefinitions;

import com.reto.interactions.AddOption;
import com.reto.interactions.FillPaymentBillingFrame;
import com.reto.interactions.SwagBagSelection;
import com.reto.interactions.Wait;
import com.reto.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class RegistrationStepDefinition {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    @And("selecting the campaign {string} and experience {string} for registration and ticketing")
    public void selectingCampaignForRegistrationAndTicketing(String name_campaign, String name_experience) {
        getInstance().getDatosPrueba().put("name_campaign", name_campaign);
        getInstance().getDatosPrueba().put("name_experience", name_experience);
        theActorInTheSpotlight().attemptsTo(
                SelectCampaignAndExperience.inApp()
        );
    }
    @And("that the user open the registering page")
    public void thatTheUserAccessesThePricingPage(List<Map<String, String>> information) {
        getInstance().getDatosPrueba().put("userRegistration", information.get(0).get("userRegistration"));
        getInstance().getDatosPrueba().put("passwordRegistration", information.get(0).get("passwordRegistration"));
        if(Serenity.sessionVariableCalled("urlGeneralSettings") == null){
            theActorInTheSpotlight().attemptsTo(Wait.aTime(10));
            theActorInTheSpotlight().attemptsTo(LoginRegistration.inApp());
        }else{
            theActorCalled("User").attemptsTo(Open.url(Serenity.sessionVariableCalled("urlGeneralSettings")));
            theActorInTheSpotlight().attemptsTo(Wait.aTime(10));
            theActorInTheSpotlight().attemptsTo(LoginRegistration.inApp());
        }
    }

    @And("that the user open page")
    public void thatTheUserAccessesPage(List<Map<String, String>> information) {
        getInstance().getDatosPrueba().put("userRegistration", information.get(0).get("userRegistration"));
        getInstance().getDatosPrueba().put("passwordRegistration", information.get(0).get("passwordRegistration"));
        if(Serenity.sessionVariableCalled("urlGeneralSettings") == null){
            theActorInTheSpotlight().attemptsTo(Wait.aTime(10));
            theActorInTheSpotlight().attemptsTo(LoginRegistration.inApp());
        }else{
            theActorCalled("User").attemptsTo(Open.url(Serenity.sessionVariableCalled("urlGeneralSettings")));
            theActorInTheSpotlight().attemptsTo(Wait.aTime(10));
            theActorInTheSpotlight().attemptsTo(LoginRegistration.inApp());
        }
    }
    @And("that the user open the donation page")
    public void thatTheUserAccessesTheDonationPage(List<Map<String, String>> information) {
        getInstance().getDatosPrueba().put("userDonation", information.get(0).get("userDonation"));
        getInstance().getDatosPrueba().put("passwordDonation", information.get(0).get("passwordDonation"));
        theActorInTheSpotlight().attemptsTo(LoginDonation.inApp());
    }
     @When("I fill in the whole form with the following data, selecting items from the first option")
     public void iFillingInTheEntireFormWithTheFollowingData(List<Map<String, String>> information) {
         getInstance().getDatosPrueba().put("name_minor", information.get(0).get("name_minor"));
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
    @And("now choose how you want to participate: {string} with: {string} and {string}")
    public void nowChooseHowYouWantToParticipateOption1(String data1, String data2, String data3) {
        getInstance().getDatosPrueba().put("optionTeam", data1);
        getInstance().getDatosPrueba().put("nameTeam", data2);
        getInstance().getDatosPrueba().put("goalTeam", data3);
        theActorInTheSpotlight().attemptsTo(FillTeam.inApp());
    }
    @And("now choose how you want to participate: {string} with: {string}")
    public void nowChooseHowYouWantToParticipateOption2(String data1, String data2) {
        getInstance().getDatosPrueba().put("optionTeam", data1);
        getInstance().getDatosPrueba().put("nameTeam", data2);
        theActorInTheSpotlight().attemptsTo(FillTeam.inApp());
    }
    @And("now choose how you want to participate")
    public void nowChooseHowYouWantToParticipateOption3(List<Map<String, String>> information) {
        getInstance().getDatosPrueba().put("option_team", information.get(0).get("option_team"));
        getInstance().getDatosPrueba().put("team_name", information.get(0).get("team_name"));
        getInstance().getDatosPrueba().put("team_fundraising_goal", information.get(0).get("team_fundraising_goal"));
        theActorInTheSpotlight().attemptsTo(FillTeam.inApp());
    }
    @And("now swag bag selection")
    public void swagBagSelection() {
        theActorInTheSpotlight().attemptsTo(SwagBagSelection.inApp());
    }
    @And("would you like to buy {int} something?")
    public void wouldYouLikeToBuySomething(int items) {
        theActorInTheSpotlight().attemptsTo(Wait.aTime(5));
        theActorInTheSpotlight().attemptsTo(AddOption.item(items));
        theActorInTheSpotlight().attemptsTo(Wait.aTime(5));
    }
    @And("would you like to make a donation")
    public void wouldYouLikeToMakeDonation(List<Map<String, String>> information) {
        getInstance().getDatosPrueba().put("donation_value", information.get(0).get("donation_value"));
        getInstance().getDatosPrueba().put("donation_period", information.get(0).get("donation_period"));
        getInstance().getDatosPrueba().put("employer_match", information.get(0).get("employer_match"));
        getInstance().getDatosPrueba().put("end_date_donation", information.get(0).get("end_date_donation"));
        theActorInTheSpotlight().attemptsTo(
                FillDonation.inApp()
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
        theActorInTheSpotlight().attemptsTo(FillPaymentBillingFrame.inAppFrame());
    }
    @Then("Payment confirmation is successful")
    public void paymentConfirmationIsSuccessful() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(LABEL_THANK_YOU).isDisplayed());
    }

}
