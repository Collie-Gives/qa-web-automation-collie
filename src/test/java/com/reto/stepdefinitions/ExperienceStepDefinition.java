package com.reto.stepdefinitions;

import com.reto.tasks.FillExperience;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static com.reto.models.DataManager.getInstance;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ExperienceStepDefinition {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @And("And add to the campaign the experience {string} {string}")
    public void verifyThatTheCampaignHasBeenCreatedSuccessfully(String experienceName, String experienceCategory) {
        getInstance().getDatosPrueba().put("experienceName", experienceName);
        getInstance().getDatosPrueba().put("experienceCategory", experienceCategory);
        theActorInTheSpotlight().attemptsTo(FillExperience.addExperience());
    }
    @And("And add to the experience images")
    public void addToTheExperienceImages() {
        theActorInTheSpotlight().attemptsTo(FillExperience.addImage());
    }
    @And("And add to the experience general settings")
    public void addToTheExperienceGeneralSettings() {
        theActorInTheSpotlight().attemptsTo(FillExperience.addGeneralSettings());
    }
    @And("And add to the experience registration options with the following data")
    public void addToTheExperienceRegistrationOptions(List<Map<String, String>> information) {
        for (int i = 0; i < information.size(); i++) {
            getInstance().getDatosPrueba().put("registrationName", information.get(i).get("registrationName"));
            getInstance().getDatosPrueba().put("description", information.get(i).get("description"));
            getInstance().getDatosPrueba().put("attendeeCap", information.get(i).get("attendeeCap"));
            getInstance().getDatosPrueba().put("minimumFundraising", information.get(i).get("minimumFundraising"));
            getInstance().getDatosPrueba().put("nameProduct", information.get(i).get("nameProduct"));
            theActorInTheSpotlight().attemptsTo(FillExperience.addRegistrationOptions());
        }
    }
    /*
    @And("And add to the experience {int} registration options with the following data {string} {string} {string} {string}")
    public void addToTheExperienceRegistrationOptions(int numRegister, String registrationName, String description, String attendeeCap, String nameProduct) {
        for (int i = 0; i < numRegister; i++) {

        }
        getInstance().getDatosPrueba().put("registrationName", registrationName);
        getInstance().getDatosPrueba().put("description", description);
        getInstance().getDatosPrueba().put("attendeeCap", attendeeCap);
        getInstance().getDatosPrueba().put("nameProduct", nameProduct);
        theActorInTheSpotlight().attemptsTo(FillExperience.addRegistrationOptions());
    }

     */

}
