package edu.mum.cs545.ws;

/**
 * Created by Raw on 6/9/2017.
 */

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airplane;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirplaneService;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;

@Named
@Path("airplane")
public class AirplaneController {
    @Inject
    private AirplaneService airplaneService;

    @GET
    public List<Airplane> getAllAirplane(){
        List<Airplane> listOfAirplane = airplaneService.findAll();
        return listOfAirplane;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAirplane(Airplane airplane) {
        try {
            airplaneService.create(airplane);
            return Response.ok().entity(airplane).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateAirplane(Airplane airplane, @PathParam("id") int id) {
        try {
            airplane.setId(id);
            airplaneService.update(airplane);
            return Response.ok().entity(airplane).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteAirplane(@PathParam("id")int id){
        try{
            Airplane airplane =new Airplane();
            airplane.setId(id);
            airplane = airplaneService.find(airplane);
            airplaneService.delete(airplane);
            return Response.ok().entity(airplane).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(500).build();
        }
    }


}
