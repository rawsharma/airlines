package edu.mum.cs545.ws;

/**
 * Created by Raw on 6/8/2017.
 */
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirlineService;

import java.util.List;
@Named
@Path("airline")
public class AirlineController {
    @Inject
    private AirlineService airlineService;

    @Path("abc")
    @GET
    public List<Airline> getAirline() {
        List<Airline> airline = airlineService.findAll();
        return airline;
    }

    @POST
    public Response createAirline()
}
