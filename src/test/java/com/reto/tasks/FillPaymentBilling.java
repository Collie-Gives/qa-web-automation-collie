package com.reto.tasks;

import com.reto.interactions.FillPaymentBillingFrame;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class FillPaymentBilling {
    private FillPaymentBilling() {
    }
    public static Performable inAppFrame1(String numberCard, String expiry_date, String security_code, String country) {
        return Task.where(actor -> {
            actor.attemptsTo(FillPaymentBillingFrame.inAppFrame1(numberCard,expiry_date,security_code,country));
        });
    }
    public static Performable inAppFrame2(String full_name_billing, String address_line_billing, String city_billing, String state_billing, String zip_code_billing) {
        return Task.where(actor -> {
            actor.attemptsTo(FillPaymentBillingFrame.inAppFrame2(full_name_billing, address_line_billing, city_billing, state_billing, zip_code_billing));
        });
    }
}
