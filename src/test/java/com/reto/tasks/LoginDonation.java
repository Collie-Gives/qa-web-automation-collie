package com.reto.tasks;

import com.reto.exceptions.WebException;
import com.reto.interactions.SwagBagSelection;
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
import static com.reto.userinterfaces.LoginDonation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginDonation {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginDonation.class);

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

            boolean labelMessage = LABEL_INCORRECT_EMAIL_PASSWORK.resolveFor(actor).isVisible();
            if (labelMessage) {
                LOGGER.info("Authentication was failed by Incorrect email or password");
                throw new AssertionError("Authentication failed due to incorrect email or password.");
            }

            //actor.attemptsTo(that(IMAGE_OTHER).isDisplayed());
        });
    }
}
