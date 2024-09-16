package com.reto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.reto.userinterfaces.Register.*;

public class AddOption {
    private AddOption() {
    }

    public static Performable item(int items) {
        return Task.where(actor -> {
            for (int iterator = 0; iterator < items; iterator++) {
                BUTTON_MAS.resolveAllFor(actor).get(0).click();
                actor.attemptsTo(Wait.aTime(5));
            }
            actor.attemptsTo(Click.on(BUTTON_CONTINUE));
        });
    }
}
