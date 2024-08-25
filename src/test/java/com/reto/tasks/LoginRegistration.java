package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.LoginRegistrationPage.*;
import static com.reto.userinterfaces.RegisterPage.BOTON_CONTINUE;

public class LoginRegistration {
    private LoginRegistration() {
    }

    public static Performable inApp() {
        return Task.where(actor -> {
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("email")).into(TXT_EMAIL));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("password")).into(TXT_PASSWORD));
            actor.attemptsTo(Click.on(BOTON_LOGIN));
            actor.attemptsTo(Wait.aTime(8));
            actor.attemptsTo(Ensure.that(BOTON_CONTINUE).isDisplayed());
        });
    }
}
