package com.reto.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class ChoosePlanPage {
    public static final Target BOTON_SELECT_PERIOD = the("Button Choose Period").located(By.xpath("//button[@type='button']"));
    public static final Target BOTON_SUBSCRIBE_BASIC = the("Button Subscribe Basic").located(By.xpath("//nz-card[@class='ant-card ec-card ant-card-bordered']//a[contains(text(),'Subscribe')]"));
    public static final Target BOTON_SUBSCRIBE_PLATINUM = the("Button Subscribe platinum").located(By.xpath("//nz-card[@class='ant-card ec-card card-blue ant-card-bordered']//a[contains(text(),'Subscribe')]"));

}
