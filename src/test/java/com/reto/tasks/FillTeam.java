package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.reto.interactions.SeleniumActions.clearAndWriteField;
import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.CampaignPages.*;
import static com.reto.userinterfaces.Register.*;
import static com.reto.userinterfaces.Register.BOTON_REGISTER_NOW;
import static com.reto.util.ConstantManager.*;

public class FillTeam {
    private FillTeam() {
    }
    public static Performable inApp() {
        return Task.where(actor -> {
            String optionTeam = getInstance().getDatosPrueba().get("optionTeam");
            if(optionTeam.equalsIgnoreCase(CREATE_A_TEAM)){
                actor.attemptsTo(Click.on(OPTION_PARTICIPATE.of(CREATE_A_TEAM)));
                actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Team Name']]",getInstance().getDatosPrueba().get("nameTeam")));
                actor.attemptsTo(clearAndWriteField("//fieldset[legend/span[text()='Team Fundraising Goal']]",getInstance().getDatosPrueba().get("goalTeam")));
                actor.attemptsTo(Check.whether(Visibility.of(BOTON_CONTINUE)).andIfSo(Click.on(BOTON_CONTINUE)));
            } else if (optionTeam.equalsIgnoreCase(JOIN_A_TEAM)) {
                actor.attemptsTo(Click.on(OPTION_PARTICIPATE.of(JOIN_A_TEAM)));
                //falta campo para seleccionar el equipo
            } else if (optionTeam.equalsIgnoreCase(CONTINUE_WITHOUT_A_TEAM)) {
                actor.attemptsTo(Click.on(OPTION_PARTICIPATE.of(CONTINUE_WITHOUT_A_TEAM)));
            }
        });
    }

}
