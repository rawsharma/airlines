package edu.mum.beans;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by ashok on 6/9/17.
 */
@Named("ac")
@RequestScoped
public class AirlineController {
    @Inject
    AirlineService airlineService;

    Airline airline;

    AirlineController(){
        airline = new Airline();
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public List<Airline> getAirlines(){
        return airlineService.findAll();
    }

    public void save(){
        try {
            if (!airline.getName().equals("")) {
                airlineService.create(airline);
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Airline Created with ID "+airline.getId()+" and name = "+airline.getName()));
            }else{
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Name shouldn't be empty"));
            }
        }catch (Exception ex){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Error Saving Data either due to duplicate key or database error"));
        }
    }
    public String delete(Airline airline){
        airlineService.delete(airline);
        return null;
    }
    public String update(Airline airline){
        airlineService.update(airline);
        return null;
    }

}
