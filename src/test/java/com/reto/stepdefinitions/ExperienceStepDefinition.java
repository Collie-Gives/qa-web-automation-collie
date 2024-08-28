package com.reto.stepdefinitions;

import com.reto.tasks.FillExperience;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

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

}
