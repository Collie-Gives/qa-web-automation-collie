package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.reto.util.ConstantManager.*;
import static net.serenitybdd.screenplay.targets.Target.the;

public class Home {
    public static final Target ICON_CAMPAIGN = the("Menu icon campaign")
            .located(By.xpath("//*[@data-testid='FlagIcon']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_30));

}
