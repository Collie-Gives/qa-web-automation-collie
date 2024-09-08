package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.reto.util.ConstantManager.*;
import static net.serenitybdd.screenplay.targets.Target.the;

public class LoginRegistration {
    public static final Target TXT_EMAIL = the("Email address")
            .located(By.name("email"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target TXT_PASSWORD = the("Password")
            .located(By.name("password"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target BOTON_LOGIN = the("Button login")
            .located(By.xpath("//button[@type='submit']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));

}
