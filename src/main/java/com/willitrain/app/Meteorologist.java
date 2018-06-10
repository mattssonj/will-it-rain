package com.willitrain.app;

import org.json.JSONArray;
import org.json.JSONObject;

public class Meteorologist {

    private String forecastData;

    public Meteorologist(String forecastData) {
        this.forecastData = forecastData;
    }

    public boolean willItRain() {

        JSONObject json = new JSONObject(forecastData);
        JSONArray array = json.getJSONArray("list");

        for (int i = 0; i < 8; i++) {
            JSONObject obj = array.getJSONObject(i);
            JSONArray something = obj.getJSONArray("weather");

            if (something.getJSONObject(0).get("main").equals("Rain")) {
                return true;
            }
        }
        return false;
    }
}