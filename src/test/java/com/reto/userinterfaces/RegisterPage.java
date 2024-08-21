package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import java.time.Duration;

import static com.reto.util.ConstantManager.*;
import static net.serenitybdd.screenplay.targets.Target.the;

public class RegisterPage {
    public static final Target TXT_EMAIL = the("Email address")
            .located(By.name("email"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_PASSWORD = the("Password")
            .located(By.name("password"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target BOTON_LOGIN = the("Button login")
            .located(By.xpath("//button[@type='submit']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target BOTON_MAS = the("Button add icon")
            .located(By.xpath("//*[@data-testid='AddIcon']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_CONTINUE = the("Button continue")
            .located(By.xpath("//button[contains(.,'Continue')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_FIRST_NAME_INFORMATION = the("First name")
            .located(By.name("attendees[0]firstName"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_LAST_NAME_INFORMATION = the("Last name")
            .located(By.name("attendees[0]lastName"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_EMAIL_INFORMATION = the("Email information")
            .located(By.name("attendees[0]email"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_PHONE_NUMBER = the("Phone number")
            .located(By.xpath("//*[@data-test='Phone Number']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target COMBOBOX_GENDER = the("Combobox gender")
            .located(By.id("mui-component-select-attendees[0]gender"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target SELECT_GENDER = the("Select gender")
            .locatedBy("//*[@data-value='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_ADDRESS = the("Address")
            .located(By.name("attendees[0]address"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_CITY = the("City")
            .located(By.name("attendees[0]city"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_STATE = the("State")
            .located(By.xpath("//*[@role='combobox']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target STATE = the("State")
            .located(By.xpath("//*[@role='option' and text()='Florida']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_ZIP_CODE = the("Zip Code")
            .located(By.xpath("//*[@data-test='Zip Code']//*[@type='text']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target CHECK_WAIVER = the("Check waiver")
            .located(By.xpath("//span[contains(text(), 'I accept the waiver agreement *')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target SIGNATURE_WAIVER = the("Signature waiver")
            .located(By.name("waiverSignature"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target BOTON_CONTINUE_WITHOUT_TEAM = the("Button continue without team")
            .located(By.xpath("//button[contains(.,'Continue without a team')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target CHECK_SWAG_BAG = the("Check swag bag")
            .located(By.xpath("//*[@data-testid='CheckBoxOutlineBlankIcon']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_15));
    public static final Target BOTON_SKIP = the("Button skip")
            .located(By.xpath("//button[contains(.,'Skip')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target TXT_NUMBER_CARD = the("Number card")
            .located(By.xpath("//*[@id='Field-numberInput']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));

    public static final Target LABEL_THANK_YOU = the("Label thank you")
            .located(By.xpath("//*[text()='THANK YOU!']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));

}
