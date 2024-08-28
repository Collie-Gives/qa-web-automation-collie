package com.reto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class FileUpload {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUpload.class);
    private FileUpload() {
    }
    public static Performable imageFile(String xpathExpression, String value) {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                WebElement uploadElement = driver.findElement(By.xpath(xpathExpression));
                uploadElement.sendKeys(value);
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }

}
