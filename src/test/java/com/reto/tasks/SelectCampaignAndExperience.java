package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.CreateExperience.LABEL_GENERAL_SETTINGS;
import static com.reto.userinterfaces.CreateExperience.URL_GENERAL_SETTINGS;
import static com.reto.userinterfaces.Home.ICON_CAMPAIGN;
import static com.reto.userinterfaces.LoginRegistration.*;
import static com.reto.userinterfaces.Register.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SelectCampaignAndExperience {
    private SelectCampaignAndExperience() {
    }

    public static Performable inApp() {
        return Task.where(actor -> {
            actor.attemptsTo(Check.whether(Visibility.of(ICON_CAMPAIGN)).andIfSo(Click.on(ICON_CAMPAIGN)));
            actor.attemptsTo(Wait.aTime(8));
            actor.attemptsTo(Click.on(SELECT_CAMPAIGN.of(getInstance().getDatosPrueba().get("name_campaign"))));
            actor.attemptsTo(Click.on(SELECT_EXPERIENCE.of(getInstance().getDatosPrueba().get("name_experience"))));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(Check.whether(Visibility.of(LABEL_GENERAL_SETTINGS)).andIfSo(Click.on(LABEL_GENERAL_SETTINGS)));
            Serenity.setSessionVariable("urlGeneralSettings").to(URL_GENERAL_SETTINGS.resolveFor(actor).getText());
            String urlGeneralSettings = Serenity.sessionVariableCalled("urlGeneralSettings");
            System.out.println(urlGeneralSettings);
        });
    }
}
