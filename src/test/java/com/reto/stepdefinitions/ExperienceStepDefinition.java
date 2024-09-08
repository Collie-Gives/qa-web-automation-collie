package com.reto.stepdefinitions;

import com.reto.interactions.Wait;
import com.reto.tasks.FillCampaignPages;
import com.reto.tasks.FillExperience;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Visibility;

import java.util.List;
import java.util.Map;

import static com.reto.interactions.SeleniumActions.clickField;
import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.CampaignPages.LABEL_CAMPAIGN_PAGES;
import static com.reto.userinterfaces.CampaignPages.LABEL_EXPERIENCE_LANDING;
import static com.reto.userinterfaces.CreateExperience.*;
import static com.reto.userinterfaces.NewCampaign.LABEL_CAMPAIGN_CREATED;
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
    @And("And add to the experience donation options")
    public void addToTheExperienceDonationOptions(List<Map<String, String>> information) {
        theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_DONATION_OPTIONS)).andIfSo(Click.on(LABEL_DONATION_OPTIONS)));
        for (int i = 0; i < information.size(); i++) {
            getInstance().getDatosPrueba().put("donationAmount", information.get(i).get("donationAmount"));
            getInstance().getDatosPrueba().put("descriptionDonation", information.get(i).get("descriptionDonation"));
            theActorInTheSpotlight().attemptsTo(FillExperience.addDonationsOptions());
        }
    }
    @And("And add to the experience fundraising settings")
    public void addToTheExperienceFundraisingSettings() {
        theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_FUNDRAISING_SETTINGS)).andIfSo(Click.on(LABEL_FUNDRAISING_SETTINGS)));
    }

    @And("And add to the experience store the product")
    public void addToTheExperienceFundraisingSettings(List<Map<String, String>> information) {
        theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_STORE)).andIfSo(Click.on(LABEL_STORE)));
        theActorInTheSpotlight().attemptsTo(clickField("(//span[contains(@class, 'MuiSwitch-switchBase')]//input[@type='checkbox'])[6]"));
        for (int i = 0; i < information.size(); i++) {
            getInstance().getDatosPrueba().put("storeProductName", information.get(i).get("storeProductName"));
            theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(ADD_ITEM_STORE)).andIfSo(Click.on(ADD_ITEM_STORE)));
            theActorInTheSpotlight().attemptsTo(FillExperience.addStore());
        }
    }
    @And("And add to the experience individual fundraising")
    public void addToTheExperienceIndividualFundraising() {
        theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_INDIVIDUAL_FUNDRAISING)).andIfSo(Click.on(LABEL_INDIVIDUAL_FUNDRAISING)));
    }
    @And("And add to the experience team settings {string} maximun team and {string} maximun team members")
    public void addToTheExperienceTeamSetting(String maximunTeam, String maximunTeamMembers) {
        getInstance().getDatosPrueba().put("maximunTeam", maximunTeam);
        getInstance().getDatosPrueba().put("maximunTeamMembers", maximunTeamMembers);
        theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_TEAM_SETTINGS)).andIfSo(Click.on(LABEL_TEAM_SETTINGS)));
        theActorInTheSpotlight().attemptsTo(FillExperience.addTeamSettings());
    }
    @And("And add to the experience bib assignment")
    public void addToTheExperienceBibAssignment(List<Map<String, String>> information) {
        theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_BIB_ASSIGNMENT)).andIfSo(Click.on(LABEL_BIB_ASSIGNMENT)));
        for (int i = 0; i < information.size(); i++) {
            getInstance().getDatosPrueba().put("bibPoolName", information.get(i).get("bibPoolName"));
            getInstance().getDatosPrueba().put("starNumber", information.get(i).get("starNumber"));
            getInstance().getDatosPrueba().put("endNumber", information.get(i).get("endNumber"));
            getInstance().getDatosPrueba().put("allocation", information.get(i).get("allocation"));
            theActorInTheSpotlight().attemptsTo(Wait.aTime(5));
            theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(ADD_BIB_POOL)).andIfSo(Click.on(ADD_BIB_POOL)));
            theActorInTheSpotlight().attemptsTo(FillExperience.addBibPool());
        }
    }
    @And("And add the our story the title {string} and description {string} in experience landing page")
    public void addToCampaignPage(String ourStoryTitle, String ourStoryDescription) {
        getInstance().getDatosPrueba().put("ourStoryTitle", ourStoryTitle);
        getInstance().getDatosPrueba().put("ourStoryDescription", ourStoryDescription);
        theActorInTheSpotlight().attemptsTo(Check.whether(Visibility.of(LABEL_CAMPAIGN_PAGES)).andIfSo(Click.on(LABEL_CAMPAIGN_PAGES)));
        theActorInTheSpotlight().attemptsTo(Ensure.that(LABEL_EXPERIENCE_LANDING).isDisplayed());
        theActorInTheSpotlight().attemptsTo(FillCampaignPages.experienceLanding());
    }

}
