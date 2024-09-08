package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.reto.util.ConstantManager.TIME_OUT_20;
import static com.reto.util.ConstantManager.TIME_OUT_30;
import static net.serenitybdd.screenplay.targets.Target.the;

public class CampaignPages {
    public static final Target LABEL_CAMPAIGN_PAGES = the("Label campaign pages")
            .located(By.xpath("//*[text()='Campaign Pages']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_EXPERIENCE_LANDING = the("Label experience landing")
            .located(By.xpath("//*[text()='Experience Landing Page']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BUTTON_EDIT_EXPERIENCE_LANDING = the("Button edit experience landing")
            .located(By.xpath("(//button[@type='button' and contains(text(), 'Edit')])[2]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BUTTON_CONTENT = the("Button content")
            .located(By.xpath("//button[text()='Content']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_OUR_STORY = the("Label our story")
            .located(By.xpath("//div[@role='button' and .//p[text()='Our Story']]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_SAVE = the("Button save")
            .located(By.xpath("//button[text()='Save']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_EXIT_EDITOR = the("Button exit editor")
            .located(By.xpath("//button//a[text()='Exit editor']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));

}
