package fr.istic.sir.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAOImpl.DatesDaoImpl;
import Entities.Dates;

@Path("/Date")
public class DateService {
    DatesDaoImpl daoImpl = new DatesDaoImpl();
    EntityManager entityManager;
    public DateService() {
        super();
    }
    @GET
    @Path("/date")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dates> list(){
        List<Dates> dates =daoImpl.getList() ;
        return dates;
    }
    @GET
    @Path("/date/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dates Search(@PathParam("id") String id) {
        Dates date = new Dates();
        date = entityManager.find(Dates.class, Long.parseLong(id));
        return date;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("id") long id) {
        Dates date = new Dates();
        date = entityManager.find(Dates.class, id);
        daoImpl.removeDates(date);  
    }

    @POST
    @Path("add/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(@PathParam("id") int id, Dates date) {
        daoImpl.addDates(id, date);
    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Dates date) {
        daoImpl.updateDates(date);
    }
}

