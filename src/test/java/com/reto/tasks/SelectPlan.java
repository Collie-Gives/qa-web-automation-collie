package com.reto.tasks;

import com.reto.interactions.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.reto.userinterfaces.ChoosePlanPage.*;

public class SelectPlan implements Task {
    private String plan;

    public SelectPlan(String plan) {this.plan = plan;}

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(plan.equals("Basic")){
            actor.attemptsTo(Click.on(BOTON_SUBSCRIBE_BASIC));
        } else if (plan.equals("Platinum")) {
            actor.attemptsTo(Click.on(BOTON_SUBSCRIBE_PLATINUM));
        }
    }

    public static Performable inApp(String plan){
        return Tasks.instrumented(SelectPlan.class, plan);
    }
}
