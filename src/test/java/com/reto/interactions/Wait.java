package com.reto.interactions;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import java.util.concurrent.TimeUnit;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Wait implements Interaction, IsSilent {

    private final long var;

    public Wait(long var) {
        this.var = var;
    }

    public static Wait aTime(int var) {
        return instrumented(Wait.class, var);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            TimeUnit.SECONDS.sleep(var);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}