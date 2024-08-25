package com.reto.util;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import static com.reto.models.DataManager.getInstance;

public class RandomNumber {

    private RandomNumber() {
    }
    public static Performable findNumber() {
        return Task.where(actor -> {
            Random random = new Random();
            int numRandomInt = random.nextInt(1000);
            String numRandomString = String.valueOf(random.nextInt(1000));
            Serenity.setSessionVariable("numRandomInteger").to(numRandomInt);
            getInstance().getDatosPrueba().put("numRandomString", numRandomString);
        });
    }
    public static Performable getCurrentTime() {
        return Task.where(actor -> {
            LocalTime now = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
            String formattedTime = now.format(formatter);
            getInstance().getDatosPrueba().put("currentTime", formattedTime.replace(":","").replace(".",""));
        });
    }
}
