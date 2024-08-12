package com.reto.tasks;

import com.reto.interactions.AddOption;
import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.type.Type;

import static com.reto.userinterfaces.RegisterPage.*;

public class FillRegister {
    private FillRegister() {
    }
    public static Performable inApp() {
        return Task.where(actor -> {
            actor.attemptsTo(Enter.theValue("erik.agudelo@wearedev.co").into(TXT_EMAIL));
            actor.attemptsTo(Enter.theValue("Sebastian18+").into(TXT_PASSWORD));
            actor.attemptsTo(Click.on(BOTON_LOGIN));
            actor.attemptsTo(Wait.aTime(10));
            actor.attemptsTo(AddOption.item());

            actor.attemptsTo(Click.on(COMBOBOX_GENDER));
            actor.attemptsTo(Click.on(SELECT_GENDER));
            actor.attemptsTo(Enter.theValue("Calle 75").into(TXT_ADDRESS));
            actor.attemptsTo(Enter.theValue("Miami").into(TXT_CITY));
            actor.attemptsTo(Click.on(TXT_STATE));
            actor.attemptsTo(Type.theValue("Florida").into(TXT_STATE));
            actor.attemptsTo(Click.on(STATE));
            actor.attemptsTo(Click.on(TXT_ZIP_CODE));
            actor.attemptsTo(Type.theValue("33101").into(TXT_ZIP_CODE));
            actor.attemptsTo(Click.on(CHECK_WAIVER));
            actor.attemptsTo(Enter.theValue("Erik Test").into(SIGNATURE_WAIVER));

            actor.attemptsTo(Click.on(BOTON_CONTINUE));
            actor.attemptsTo(Click.on(BOTON_CONTINUE_WITHOUT_TEAM));
            //actor.attemptsTo(Click.on(CHECK_SWAG_BAG));
            actor.attemptsTo(Click.on(BOTON_CONTINUE));
            actor.attemptsTo(Click.on(BOTON_CONTINUE));
            actor.attemptsTo(Click.on(BOTON_SKIP));
            actor.attemptsTo(Click.on(TXT_NUMBER_CARD));
            actor.attemptsTo(Enter.theValue("4242 4242 4242 4242").into(TXT_NUMBER_CARD));
            actor.attemptsTo(Wait.aTime(10));
        });
    }
}