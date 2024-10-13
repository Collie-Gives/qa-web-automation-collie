package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.LoginDonation.*;
import static net.serenitybdd.screenplay.ensure.Ensure.that;


public class LoginDonation {
    private LoginDonation() {
    }

    public static Performable inApp() {
        return Task.where(actor -> {
            actor.attemptsTo(Ensure.that(BUTTON_LOGIN_DONATION).isDisplayed()
                    .orElseThrow(new Throwable("The login button is not visible."))
            );
            actor.attemptsTo(Check.whether(Visibility.of(BUTTON_LOGIN_DONATION)).andIfSo(Click.on(BUTTON_LOGIN_DONATION)));
            actor.attemptsTo(Check.whether(Visibility.of(TXT_EMAIL)).andIfSo(
                    Enter.theValue(getInstance().getDatosPrueba().get("userDonation")).into(TXT_EMAIL))
            );
            actor.attemptsTo(Check.whether(Visibility.of(TXT_PASSWORD)).andIfSo(
                    Enter.theValue(getInstance().getDatosPrueba().get("passwordDonation")).into(TXT_PASSWORD))
            );
            actor.attemptsTo(Click.on(BOTON_LOGIN));
            actor.attemptsTo(Wait.aTime(10));
            actor.attemptsTo(that(IMAGE_OTHER).isDisplayed());
        });
    }
}
