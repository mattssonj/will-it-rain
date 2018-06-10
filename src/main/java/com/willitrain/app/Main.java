package com.willitrain.app;

import java.io.IOException;

/**
 * The Meteorologist Program.
 * Check if it is going to rain today
 * Work assignment for CTK
 *
 * @Author: Joakim Mattsson
 */

public class Main {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Set flag (c)oords or (l)ocation and lat/lon or city name");
            System.out.println("Eg.     c 15.000 16.000     or      l gothenburg");
            return;
        }

        OWMRequest request = handleInput(args);
        if (request == null) {
            System.out.println("Input was incorrect. Please try again.");
            return;
        }

        String forecastData;
        try {
            forecastData = request.getData();
        } catch (IOException ioe) {
            System.out.println("Something went wrong trying to collect data from OpenWeatherMap");
            ioe.printStackTrace();
            return;
        }

        Meteorologist weatherMan = new Meteorologist(forecastData);

        if (weatherMan.willItRain()) {
            System.out.println("It might rain in the next 24 hours. Keep in mind, I'm a machine, I'm incapable of error");
        } else {
            System.out.println("No, no rain in the next 24 hours. Hurray!");
        }
    }

    private static OWMRequest handleInput(String[] args) {
        if (args[0].equalsIgnoreCase("c") && args.length > 2) {
            return new OWMRequest(args[1], args[2]);
        } else if (args[0].equalsIgnoreCase("l") && args.length > 1) {
            return new OWMRequest(args[1]);
        } else {
            return null;
        }

    }
}
