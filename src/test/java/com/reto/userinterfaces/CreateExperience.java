package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.reto.util.ConstantManager.TIME_OUT_10;
import static com.reto.util.ConstantManager.TIME_OUT_20;
import static net.serenitybdd.screenplay.targets.Target.the;

public class CreateExperience {
    public static final Target BOTON_ADD_EXPERIENCE = the("Button add experience")
            .located(By.xpath("//button[span[text()='Add experience']]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target TXT_NAME = the("Name experience")
            .located(By.xpath("//*[@name='name']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LIST_CATEGORY = the("Categoty experience")
            .located(By.xpath("//*[@id='mui-component-select-experienceCategory']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target OPTION_LIST_CATEGORY = the("Option categoty list")
            .locatedBy("//*[@data-value='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_CREATE_EXPERIENCE = the("Button create experience")
            .located(By.xpath("//button[text()='Create']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_EXPERIENCE_IMAGES = the("Label experience imagens")
            .located(By.xpath("//*[text()='Experience Images']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target ADD_IMAGE_EXPERIENCE = the("Add image experience")
            .located(By.xpath("(//*[@data-test='addImageButton'])[1]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_GENERAL_SETTINGS = the("Label general settings")
            .located(By.xpath("//*[text()='General Settings']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target URL_GENERAL_SETTINGS = the("URL general settings")
            .located(By.xpath("//*[@target='_blank']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_REGISTRATION_OPTIONS = the("Label registration options")
            .located(By.xpath("//*[text()='Registration Options']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target ADD_REGISTRATION_OPTIONS = the("Add registration option")
            .located(By.xpath("//*[text()='Add Registration Option']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target OPTION_SWAG_BAG = the("Option state")
            .locatedBy("//span[text()='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target BOTON_SAVE_CONTINUE = the("Button save continue")
            .located(By.xpath("//button[text()='Save and continue']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_SAVE = the("Button save")
            .located(By.xpath("(//button[text()='Save'])[3]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_CLOSED_REGISTRATION_OPTIONS = the("Button closed registration options")
            .located(By.xpath("//*[@data-testid='CloseIcon']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_EARLY_BIRD = the("Label early bird")
            .located(By.xpath("//*[text()='Early Bird Registration']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target TXT_EARLY_BIRD_URL_CODE = the("Early bird url code")
            .located(By.xpath("//*[@name='earlyBirdUrlCode']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_SAVE_EARLY_BIRD = the("Button save early bird")
            .located(By.xpath("//*[@data-test='earlyBirdSaveButton']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_WAIVER = the("Label waiver")
            .located(By.xpath("//*[text()='Waiver']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_SAVE_WAIVER = the("Button save waiver")
            .located(By.xpath("//*[@data-test='experienceWaiverSaveButton']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_DONATION_SETTINGS = the("Label donation settings")
            .located(By.xpath("//*[text()='Donation Settings']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_DONATION_OPTIONS = the("Label donation options")
            .located(By.xpath("//*[text()='Donation Options']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target ADD_DONATION_OPTIONS = the("Add donation option")
            .located(By.xpath("//*[text()='add donation option']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target ADD_IMAGE_DONATIONS = the("Add image experience")
            .located(By.xpath("(//*[@data-testid='PhotoCameraOutlinedIcon'])[1]"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_ADD = the("Button add")
            .located(By.xpath("//button[text()='Add']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_FUNDRAISING_SETTINGS = the("Label Fundraising Settings")
            .located(By.xpath("//*[text()='Fundraising Settings']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_STORE = the("Label store")
            .located(By.xpath("//*[text()='Store']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target ADD_ITEM_STORE = the("Add item store")
            .located(By.xpath("//*[text()='Add Item']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target OPTION_STORE = the("Option store")
            .locatedBy("//*[text()='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target LABEL_INDIVIDUAL_FUNDRAISING = the("Label Fundraising Settings")
            .located(By.xpath("//*[text()='Fundraising Settings']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_TEAM_SETTINGS = the("Label team settings")
            .located(By.xpath("//*[text()='Team Settings']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target BOTON_SAVE_TEAM_SETTINGS = the("Button save team settings")
            .located(By.xpath("//*[@data-test='teamFundraisingSaveButton']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target LABEL_BIB_ASSIGNMENT = the("Label team settings")
            .located(By.xpath("//*[text()='Bib Assignment']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target ADD_BIB_POOL = the("Add bib pool")
            .located(By.xpath("//*[text()='Add Bib Pool']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
    public static final Target OPTION_ALLOCATION = the("Option allocation")
            .locatedBy("//*[text()='{0}']")
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_10));
    public static final Target BOTON_SAVE_BIB_POOL = the("Button save bib pool")
            .located(By.xpath("//*[@data-test='bibPoolSaveButton']"))
            .waitingForNoMoreThan(Duration.ofSeconds(TIME_OUT_20));
}
