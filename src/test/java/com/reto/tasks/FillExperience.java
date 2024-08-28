package com.reto.tasks;

import com.reto.interactions.FileUpload;
import com.reto.interactions.SwagBagSelection;
import com.reto.interactions.Wait;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

import java.nio.file.Path;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.CreateExperience.*;
import static com.reto.userinterfaces.NewCampaign.*;
import static com.reto.util.ConstantManager.*;

public class FillExperience {
    private FillExperience() {
    }

    public static Performable addExperience() {
        return Task.where(actor -> {
            actor.attemptsTo(Check.whether(Visibility.of(BOTON_MANAGE_CAMPAIGN)).andIfSo(Click.on(BOTON_MANAGE_CAMPAIGN)));
            actor.attemptsTo(Wait.aTime(10));
            actor.attemptsTo(Click.on(BOTON_ADD_EXPERIENCE));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("experienceName")).into(TXT_NAME));
            actor.attemptsTo(Click.on(LIST_CATEGORY));
            actor.attemptsTo(Click.on(OPTION_LIST_CATEGORY.of(getInstance().getDatosPrueba().get("experienceCategory"))));
            actor.attemptsTo(SwagBagSelection.inApp());
            actor.attemptsTo(Click.on(BOTON_CREATE_EXPERIENCE));
            actor.attemptsTo(Wait.aTime(10));
        });
    }
    public static Performable addImage() {
        return Task.where(actor -> {
            Path imageExperience1 = Path.of(IMAGE_EXPERIENCE_ROAD_RUNNING).toAbsolutePath();
            Path imageExperience2 = Path.of(IMAGE_EXPERIENCE_TRAIL_RUN).toAbsolutePath();
            actor.attemptsTo(Click.on(LABEL_EXPERIENCE_IMAGES));
            actor.attemptsTo(Check.whether(Visibility.of(ADD_IMAGE_EXPERIENCE)).andIfSo(Click.on(ADD_IMAGE_EXPERIENCE)));
            actor.attemptsTo(FileUpload.imageFile("//*[@id='fsp-fileUpload']",String.valueOf(imageExperience1)));
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_UPLOAD)).andIfSo(Click.on(BUTTON_UPLOAD)));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(Click.on(LABEL_EXPERIENCE_IMAGES));
            actor.attemptsTo(Check.whether(Visibility.of(ADD_IMAGE_EXPERIENCE)).andIfSo(Click.on(ADD_IMAGE_EXPERIENCE)));
            actor.attemptsTo(FileUpload.imageFile("//*[@id='fsp-fileUpload']",String.valueOf(imageExperience2)));
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_UPLOAD)).andIfSo(Click.on(BUTTON_UPLOAD)));
            actor.attemptsTo(Wait.aTime(7));
        });
    }
    public static Performable addGeneralSettings() {
        return Task.where(actor -> {
            actor.attemptsTo(Click.on(LABEL_GENERAL_SETTINGS));
            Serenity.setSessionVariable("urlGeneralSettings").to(URL_GENERAL_SETTINGS.resolveFor(actor).getText());
            String urlGeneralSettings = Serenity.sessionVariableCalled("urlGeneralSettings");
            System.out.println(urlGeneralSettings);
        });
    }
}
