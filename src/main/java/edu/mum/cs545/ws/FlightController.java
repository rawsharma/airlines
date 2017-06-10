package edu.mum.cs545.ws;

/**
 * Created by Raw on 6/9/2017.
 */
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Flight;
import cs545.airline.model.Flight;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;
import cs545.airline.service.FlightService;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;

@Named
@Path("flight")
public class FlightController {
    @Inject
    private FlightService flightService;

    @GET
    public List<Flight> getAllFlights(){
        List<Flight> listOfFlights = flightService.findAll();
        return listOfFlights;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFlight(Flight flight) {
        try {
            flightService.create(flight);
            return Response.ok().entity(flight).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateFlight(Flight flight, @PathParam("id") int id) {
        try {
            flight.setId(id);
            flightService.update(flight);
            return Response.ok().entity(flight).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteFlight(@PathParam("id")int id){
        try{
            Flight flight =new Flight();
            flight.setId(id);
            flight = flightService.find(flight);
            flightService.delete(flight);
            return Response.ok().entity(flight).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(500).build();
        }
    }
}
