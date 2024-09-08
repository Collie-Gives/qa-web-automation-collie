package com.reto.tasks;

import com.reto.interactions.*;
import com.reto.util.RandomNumber;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

import java.nio.file.Path;

import static com.reto.interactions.SeleniumActions.*;
import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.Home.ICON_CAMPAIGN;
import static com.reto.userinterfaces.NewCampaign.*;
import static com.reto.util.ConstantManager.IMAGE_CAMPAIGN_HERO;
import static com.reto.util.ConstantManager.IMAGE_CAMPAIGN_LOGO;

public class FillCampaign {
    private FillCampaign() {
    }

    public static Performable inApp() {
        return Task.where(actor -> {
            Path imageCampaignLogo = Path.of(IMAGE_CAMPAIGN_LOGO).toAbsolutePath();
            Path imageCampaignHero = Path.of(IMAGE_CAMPAIGN_HERO).toAbsolutePath();
            actor.attemptsTo(RandomNumber.getCurrentTime());
            String nameCampaign = "Campaign Test " + getInstance().getDatosPrueba().get("currentTime");
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Check.whether(Visibility.of(ICON_CAMPAIGN)).andIfSo(Click.on(ICON_CAMPAIGN)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_NEW_CAMPAIGN)).andIfSo(Click.on(BUTTON_NEW_CAMPAIGN)));
            actor.attemptsTo(Enter.theValue(nameCampaign).into(TXT_NAME_CAMPAIGN));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("city")).into(TXT_NAME_CITY));
            actor.attemptsTo(clearAndWriteField("//*[@role='combobox']",getInstance().getDatosPrueba().get("state")));
            actor.attemptsTo(Click.on(OPTION_STATE.of(getInstance().getDatosPrueba().get("state"))));
            actor.attemptsTo(clearAndWriteField("//label[text()='Start Date']",getInstance().getDatosPrueba().get("star_date")));
            actor.attemptsTo(clearAndWriteField("//label[text()='End Date']",getInstance().getDatosPrueba().get("end_date")));
            actor.attemptsTo(clearAndWriteField("//label[text()='Start Time']","12:00 AM"));
            actor.attemptsTo(clearAndWriteField("//label[text()='End Time']","12:00 PM"));
            actor.attemptsTo(Click.on(BOTON_CONTINUE_CAMPAIGN));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Check.whether(Visibility.of(ADD_IMAGEN_CAMPAIGN)).andIfSo(Click.on(ADD_IMAGEN_CAMPAIGN)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(FileUpload.imageFile("//*[@id='fsp-fileUpload']",String.valueOf(imageCampaignLogo)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_UPLOAD)).andIfSo(Click.on(BUTTON_UPLOAD)));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(Check.whether(Visibility.of(ADD_IMAGEN_CAMPAIGN)).andIfSo(Click.on(ADD_IMAGEN_CAMPAIGN)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(FileUpload.imageFile("//*[@id='fsp-fileUpload']",String.valueOf(imageCampaignHero)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_UPLOAD)).andIfSo(Click.on(BUTTON_UPLOAD)));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(Click.on(BOTON_CONTINUE_CAMPAIGN));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Amount (USD)']]",getInstance().getDatosPrueba().get("fundraising")));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Attendees']]",getInstance().getDatosPrueba().get("attendees")));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Teams']]",getInstance().getDatosPrueba().get("teams")));
            actor.attemptsTo(Click.on(BOTON_CREATE_CAMPAIGN));
            actor.attemptsTo(Wait.aTime(5));
        });
    }
}
