package edu.mum.beans;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ashok on 6/9/17.
 */

@Named
@RequestScoped
public class ViewController{

    @Inject
    FlightService flightService;
    @Inject
    AirlineService airlineService;
    @Inject
    AirportService airportService;


    private static List<Flight> flights;
    private int run = 0;

    public String updateFlights(String filterBy, String filterText) {
        run=1;
        if ("airline".equals(filterBy)) {
            Airline airline = airlineService.findByName(filterText);
            flights = flightService.findByAirline(airline);
        } else if ("destination".equals(filterBy)) {
            Airport airport = airportService.findByCode(filterText);
            flights = flightService.findByDestination(airport);
        } else if ("departure".equals(filterBy)) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            try {
                flights = flightService.findByDeparture(df.parse(filterText));
            } catch (ParseException e) {
                e.printStackTrace();
                flights = null;
            }
        } else if ("arrival".equals(filterBy)) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            try {
                flights = flightService.findByArrival(df.parse(filterText));
            } catch (ParseException e) {
                e.printStackTrace();
                flights = null;
            }
        } else {
            run = 0;
        }
        return null;
    }

    public List<Flight> getFlights() {
        if(run != 0){
            return flights;
        } else {
            return flightService.findAll();
        }
    }
}

