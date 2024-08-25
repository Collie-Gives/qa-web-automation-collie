package com.reto.tasks;

import com.reto.interactions.SeleniumActions;
import com.reto.interactions.SwagBagSelection;
import com.reto.interactions.Wait;
import com.reto.util.RandomNumber;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.type.Type;
import org.openqa.selenium.Keys;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.Home.ICON_CAMPAIGN;
import static com.reto.userinterfaces.NewCampaign.*;
import static com.reto.userinterfaces.RegisterPage.*;

public class FillCreateCampaign {
    private FillCreateCampaign() {
    }

    public static Performable inApp() {
        return Task.where(actor -> {
            actor.attemptsTo(RandomNumber.getCurrentTime());
            String nameCampaign = "Campaing Test " + getInstance().getDatosPrueba().get("currentTime");
            actor.attemptsTo(Click.on(ICON_CAMPAIGN));
            actor.attemptsTo(Click.on(BUTTON_NEW_CAMPAIGN));
            actor.attemptsTo(Enter.theValue(nameCampaign).into(TXT_NAME_CAMPAIGN));
            actor.attemptsTo(Enter.theValue(nameCampaign).into(TXT_NAME_CITY));






            actor.attemptsTo(SeleniumActions.clearAndWriteField("//*[@data-test='Phone Number']", getInstance().getDatosPrueba().get("phone_number")));

            actor.attemptsTo(Click.on(COMBOBOX_GENDER));
            actor.attemptsTo(Click.on(SELECT_GENDER.of(getInstance().getDatosPrueba().get("gender"))));

            actor.attemptsTo(Click.on(TXT_ADDRESS));
            actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(TXT_ADDRESS));
            actor.attemptsTo(SendKeys.of(Keys.DELETE).into(TXT_ADDRESS));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("address")).into(TXT_ADDRESS));

            actor.attemptsTo(Click.on(TXT_CITY));
            actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(TXT_CITY));
            actor.attemptsTo(SendKeys.of(Keys.DELETE).into(TXT_CITY));
            actor.attemptsTo(Enter.theValue(getInstance().getDatosPrueba().get("city")).into(TXT_CITY));

            actor.attemptsTo(Click.on(TXT_STATE));
            actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(TXT_STATE));
            actor.attemptsTo(SendKeys.of(Keys.DELETE).into(TXT_STATE));
            actor.attemptsTo(SendKeys.of(getInstance().getDatosPrueba().get("state")).into(TXT_STATE));
            actor.attemptsTo(Click.on(STATE));

            actor.attemptsTo(Click.on(TXT_ZIP_CODE));
            actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(TXT_ZIP_CODE));
            actor.attemptsTo(SendKeys.of(Keys.DELETE).into(TXT_ZIP_CODE));
            actor.attemptsTo(Type.theValue(getInstance().getDatosPrueba().get("zip_code")).into(TXT_ZIP_CODE));

            actor.attemptsTo(Click.on(CHECK_WAIVER));
            actor.attemptsTo(Click.on(SIGNATURE_WAIVER));
            actor.attemptsTo(SendKeys.of(Keys.CONTROL, "a").into(SIGNATURE_WAIVER));
            actor.attemptsTo(SendKeys.of(Keys.DELETE).into(SIGNATURE_WAIVER));
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
