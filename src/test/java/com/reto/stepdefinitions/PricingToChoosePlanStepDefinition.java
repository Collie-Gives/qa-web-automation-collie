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

public class PricingToChoosePlanStepDefinition {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that the user open the pricing page")
    public void thatTheUserAccessesThePricingPage() {
        theActorCalled("User").attemptsTo(
                Open.url("https://bike-maintenance-classes-lqqffg.public-staging.colliegives.com/experience/clz7960lt00m00ajx1ajsfgae/options")
        );
        theActorInTheSpotlight().attemptsTo(
                FillRegister.inApp()
        );
    }

    @When("I select the {word} and subscribe to the {word}")
    public void selectThePeriod(String period, String plan) {
        theActorInTheSpotlight().attemptsTo(
                SelectPeriod.inApp(period)
        );
        theActorInTheSpotlight().attemptsTo(
                SelectPlan.inApp(plan)
        );
    }

    /*
    @And("I fill out basic information with the following data {word} {word} {word} {word}")
    public void fillOutPlanForm(String First_Name,String Last_Name,String Email_Address,String Phone_Number) {
        ModelData.getMap().put("First_Name", First_Name);
        ModelData.getMap().put("Last_Name", Last_Name);
        ModelData.getMap().put("Email_Address", Email_Address);
        ModelData.getMap().put("Phone_Number", Phone_Number);

        theActorInTheSpotlight().attemptsTo(
                FillOutForm.inApp()
        );
    }
    */

    @And("I fill out basic information {string} {string} {string} {string}")
    public void fillOutBasicInformation(String First_Name,String Last_Name,String Email_Address,String Phone_Number) {
        DataManager.getInstance().getDatosPrueba().put("First_Name",First_Name);
        DataManager.getInstance().getDatosPrueba().put("Last_Name",Last_Name);
        DataManager.getInstance().getDatosPrueba().put("Email_Address",Email_Address);
        DataManager.getInstance().getDatosPrueba().put("Phone_Number",Phone_Number);
        theActorInTheSpotlight().attemptsTo(
                FillOutFormBasicInformation.inApp()
        );;
    }
    @And("I fill out company information {string} {string} {string} {string} {string} {string} {string}")
    public void fillOutCompanyInformation(String Company_Name,String Fiscal_Year,String Accounting_Software,String Country,String State,String City,String Currency) {
        DataManager.getInstance().getDatosPrueba().put("Company_Name",Company_Name);
        DataManager.getInstance().getDatosPrueba().put("Fiscal_Year",Fiscal_Year);
        DataManager.getInstance().getDatosPrueba().put("Accounting_Software",Accounting_Software);
        DataManager.getInstance().getDatosPrueba().put("Country",Country);
        DataManager.getInstance().getDatosPrueba().put("State",State);
        DataManager.getInstance().getDatosPrueba().put("City",City);
        DataManager.getInstance().getDatosPrueba().put("Currency",Currency);
        theActorInTheSpotlight().attemptsTo(
                FillOutFormCompanyInformation.inApp()
        );;
    }

    @And("I fill out payment method {string} {string} {string} {string} {string} {string} {string}")
    public void fillOutPaymentMethod(String Company_Name,String Fiscal_Year,String Accounting_Software,String Country,String State,String City,String Currency) {
        DataManager.getInstance().getDatosPrueba().put("Company_Name",Company_Name);
        DataManager.getInstance().getDatosPrueba().put("Fiscal_Year",Fiscal_Year);
        DataManager.getInstance().getDatosPrueba().put("Accounting_Software",Accounting_Software);
        DataManager.getInstance().getDatosPrueba().put("Country",Country);
        DataManager.getInstance().getDatosPrueba().put("State",State);
        DataManager.getInstance().getDatosPrueba().put("City",City);
        DataManager.getInstance().getDatosPrueba().put("Currency",Currency);
        theActorInTheSpotlight().attemptsTo(
                FillOutFormCompanyInformation.inApp()
        );;
    }

    @Then("Payment confirmation is successful")
    public void paymentConfirmationIsSuccessful() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that("").isEqualTo(""));
    }
}
