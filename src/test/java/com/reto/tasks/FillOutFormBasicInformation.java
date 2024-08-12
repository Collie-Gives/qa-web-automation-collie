package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.FormPlanPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillOutFormBasicInformation implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Type.theValue(getInstance().getDatosPrueba().get("First_Name")).into(TXT_FIRST_NAME),
                Type.theValue(getInstance().getDatosPrueba().get("Last_Name")).into(TXT_LAST_NAME),
                Type.theValue(getInstance().getDatosPrueba().get("Email_Address")).into(TXT_EMAIL_ADDRESS),
                Type.theValue(getInstance().getDatosPrueba().get("Phone_Number")).into(TXT_PHONE_NUMBER)
        );
        actor.attemptsTo(
                Wait.aTime(3),
                WaitUntil.the(BUTTON_NEXT_FORM_1, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BUTTON_NEXT_FORM_1),
                Wait.aTime(3)
        );
    }

    public static Performable inApp() {
        return Tasks.instrumented(FillOutFormBasicInformation.class);
    }
}
