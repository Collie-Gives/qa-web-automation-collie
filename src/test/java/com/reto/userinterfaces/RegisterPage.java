package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import java.time.Duration;

import static com.reto.util.ConstantManager.*;
import static net.serenitybdd.screenplay.targets.Target.the;

public class RegisterPage {
    public static final Target TXT_EMAIL = the("Email address")
            .located(By.name("email"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target TXT_PASSWORD = the("Password")
            .located(By.name("password"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target BOTON_LOGIN = the("Button login")
            .located(By.xpath("//button[@type='submit']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target BOTON_MAS = the("Button add icon")
            .located(By.xpath("//*[@data-testid='AddIcon']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_CONTINUE = the("Button continue")
            .located(By.xpath("//button[contains(.,'Continue')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target COMBOBOX_GENDER = the("Combobox gender")
            .located(By.id("mui-component-select-attendees[0]gender"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target SELECT_GENDER = the("Select gender")
            .located(By.xpath("//*[@data-value='Male']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target TXT_ADDRESS = the("Address")
            .located(By.name("attendees[0]address"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target TXT_CITY = the("City")
            .located(By.name("attendees[0]city"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target TXT_STATE = the("State")
            .located(By.xpath("//*[@role='combobox']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target STATE = the("State")
            .located(By.xpath("//*[@value='Florida']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target TXT_ZIP_CODE = the("Zip Code")
            .located(By.xpath("//*[@data-test='Zip Code']//*[@type='text']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target CHECK_WAIVER = the("Check waiver")
            //.located(By.xpath("//*[@name='waiverAcceptance']"))
            //.located(By.xpath("//*[@data-testid='CheckBoxOutlineBlankIcon']"));
            .located(By.xpath("//span[contains(text(), 'I accept the waiver agreement *')]"));
    public static final Target SIGNATURE_WAIVER = the("Signature waiver")
            .located(By.name("waiverSignature"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_5));
    public static final Target BOTON_CONTINUE_WITHOUT_TEAM = the("Button continue without team")
            .located(By.xpath("//button[contains(.,'Continue without a team')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target CHECK_SWAG_BAG = the("Check swag bag")
            //.located(By.xpath("//*[@data-testid='CheckBoxOutlineBlankIcon']"))
            .located(By.xpath("//*[@type='checkbox']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));

    public static final Target BOTON_SKIP = the("Button skip")
            .located(By.xpath("//button[contains(.,'Skip')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target TXT_NUMBER_CARD = the("Number card")
            //.located(By.id("Field-numberInput"))
            .located(By.xpath("//*[@id=\"card-panel\"]//*[@id='Field-numberInput']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));

}