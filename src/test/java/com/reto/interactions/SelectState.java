package com.reto.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.reto.userinterfaces.Register.*;

public class SelectState {
    private SelectState() {
    }

    public static Performable item() {
        return Task.where(actor -> {
            actor.attemptsTo(Click.on(TXT_STATE));
            List<WebElementFacade> listaValores = TXT_STATE.resolveAllFor(actor);
            for (int iterador = 0; iterador < listaValores.size(); iterador++) {
                String datoUI = listaValores.get(iterador).getValue();
                boolean datoEnable = listaValores.get(iterador).isEnabled();
                //if((datoUI.contains(producto) && datoEnable)){
                BUTTON_MAS.resolveAllFor(actor).get(0).click();
                actor.attemptsTo(Wait.aTime(5));
                actor.attemptsTo(Click.on(BUTTON_CONTINUE));
                    break;
                //}
            }
        });
    }
}
