package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.FormPlanPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillOutFormCompanyInformation implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Type.theValue(getInstance().getDatosPrueba().get("Company_Name")).into(TXT_COMPANY_NAME));
        actor.attemptsTo(Click.on(TXT_FISCAL_MONTH));
        actor.attemptsTo(Click.on(LIST_FISCAL_MONTH.of(getInstance().getDatosPrueba().get("Fiscal_Year"))));
        actor.attemptsTo(Click.on(TXT_ACCOUNTING_SOFTWARE));
        actor.attemptsTo(Click.on(LIST_ACCOUNTING_SOFTWARE.of(getInstance().getDatosPrueba().get("Accounting_Software"))));
        actor.attemptsTo(Click.on(ICONO_DELETE_COUNTRY));
        actor.attemptsTo(Click.on(TXT_COUNTRY));
        actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("Country")).into(TXT_COUNTRY));
        actor.attemptsTo(Click.on(TXT_STATE));
        actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("State")).into(TXT_STATE));
        actor.attemptsTo(Click.on(TXT_CYTY));
        actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("City")).into(TXT_CYTY));
        actor.attemptsTo(Click.on(TXT_CURRENCY));
        actor.attemptsTo(Click.on(LIST_CURRENCY.of(getInstance().getDatosPrueba().get("Currency"))));
        actor.attemptsTo(Click.on(TXT_CHECK_COMPANY));
        actor.attemptsTo(
                Wait.aTime(3),
                WaitUntil.the(BUTTON_NEXT_FORM_2, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(BUTTON_NEXT_FORM_2),
                Wait.aTime(3)
        );
    }

    public static Performable inApp() {
        return Tasks.instrumented(FillOutFormCompanyInformation.class);
    }
}
