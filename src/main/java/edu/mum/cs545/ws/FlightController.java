package edu.mum.cs545.ws;

import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ashok on 6/8/17.
 */
@Named
@Path("flight")
public class FlightController {
    @Inject
    private FlightService flightService;

    @Path("")
    @GET
    public List<Flight> getAllFlights() {
        try {
            return flightService.findAll();
        }catch (Exception ex){
            return null;
        }
    }

    @Path("{id}")
    @GET
    public Flight getFlight(@PathParam("id") long id) {
        try {
            return flightService.findById(id);
        }catch (Exception ex){
            return null;
        }
    }

    @Path("get")
    @GET
    public List<Flight> getFlights(@QueryParam("flightNo") String flightNo) {
        try {
            return flightService.findByNumber(flightNo);
        }catch (Exception ex){
            return null;
        }
    }

    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Flight saveFlight(Flight flight){
        try {
            flightService.create(flight);
            return flightService.find(flight);
        }catch (Exception exp){
            return null;
        }
    }

    @Path("delete/{id}")
    @DELETE
    public Flight deleteFlight(@PathParam("id") long id){
        try{
            Flight flight = flightService.findById(id);
            flightService.delete(flight);
            return flight;
        }catch (Exception ex){
            return null;
        }
    }

    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Flight updateFlight(Flight flight){
        try{
            return flightService.update(flight);
        }catch (Exception ex){
            return null;
        }
    }
}
