package com.reto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.reto.interactions.SeleniumActions.clearAndWriteField;
import static com.reto.interactions.SeleniumActions.clickField;
import static com.reto.models.DataManager.getInstance;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class FillPaymentBillingFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(FillPaymentBillingFrame.class);

    private FillPaymentBillingFrame() {
    }

    public static Performable inAppFrame1() {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                List<WebElement> elements = driver.findElements(By.xpath("//*[text()='Pay with other method']"));
                if (elements.isEmpty()) {
                    WebElement iframe = driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[1]"));
                    driver.switchTo().frame(iframe);
                    actor.attemptsTo(clearAndWriteField("//*[@id='Field-numberInput']", getInstance().getDatosPrueba().get("number_card")));
                    actor.attemptsTo(clearAndWriteField("//*[@id='Field-expiryInput']", getInstance().getDatosPrueba().get("expiry_date")));
                    actor.attemptsTo(clearAndWriteField("//*[@id='Field-cvcInput']", getInstance().getDatosPrueba().get("security_code")));
                    actor.attemptsTo(clearAndWriteField("//*[@id='Field-countryInput']", getInstance().getDatosPrueba().get("country")));
                    driver.switchTo().defaultContent();
                }
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }

    public static Performable inAppFrame2() {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                List<WebElement> elements = driver.findElements(By.xpath("//*[text()='Pay with other method']"));
                if (elements.isEmpty()) {
                    WebElement iframe = driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[2]"));
                    driver.switchTo().frame(iframe);
                }else{
                    WebElement iframe = driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[1]"));
                    driver.switchTo().frame(iframe);
                }
                actor.attemptsTo(clearAndWriteField("//*[@id='Field-nameInput']", getInstance().getDatosPrueba().get("full_name_billing")));
                actor.attemptsTo(clearAndWriteField("//*[@id='Field-addressLine1Input']", getInstance().getDatosPrueba().get("address_line_billing")));
                actor.attemptsTo(clearAndWriteField("//*[@id='Field-localityInput']", getInstance().getDatosPrueba().get("city_billing")));
                actor.attemptsTo(clearAndWriteField("//*[@id='Field-administrativeAreaInput']", getInstance().getDatosPrueba().get("state_billing")));
                actor.attemptsTo(clearAndWriteField("//*[@id='Field-postalCodeInput']", getInstance().getDatosPrueba().get("zip_code_billing")));
                driver.switchTo().defaultContent();
                actor.attemptsTo(Wait.aTime(3));
                actor.attemptsTo(clickField("//*[@name='terms']"));
                //actor.attemptsTo(clickField("//button[text()='Purchase']"));
                actor.attemptsTo(Wait.aTime(7));
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }

}
