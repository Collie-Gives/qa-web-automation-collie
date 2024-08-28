package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.reto.util.ConstantManager.TIME_OUT_10;
import static com.reto.util.ConstantManager.TIME_OUT_20;
import static net.serenitybdd.screenplay.targets.Target.the;

public class NewCampaign {
    public static final Target BUTTON_NEW_CAMPAIGN = the("Button new campaign")
            .located(By.xpath("//button[text()='New Campaign']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target TXT_NAME_CAMPAIGN = the("Name campaign")
            .located(By.name("name"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_NAME_CITY = the("Name city")
            .located(By.name("city"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target OPTION_STATE = the("Option state")
            .locatedBy("//*[@role='option' and text()='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target BOTON_CONTINUE_CAMPAIGN = the("Button continue")
            .located(By.xpath("//button[contains(.,'Continue')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target ADD_IMAGEN_CAMPAIGN = the("Add imagen logo")
            .located(By.xpath("(//*[@data-testid='PhotoCameraOutlinedIcon'])[1]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BUTTON_UPLOAD = the("Button upload")
            .located(By.xpath("//*[@title='Upload']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_CREATE_CAMPAIGN = the("Button create campaign")
            .located(By.xpath("//button[contains(.,'Create')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_CAMPAIGN_CREATED = the("Label campaign created")
            .located(By.xpath("//*[text()='Your campaign has been created.']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_MANAGE_CAMPAIGN = the("Button manage campaign")
            .located(By.xpath("//button[contains(.,'Manage Campaign')]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));


}
