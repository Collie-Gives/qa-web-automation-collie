package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import java.time.Duration;

import static com.reto.util.ConstantManager.*;
import static net.serenitybdd.screenplay.targets.Target.the;

public class Register {
    public static final Target BUTTON_MAS = the("Button add icon")
            .located(By.xpath("//*[@data-testid='AddIcon']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BUTTON_CONTINUE = the("Button continue")
            .located(By.xpath("//button[contains(.,'Continue')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
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
    public static final Target TXT_ZIP_CODE = the("Zip Code")
            .located(By.xpath("//*[@data-test='Zip Code']//*[@type='text']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target CHECK_WAIVER = the("Check waiver")
            .located(By.xpath("//span[contains(text(), 'I accept the waiver agreement *')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target SIGNATURE_WAIVER = the("Signature waiver")
            .located(By.name("waiverSignature"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target LABEL_WAIVER = the("Label waiver")
            .located(By.xpath("//*[text()='Waiver']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target BUTTON_SKIP = the("Button skip")
            .located(By.xpath("//button[contains(.,'Skip')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_THANK_YOU = the("Label thank you")
            .located(By.xpath("//*[text()='THANK YOU!']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target SELECT_CAMPAIGN = the("Select campaign")
            .locatedBy("//*[text()='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target SELECT_EXPERIENCE = the("Select experience")
            .locatedBy("//*[text()='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target BUTTON_REGISTER_NOW = the("Button register now")
            .located(By.xpath("(//button[contains(.,'Register Now')])[1]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target OPTION_PARTICIPATE = the("Option participate")
            .locatedBy("//*[text()='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target SELECT_TEAM = the("Select team")
            .located(By.xpath("//*[@id='mui-component-select-team']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target SELECT_TEAM_OPTIONS = the("Select team options")
            .locatedBy("//*[@role='option' and contains(text(), '{0}')]")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));


}
