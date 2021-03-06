package edu.mum.cs545.ws;

/**
 * Created by Raw on 6/8/2017.
 */

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirlineService;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;

@Named
@Path("airline")
public class AirlineController {
    @Inject
    private AirlineService airlineService;

    @GET
    public List<Airline> getAirline() {
        List<Airline> airline = airlineService.findAll();
        return airline;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAirline(Airline airline) {
        try {
            airlineService.create(airline);
            return Response.ok().entity(airline).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAirline(Airline airline, @PathParam("id") int id) {
        try {
            airline.setId(id);
            airlineService.update(airline);
            return Response.ok().entity(airline).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteAirline(@PathParam("id")int id){
        try{
            Airline airline=new Airline();
            airline.setId(id);
            airline = airlineService.find(airline);
            airlineService.delete(airline);
            return Response.ok().entity(airline).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(500).build();
        }
    }
}
