package com.reto.tasks;

import com.reto.interactions.FillPaymentBillingFrame;
import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.reto.interactions.SeleniumActions.clearAndWriteField;
import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.CampaignPages.*;
import static com.reto.userinterfaces.NewCampaign.BUTTON_NEW_CAMPAIGN;

public class FillCampaignPages {
    private FillCampaignPages() {
    }
    public static Performable experienceLanding() {
        return Task.where(actor -> {
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_EDIT_EXPERIENCE_LANDING)).andIfSo(Click.on(BUTTON_EDIT_EXPERIENCE_LANDING)));
            actor.attemptsTo(Wait.aTime(5));
            actor.attemptsTo(Click.on(BUTTON_CONTENT));
            actor.attemptsTo(Click.on(LABEL_OUR_STORY));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Title']]",getInstance().getDatosPrueba().get("ourStoryTitle")));
            actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Description']]",getInstance().getDatosPrueba().get("ourStoryDescription")));
            actor.attemptsTo(Click.on(BOTON_SAVE));
            actor.attemptsTo(Click.on(BOTON_EXIT_EDITOR));
            actor.attemptsTo(Wait.aTime(5));
        });
    }

}
