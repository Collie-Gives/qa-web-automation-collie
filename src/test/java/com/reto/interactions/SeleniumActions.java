package com.reto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class SeleniumActions {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumActions.class);
    private SeleniumActions() {
    }
    public static Performable writeField(String xpathExpression, String value) {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                WebElement element = driver.findElement(By.xpath(xpathExpression));
                element.click();
                element.sendKeys(value);
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }
    public static Performable clearField(String xpathExpression) {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            Actions actions = new Actions(driver);
            try {
                WebElement element = driver.findElement(By.xpath(xpathExpression));
                actions.moveToElement(element)
                        .click()
                        .keyDown(Keys.CONTROL)
                        .sendKeys("a")
                        .keyUp(Keys.CONTROL)
                        .sendKeys(Keys.BACK_SPACE)
                        .perform();
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }
    public static Performable clickField(String xpathExpression) {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            Actions actions = new Actions(driver);
            try {
                WebElement element = driver.findElement(By.xpath(xpathExpression));
                actions.moveToElement(element).click().perform();
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }

    public static Performable clearAndWriteField(String xpathExpression, String value) {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            Actions actions = new Actions(driver);
            try {
                WebElement element = driver.findElement(By.xpath(xpathExpression));
                actions.moveToElement(element)
                        .click() // Hacer clic en el campo para enfocar
                        .keyDown(Keys.CONTROL) // Mantener la tecla Control (Windows) o Command (Mac)
                        .sendKeys("a") // Seleccionar todo el texto
                        .keyUp(Keys.CONTROL) // Liberar la tecla Control
                        .sendKeys(Keys.BACK_SPACE) // Eliminar el texto seleccionado
                        .perform();
                actions.moveToElement(element).sendKeys(value).perform();
            } catch (Exception e) {
                LOGGER.info("Problems with some of the objects when interacting");
            }
        });
    }

}
