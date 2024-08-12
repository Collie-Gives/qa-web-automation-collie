package com.reto.models;

//import com.amazonaws.util.StringUtils;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class DataTest implements Task {

    private final Map<String, String> datoPrueba;

    public DataTest(Map<String, String> datoPrueba) {
        this.datoPrueba = datoPrueba;
    }

    public static Performable guardar(Map<String, String> datosPrueba) {
        return Tasks.instrumented(DataTest.class, datosPrueba);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Map.Entry<String, String> entrada : datoPrueba.entrySet()) {
            DataManager.getInstance().getDatosPrueba().put(StringUtils.trim(entrada.getKey()),
                    StringUtils.trim(entrada.getValue()));
        }
    }
}
