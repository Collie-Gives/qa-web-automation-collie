package com.reto.tasks;

import com.reto.interactions.AddOption;
import com.reto.interactions.SwagBagSelection;
import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.type.Type;

import static com.reto.userinterfaces.RegisterPage.*;

public class FillRegister {
    private FillRegister() {
    }
    public static Performable inApp(String email, String password, String gender, String address, String city, String state, String zip_code, String signature_waiver) {
        return Task.where(actor -> {
            actor.attemptsTo(Enter.theValue(email).into(TXT_EMAIL));
            actor.attemptsTo(Enter.theValue(password).into(TXT_PASSWORD));
            actor.attemptsTo(Click.on(BOTON_LOGIN));
            actor.attemptsTo(Wait.aTime(7));

            actor.attemptsTo(AddOption.item());

            actor.attemptsTo(Click.on(COMBOBOX_GENDER));
            actor.attemptsTo(Click.on(SELECT_GENDER.of(gender)));
            actor.attemptsTo(Enter.theValue(address).into(TXT_ADDRESS));
            actor.attemptsTo(Enter.theValue(city).into(TXT_CITY));
            actor.attemptsTo(Click.on(TXT_STATE));
            actor.attemptsTo(SendKeys.of(state).into(TXT_STATE));
            actor.attemptsTo(Click.on(STATE));
            actor.attemptsTo(Click.on(TXT_ZIP_CODE));
            actor.attemptsTo(Type.theValue(zip_code).into(TXT_ZIP_CODE));
            actor.attemptsTo(Click.on(CHECK_WAIVER));
            actor.attemptsTo(Enter.theValue(signature_waiver).into(SIGNATURE_WAIVER));
            actor.attemptsTo(Click.on(BOTON_CONTINUE));
            actor.attemptsTo(Click.on(BOTON_CONTINUE_WITHOUT_TEAM));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(SwagBagSelection.inApp());
            actor.attemptsTo(Click.on(BOTON_CONTINUE));
            actor.attemptsTo(Click.on(BOTON_CONTINUE));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(Click.on(BOTON_SKIP));
            actor.attemptsTo(Wait.aTime(7));
        });
    }
}
