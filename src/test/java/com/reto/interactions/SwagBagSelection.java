package com.reto.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.reto.models.DataManager.getInstance;
import static com.reto.userinterfaces.Register.BUTTON_CONTINUE;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

public class SwagBagSelection {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwagBagSelection.class);
    private SwagBagSelection() {
    }
    public static Performable inApp() {
        return Task.where(actor -> {
            WebDriver driver = getProxiedDriver();
            try {
                String dataItemOption = getInstance().getDatosPrueba().get("name_minor");
                List<WebElement>  element = driver.findElements(By.xpath("//*[@data-testid='CheckBoxOutlineBlankIcon']"));
                if(dataItemOption == null){
                    Actions actions = new Actions(driver);
                    actions.moveToElement(element.get(0)).click().perform();
                    actor.attemptsTo(Wait.aTime(2));
                    actor.attemptsTo(Click.on(BUTTON_CONTINUE));
                }else{
                    Actions actions = new Actions(driver);
                    actions.moveToElement(element.get(0)).click().perform();
                    actions.moveToElement(element.get(element.size()-1)).click().perform();
                    actor.attemptsTo(Wait.aTime(2));
                    actor.attemptsTo(Click.on(BUTTON_CONTINUE));
                }
            } catch (Exception e) {
                LOGGER.info("No realizo el click al objeto");
            }
        });
    }

}
