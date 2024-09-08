package com.reto.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.reto.userinterfaces.Register.*;

public class AddOption {
    private AddOption() {
    }

    public static Performable item() {
        return Task.where(actor -> {
            List<WebElementFacade> listValue = BOTON_MAS.resolveAllFor(actor);
            for (int iterator = 0; iterator < listValue.size(); iterator++) {
                BOTON_MAS.resolveAllFor(actor).get(0).click();
                actor.attemptsTo(Wait.aTime(5));
                actor.attemptsTo(Click.on(BOTON_CONTINUE));
                break;
            }
        });
    }
}
