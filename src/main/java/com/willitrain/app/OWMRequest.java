package com.willitrain.app;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * OpenWeatherMap GET request
 */

public class OWMRequest {

    private final String API = "api.openweathermap.org/data/2.5/forecast";
    private final String UNIT = "&units=metric";

    private String positionQuery;

    public OWMRequest(String city) {
        positionQuery = "?q=" + city;
    }

    public OWMRequest(String lat, String lon) {
        positionQuery = "?lat=" + lat + "&lon=" + lon;
    }

    public String getData() throws IOException {
        InputStream is = apiCall()
                .openConnection()
                .getInputStream();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        reader.close();
        is.close();

        return sb.toString();
    }

    private URL apiCall() throws MalformedURLException {

        if (EnvironmentKey.OWM_API_KEY.equalsIgnoreCase("DUMMYKEY")) {
            System.out.println("You have to add your OpenWeatherMap API key to EnvironmentKey.java");
            System.out.println("Then recompile and run the program again");
            System.exit(0);
        }

        return new URL(
                "http://" +
                        API +
                        positionQuery +
                        UNIT +
                        "&APPID=" +
                        EnvironmentKey.OWM_API_KEY
        );
    }
}
