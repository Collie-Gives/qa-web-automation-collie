package com.reto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.reto.interactions.SeleniumActions.*;
import static com.reto.models.DataManager.getInstance;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class FillPaymentBillingFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(FillPaymentBillingFrame.class);

    private FillPaymentBillingFrame() {
    }

    public static Performable inAppFrame() {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            actor.attemptsTo(Wait.aTime(5));
            try {
                List<WebElement> elements = driver.findElements(By.xpath("//*[text()='Pay with other method']"));
                if (elements.isEmpty()) {
                    WebElement iframe = driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[1]"));
                    driver.switchTo().frame(iframe);
                    actor.attemptsTo(clearAndWriteField("//*[@id='Field-numberInput']", getInstance().getDatosPrueba().get("number_card")));
                    actor.attemptsTo(clearAndWriteField("//*[@id='Field-expiryInput']", getInstance().getDatosPrueba().get("expiry_date")));
                    actor.attemptsTo(clearAndWriteField("//*[@id='Field-cvcInput']", getInstance().getDatosPrueba().get("security_code")));
                    actor.attemptsTo(clearAndWriteField("//*[@id='Field-countryInput']", getInstance().getDatosPrueba().get("country")));
                    List<WebElement> elementsPostalCode = driver.findElements(By.xpath("(//*[@id='Field-postalCodeInput'])[1]"));
                    if (!elementsPostalCode.isEmpty()) {
                        actor.attemptsTo(clearAndWriteField("(//*[@id='Field-postalCodeInput'])[1]", "12345"));
                    }
                    actor.attemptsTo(clickField("//*[@id='Field-cvcInput']"));
                    actor.attemptsTo(scrollToPageSelenium());
                    driver.switchTo().defaultContent();

                    List<WebElement> elementsSamePersonalAddress = driver.findElements(By.xpath("//*[@class='StripeElement']"));
                    if (elementsSamePersonalAddress.size() >= 2) {
                        WebElement iframe2 = driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[2]"));
                        driver.switchTo().frame(iframe2);
                        actor.attemptsTo(clearAndWriteField("//*[@id='Field-nameInput']", getInstance().getDatosPrueba().get("full_name_billing")));
                        actor.attemptsTo(clearAndWriteField("//*[@id='Field-addressLine1Input']", getInstance().getDatosPrueba().get("address_line_billing")));
                        actor.attemptsTo(Wait.aTime(2));
                        actor.attemptsTo(clearAndWriteField("//*[@id='Field-localityInput']", getInstance().getDatosPrueba().get("city_billing")));
                        actor.attemptsTo(clearAndWriteField("//*[@id='Field-administrativeAreaInput']", getInstance().getDatosPrueba().get("state_billing")));
                        actor.attemptsTo(clearAndWriteField("//*[@id='Field-postalCodeInput']", getInstance().getDatosPrueba().get("zip_code_billing")));
                        driver.switchTo().defaultContent();
                    }
                }
                actor.attemptsTo(clickField("//*[@name='terms']"));
                actor.attemptsTo(clickField("//button[text()='Purchase']"));
                actor.attemptsTo(Wait.aTime(10));
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }
}
