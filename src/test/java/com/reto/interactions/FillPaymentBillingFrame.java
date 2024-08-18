package com.reto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class FillPaymentBillingFrame {

    private static final Logger LOGGER = LoggerFactory.getLogger(FillPaymentBillingFrame.class);
    private FillPaymentBillingFrame() {
    }
    public static Performable inAppFrame1(String numberCard, String expiry_date, String security_code, String country) {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                WebElement iframe = driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[1]"));
                driver.switchTo().frame(iframe);
                WebElement fieldNumberInput = driver.findElement(By.xpath("//*[@id='Field-numberInput']"));
                fieldNumberInput.sendKeys(numberCard);
                WebElement fieldExpiry_date = driver.findElement(By.xpath("//*[@id='Field-expiryInput']"));
                fieldExpiry_date.sendKeys(expiry_date);
                WebElement fieldSecurity_code = driver.findElement(By.xpath("//*[@id='Field-cvcInput']"));
                fieldSecurity_code.sendKeys(security_code);
                WebElement fieldCountry = driver.findElement(By.xpath("//*[@id='Field-countryInput']"));
                fieldCountry.sendKeys(country);
                driver.switchTo().defaultContent();
            } catch (Exception e) {
                LOGGER.info("Problemas con algunos de los objetos al interactuar");
            }
        });
    }
    public static Performable inAppFrame2(String full_name_billing, String address_line_billing, String city_billing, String state_billing, String zip_code_billing) {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                WebElement iframe = driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[2]"));
                driver.switchTo().frame(iframe);
                WebElement fieldFull_name_billing = driver.findElement(By.xpath("//*[@id='Field-nameInput']"));
                fieldFull_name_billing.sendKeys(full_name_billing);
                WebElement fieldAddress_line_billing = driver.findElement(By.xpath("//*[@id='Field-addressLine1Input']"));
                fieldAddress_line_billing.sendKeys(address_line_billing);
                WebElement fieldCity_billing = driver.findElement(By.xpath("//*[@id='Field-localityInput']"));
                fieldCity_billing.sendKeys(city_billing);
                WebElement fieldState_billing = driver.findElement(By.xpath("//*[@id='Field-administrativeAreaInput']"));
                fieldState_billing.sendKeys(state_billing);
                WebElement fieldZip_code_billing = driver.findElement(By.xpath("//*[@id='Field-postalCodeInput']"));
                fieldZip_code_billing.sendKeys(zip_code_billing);
                driver.switchTo().defaultContent();
            } catch (Exception e) {
                LOGGER.info("Problemas con algunos de los objetos al interactuar");
            }
        });
    }

}
