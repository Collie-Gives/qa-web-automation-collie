package com.reto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class SwagBagSelection {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwagBagSelection.class);
    private SwagBagSelection() {
    }
    public static Performable inApp() {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                WebElement element = driver.findElement(By.xpath("//*[@data-testid='CheckBoxOutlineBlankIcon']"));
                Actions actions = new Actions(driver);
                actions.moveToElement(element).click().perform();
            } catch (Exception e) {
                LOGGER.info("No realizo el click al objeto");
            }
        });
    }

}
