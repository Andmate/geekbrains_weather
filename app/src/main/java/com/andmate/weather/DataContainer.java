package com.andmate.weather;

import java.io.Serializable;

public class DataContainer implements Serializable {
    int counter;
    String text;
    private static DataContainer instance;

    private DataContainer() {}

    static DataContainer getInstance() {
        if(instance == null) {
            instance = new DataContainer();
        }
        return instance;
    }
}
