package com.reto.tasks;

import com.reto.interactions.FillPaymentBillingFrame;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class FillPaymentBilling {
    private FillPaymentBilling() {
    }
    public static Performable inAppFrame1() {
        return Task.where(actor -> {
            actor.attemptsTo(FillPaymentBillingFrame.inAppFrame1());
        });
    }
    public static Performable inAppFrame2() {
        return Task.where(actor -> {
            actor.attemptsTo(FillPaymentBillingFrame.inAppFrame2());
        });
    }
}
