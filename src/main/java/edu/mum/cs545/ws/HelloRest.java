package edu.mum.cs545.ws;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import java.util.List;

@Named
@Path("hello")
public class HelloRest {

	@Inject
	private AirlineService airlineService;

	@GET
	public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
		return "Hello " + name + "!";
	}

	@Path("airline")
	@GET
	public String getAirlineTest() {
		String result = "Nil!";
		Airline airline = airlineService.findByName("oneworld");
		if (airline != null) {
			result = "This is an airline: " + airline.getName();
		}
		return result;
	}

	@Path("abc")
	@GET
	public List<Airline> getAirline() {
		List<Airline> airline = airlineService.findAll();
		return airline;
	}



}
