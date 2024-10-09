package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.reto.interactions.SeleniumActions.*;
import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.Register.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FillDonation {
    private FillDonation() {
    }
    public static Performable inApp() {
        return Task.where(actor -> {
            String optionDonation = getInstance().getDatosPrueba().get("donation_value");
            String optionPeriod = getInstance().getDatosPrueba().get("donation_period");
            String employerMatch = getInstance().getDatosPrueba().get("employer_match");
            String endDate = getInstance().getDatosPrueba().get("end_date_donation");

            switch (optionDonation) {
                case "0" -> {
                    actor.attemptsTo(Click.on(BUTTON_SKIP));
                    theActorInTheSpotlight().attemptsTo(Wait.aTime(8));
                }
                case "50" -> {
                    actor.attemptsTo(clickField("//*[@data-test='donationOptionBubble']//span[text()='50']"));
                    actor.attemptsTo(clickField("//*[@data-test='donationOptions']/*[@data-test='"+optionPeriod+"']"));
                    if(endDate != null){
                        actor.attemptsTo(clearAndWriteField("//*[@data-test='donationOtherItem']", optionDonation));
                    }
                    if(employerMatch != null){
                        actor.attemptsTo(writeFieldMoreDownArrowMoreEnter("//*[@id='donationFormIntegrationCompany']",employerMatch));
                        actor.attemptsTo(clickField("//*[@data-test='donationOptionBubble']//span[text()='50']"));
                    }
                    actor.attemptsTo(Click.on(BUTTON_CONTINUE));
                    actor.attemptsTo(Wait.aTime(8));
                }
                case "75" -> {
                    actor.attemptsTo(clickField("//*[@data-test='donationOptionBubble']//span[text()='75']"));
                    actor.attemptsTo(clickField("//*[@data-test='donationOptions']/*[@data-test='"+optionPeriod+"']"));
                    if(endDate != null){
                        actor.attemptsTo(clearAndWriteField("//*[@data-test='donationOtherItem']", optionDonation));
                    }
                    if(employerMatch != null){
                        actor.attemptsTo(writeFieldMoreDownArrowMoreEnter("//*[@id='donationFormIntegrationCompany']",employerMatch));
                        actor.attemptsTo(clickField("//*[@data-test='donationOptionBubble']//span[text()='50']"));
                    }
                    actor.attemptsTo(Click.on(BUTTON_CONTINUE));
                    theActorInTheSpotlight().attemptsTo(Wait.aTime(8));
                }
                case "100" -> {
                    actor.attemptsTo(clickField("//*[@data-test='donationOptionBubble']//span[text()='100']"));
                    actor.attemptsTo(clickField("//*[@data-test='donationOptions']/*[@data-test='"+optionPeriod+"']"));
                    if(endDate != null){
                        actor.attemptsTo(clearAndWriteField("//*[@data-test='donationOtherItem']", optionDonation));
                    }
                    if(employerMatch != null){
                        actor.attemptsTo(writeFieldMoreDownArrowMoreEnter("//*[@id='donationFormIntegrationCompany']",employerMatch));
                        actor.attemptsTo(clickField("//*[@data-test='donationOptionBubble']//span[text()='50']"));
                    }
                    actor.attemptsTo(Click.on(BUTTON_CONTINUE));
                    theActorInTheSpotlight().attemptsTo(Wait.aTime(8));
                }
                case "150" -> {
                    actor.attemptsTo(clickField("//*[@data-test='donationOptionBubble']//span[text()='150']"));
                    actor.attemptsTo(clickField("//*[@data-test='donationOptions']/*[@data-test='"+optionPeriod+"']"));
                    if(endDate != null){
                        actor.attemptsTo(clearAndWriteField("//*[@data-test='donationOtherItem']", optionDonation));
                    }
                    if(employerMatch != null){
                        actor.attemptsTo(writeFieldMoreDownArrowMoreEnter("//*[@id='donationFormIntegrationCompany']",employerMatch));
                        actor.attemptsTo(clickField("//*[@data-test='donationOptionBubble']//span[text()='50']"));
                    }
                    actor.attemptsTo(Click.on(BUTTON_CONTINUE));
                    theActorInTheSpotlight().attemptsTo(Wait.aTime(8));
                }
                default -> {
                    actor.attemptsTo(clickField("//*[@data-test='donationOtherItem']"));
                    actor.attemptsTo(clearAndWriteField("//*[@data-test='donationOtherItem']", optionDonation));
                    actor.attemptsTo(clickField("//*[@data-test='donationOptions']/*[@data-test='"+optionPeriod+"']"));
                    if(endDate != null){
                        actor.attemptsTo(clearAndWriteField("//*[@data-test='donationOtherItem']", optionDonation));
                    }
                    if(employerMatch != null){
                        actor.attemptsTo(writeFieldMoreDownArrowMoreEnter("//*[@id='donationFormIntegrationCompany']",employerMatch));
                        actor.attemptsTo(clickField("//*[@data-test='donationOptionBubble']//span[text()='50']"));
                    }
                    actor.attemptsTo(Click.on(BUTTON_CONTINUE));
                    theActorInTheSpotlight().attemptsTo(Wait.aTime(10));
                }
            }
        });
    }

}
