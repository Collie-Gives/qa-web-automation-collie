package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class FormPlanPage {
    public static final Target TXT_FIRST_NAME = the("First Name").located(By.xpath("//input[@id='name']"));
    public static final Target TXT_LAST_NAME = the("Last Name").located(By.xpath("//input[@id='lastName']"));
    public static final Target TXT_EMAIL_ADDRESS = the("Email Address").located(By.xpath("//input[@id='email']"));
    public static final Target TXT_PHONE_NUMBER = the("Phone Number").located(By.xpath("//input[@id='phone']"));
    public static final Target BUTTON_NEXT_FORM_1 = the("Button Next").located(By.xpath("//button[@class='ant-btn width-100p btn-pricing ng-tns-c61-4 ant-btn-primary ant-btn-round ant-btn-lg']"));

    public static final Target TXT_COMPANY_NAME = the("Company Name").located(By.id("customerName"));
    public static final Target TXT_FISCAL_MONTH = the("Fiscal Month").located(By.id("fiscalMonth"));
    public static final Target LIST_FISCAL_MONTH = the("List Fiscal Month").locatedBy("//nz-option-item[@title='{0}']");
    public static final Target TXT_ACCOUNTING_SOFTWARE = the("Accounting Software").located(By.id("accountingSoftware"));
    public static final Target LIST_ACCOUNTING_SOFTWARE = the("List Accounting Software").locatedBy("//nz-option-item[@title='{0}']");
    public static final Target ICONO_DELETE_COUNTRY = the("Country").located(By.xpath("//*[@class='anticon ant-input-clear-icon anticon-close-circle ng-star-inserted']"));
    public static final Target TXT_COUNTRY = the("Country").located(By.id("countryId"));
    public static final Target TXT_STATE = the("State").located(By.id("stateId"));
    public static final Target TXT_CYTY = the("City").located(By.id("city"));
    public static final Target TXT_CURRENCY = the("Currency").located(By.id("currency"));
    public static final Target LIST_CURRENCY  = the("List Currency").locatedBy("//nz-option-item[@title='{0}']");
    public static final Target TXT_CHECK_COMPANY = the("Check Company").located(By.xpath("//*[@class=\"ant-checkbox\"]"));
    public static final Target BUTTON_NEXT_FORM_2 = the("Button Next").located(By.xpath("//button[@class='ant-btn width-100p btn-pricing btn-next ng-tns-c61-18 ant-btn-primary ant-btn-round ant-btn-lg']"));





}
