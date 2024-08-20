package com.reto.tasks;

import com.reto.interactions.AddOption;
import com.reto.interactions.SwagBagSelection;
import com.reto.interactions.Wait;
import com.reto.models.DataManager;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actions.type.Type;
import org.openqa.selenium.Keys;

import static com.reto.models.DataManager.*;
import static com.reto.userinterfaces.RegisterPage.*;

public class FillRegister {
    private FillRegister() {
    }
    public static Performable inApp() {
        return Task.where(actor -> {
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("email")).into(TXT_EMAIL));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("password")).into(TXT_PASSWORD));
            actor.attemptsTo(Click.on(BOTON_LOGIN));
            actor.attemptsTo(Wait.aTime(7));
            actor.attemptsTo(AddOption.item());
            actor.attemptsTo(Click.on(COMBOBOX_GENDER));
            actor.attemptsTo(Click.on(SELECT_GENDER.of(getInstance().getDatosPrueba().get("gender"))));

            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.CONTROL, "a")).into(TXT_ADDRESS));
            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.BACK_SPACE)).into(TXT_ADDRESS));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("address")).into(TXT_ADDRESS));

            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.CONTROL, "a")).into(TXT_CITY));
            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.BACK_SPACE)).into(TXT_CITY));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("city")).into(TXT_CITY));

            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.CONTROL, "a")).into(TXT_STATE));
            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.BACK_SPACE)).into(TXT_STATE));
            actor.attemptsTo(SendKeys.of(getInstance().getDatosPrueba().get("state")).into(TXT_STATE));
            actor.attemptsTo(Click.on(STATE));

            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.CONTROL, "a")).into(TXT_ZIP_CODE));
            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.BACK_SPACE)).into(TXT_ZIP_CODE));
            actor.attemptsTo(Type.theValue(getInstance().getDatosPrueba().get("zip_code")).into(TXT_ZIP_CODE));

            actor.attemptsTo(Click.on(CHECK_WAIVER));

            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.CONTROL, "a")).into(SIGNATURE_WAIVER));
            actor.attemptsTo(SendKeys.of(Keys.chord(Keys.BACK_SPACE)).into(SIGNATURE_WAIVER));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("signature_waiver")).into(SIGNATURE_WAIVER));

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
