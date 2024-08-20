package com.reto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.reto.models.DataManager.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class FillPaymentBillingFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(FillPaymentBillingFrame.class);
    private FillPaymentBillingFrame() {
    }
    public static Performable inAppFrame1() {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                WebElement iframe = driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[1]"));
                driver.switchTo().frame(iframe);

                WebElement fieldNumberInput = driver.findElement(By.xpath("//*[@id='Field-numberInput']"));
                fieldNumberInput.clear();
                fieldNumberInput.sendKeys(getInstance().getDatosPrueba().get("numberCard"));

                WebElement fieldExpiry_date = driver.findElement(By.xpath("//*[@id='Field-expiryInput']"));
                fieldExpiry_date.clear();
                fieldExpiry_date.sendKeys(getInstance().getDatosPrueba().get("expiry_date"));

                WebElement fieldSecurity_code = driver.findElement(By.xpath("//*[@id='Field-cvcInput']"));
                fieldSecurity_code.clear();
                fieldSecurity_code.sendKeys(getInstance().getDatosPrueba().get("security_code"));

                WebElement fieldCountry = driver.findElement(By.xpath("//*[@id='Field-countryInput']"));
                fieldCountry.clear();
                fieldCountry.sendKeys(getInstance().getDatosPrueba().get("country"));

                driver.switchTo().defaultContent();
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }
    public static Performable inAppFrame2() {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                WebElement iframe = driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[2]"));
                driver.switchTo().frame(iframe);

                WebElement fieldFull_name_billing = driver.findElement(By.xpath("//*[@id='Field-nameInput']"));
                fieldFull_name_billing.clear();
                fieldFull_name_billing.sendKeys(getInstance().getDatosPrueba().get("full_name_billing"));

                WebElement fieldAddress_line_billing = driver.findElement(By.xpath("//*[@id='Field-addressLine1Input']"));
                fieldAddress_line_billing.clear();
                fieldAddress_line_billing.sendKeys(getInstance().getDatosPrueba().get("address_line_billing"));

                WebElement fieldCity_billing = driver.findElement(By.xpath("//*[@id='Field-localityInput']"));
                fieldCity_billing.clear();
                fieldCity_billing.sendKeys(getInstance().getDatosPrueba().get("city_billing"));

                WebElement fieldState_billing = driver.findElement(By.xpath("//*[@id='Field-administrativeAreaInput']"));
                fieldState_billing.clear();
                fieldState_billing.sendKeys(getInstance().getDatosPrueba().get("state_billing"));

                WebElement fieldZip_code_billing = driver.findElement(By.xpath("//*[@id='Field-postalCodeInput']"));
                fieldZip_code_billing.clear();
                fieldZip_code_billing.sendKeys(getInstance().getDatosPrueba().get("zip_code_billing"));
                driver.switchTo().defaultContent();

                WebElement fieldCheckTerms = driver.findElement(By.xpath("//*[@name='terms']"));
                fieldCheckTerms.click();
                WebElement fieldButtonPurchase = driver.findElement(By.xpath("//button[text()='Purchase']"));
                fieldButtonPurchase.click();
                actor.attemptsTo(Wait.aTime(10));
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }

}
