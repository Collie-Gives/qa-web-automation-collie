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
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_NAME_CAMPAIGN = the("Name campaign")
            .located(By.name("name"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_NAME_CITY = the("Name city")
            .located(By.name("city"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));

}
