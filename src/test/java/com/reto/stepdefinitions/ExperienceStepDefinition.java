package com.reto.stepdefinitions;

import com.reto.tasks.FillExperience;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

import java.util.List;
import java.util.Map;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.CreateExperience.LABEL_DONATION_SETTINGS;
import static com.reto.userinterfaces.CreateExperience.LABEL_REGISTRATION_OPTIONS;
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
        theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_REGISTRATION_OPTIONS)).andIfSo(Click.on(LABEL_REGISTRATION_OPTIONS)));
        for (int i = 0; i < information.size(); i++) {
            getInstance().getDatosPrueba().put("registrationName", information.get(i).get("registrationName"));
            getInstance().getDatosPrueba().put("description", information.get(i).get("description"));
            getInstance().getDatosPrueba().put("attendeeCap", information.get(i).get("attendeeCap"));
            getInstance().getDatosPrueba().put("minimumFundraising", information.get(i).get("minimumFundraising"));
            getInstance().getDatosPrueba().put("nameProduct", information.get(i).get("nameProduct"));
            theActorInTheSpotlight().attemptsTo(FillExperience.addRegistrationOptions());
        }
    }
    @And("And add to the experience early bird registration {string}")
    public void addToTheExperienceEarlyBirdRegistration(String urlCode) {
        getInstance().getDatosPrueba().put("urlCode", urlCode);
        theActorInTheSpotlight().attemptsTo(FillExperience.addEarlyBirdUrlCode());
    }
    @And("And add to the experience waiver {string}")
    public void addToTheExperienceWaiver(String waiverDescription) {
        getInstance().getDatosPrueba().put("waiverDescription", waiverDescription);
        theActorInTheSpotlight().attemptsTo(FillExperience.addWaiver());
    }
    @And("And add to the experience donation settings")
    public void addToTheExperienceDonationSettings() {
        theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_DONATION_SETTINGS)).andIfSo(Click.on(LABEL_DONATION_SETTINGS)));
    }


}
