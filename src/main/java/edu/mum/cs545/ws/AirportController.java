package edu.mum.cs545.ws;

/**
 * Created by Raw on 6/9/2017.
 */

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;
import cs545.airline.service.AirportService;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;
@Named
@Path("airport")
public class AirportController {
    @Inject
    private AirportService airportService;

    @GET
    public List<Airport> getAllAirport(){
        List<Airport> listOfAirports = airportService.findAll();
        return listOfAirports;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAirline(Airport airport) {
        try {
            airportService.create(airport);
            return Response.ok().entity(airport).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAirline(Airport airport, @PathParam("id") int id) {
        try {
            airport.setId(id);
            airportService.update(airport);
            return Response.ok().entity(airport).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteAirport(@PathParam("id")int id){
        try{
                Airport airport =new Airport();
            airport.setId(id);
            airport = airportService.find(airport);
            airportService.delete(airport);
            return Response.ok().entity(airport).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(500).build();
        }
    }


}
