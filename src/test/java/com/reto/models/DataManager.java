package com.reto.models;

import java.util.HashMap;
import java.util.Map;

public class DataManager {
    private static DataManager instance = null;
    private static Map<String, String> datosPrueba = null;
    private DataManager() {
    }
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
            datosPrueba = new HashMap<>();
        }
        return instance;
    }
    public Map<String, String> getDatosPrueba() {
        return datosPrueba;
    }


}
