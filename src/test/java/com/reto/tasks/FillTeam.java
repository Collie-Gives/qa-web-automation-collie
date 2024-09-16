package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.reto.interactions.SeleniumActions.clearAndWriteField;
import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.Register.*;
import static com.reto.util.ConstantManager.*;

public class FillTeam {
    private FillTeam() {
    }
    public static Performable inApp() {
        return Task.where(actor -> {
            String optionTeam = getInstance().getDatosPrueba().get("option_team");
            if(optionTeam.equalsIgnoreCase(CREATE_A_TEAM)){
                actor.attemptsTo(Click.on(OPTION_PARTICIPATE.of(CREATE_A_TEAM)));
                actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Team Name']]",getInstance().getDatosPrueba().get("team_name")));
                actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Team Fundraising Goal']]",getInstance().getDatosPrueba().get("team_fundraising_goal")));
                actor.attemptsTo(Check.whether(Visibility.of(BUTTON_CONTINUE)).andIfSo(Click.on(BUTTON_CONTINUE)));
                actor.attemptsTo(Wait.aTime(3));
            } else if (optionTeam.equalsIgnoreCase(JOIN_A_TEAM)) {
                actor.attemptsTo(Click.on(OPTION_PARTICIPATE.of(JOIN_A_TEAM)));
                actor.attemptsTo(Click.on(SELECT_TEAM));
                actor.attemptsTo(Click.on(SELECT_TEAM_OPTIONS.of(getInstance().getDatosPrueba().get("team_name"))));
                actor.attemptsTo(Check.whether(Visibility.of(BUTTON_CONTINUE)).andIfSo(Click.on(BUTTON_CONTINUE)));
                actor.attemptsTo(Wait.aTime(3));
            } else if (optionTeam.equalsIgnoreCase(CONTINUE_WITHOUT_A_TEAM)) {
                actor.attemptsTo(Click.on(OPTION_PARTICIPATE.of(CONTINUE_WITHOUT_A_TEAM)));
                actor.attemptsTo(Wait.aTime(3));
            }
        });
    }

}
