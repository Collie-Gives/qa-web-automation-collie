package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
//import net.thucydides.core.annotations.findby.By;

import java.time.Duration;

import static com.reto.util.ConstantManager.TIME_OUT_5;
import static net.serenitybdd.screenplay.targets.Target.the;

public class RegisterPage {
    public static final Target TXT_EMAIL = the("Email address")
            .located(By.name("email"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target TXT_PASSWORD = the("Password")
            .located(By.name("password"));
    public static final Target BOTON_LOGIN = the("Button login")
            .located(By.xpath("//button[@type='submit']"));
    public static final Target BOTON_MAS = the("Button add icon")
            .located(By.xpath("//*[@data-testid='AddIcon']"));
    public static final Target BOTON_CONTINUE = the("Button continue")
            .located(By.xpath("//button[contains(.,'Continue')]"));
    public static final Target COMBOBOX_GENDER = the("Combobox gender")
            .located(By.id("mui-component-select-attendees[0]gender"));
    public static final Target SELECT_GENDER = the("Select gender")
            .located(By.xpath("//*[@data-value='Male']"));
    public static final Target TXT_ADDRESS = the("Address")
            .located(By.name("attendees[0]address"));
    public static final Target TXT_CITY = the("City")
            .located(By.name("attendees[0]city"));
    public static final Target TXT_STATE = the("State")
            .located(By.xpath("//*[@role='combobox']"));
    public static final Target TXT_ZIP_CODE = the("Zip Code")
            .located(By.xpath("//*[@data-test='Zip Code']"));
    public static final Target ZIP_CODE = the("Text Zip Code")
            .located(By.xpath("//*[@id=\":rq:\"]"));
    public static final Target CHECK_WAIVER = the("Check waiver")
            .located(By.name("waiverAcceptance"));
    public static final Target SIGNATURE_WAIVER = the("Check waiver")
            .located(By.name("waiverSignature"));

}
