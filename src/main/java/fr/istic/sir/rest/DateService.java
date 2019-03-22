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
import jpa.EntityManagerHelper;

@Path("/Date")
public class DateService {
    private Dates dates;
    DatesDaoImpl daoImpl = new DatesDaoImpl();
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public DateService() {
        super();
        this.dates = new Dates();
    }
    @GET
    @Path("/date")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dates> list(){
        entityManagerHelper.beginTransaction();
        List<Dates> dates =daoImpl.getList() ;
        entityManagerHelper.commit();
        return dates;
    }
    @GET
    @Path("/date/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dates Search(@PathParam("id") String id) {
        Dates date = new Dates();
        entityManagerHelper.beginTransaction();
        date = entityManager.find(Dates.class, Long.parseLong(id));
        entityManagerHelper.closeEntityManager();
        return date;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("id") long id) {
        Dates date = new Dates();
        entityManagerHelper.beginTransaction();
        date = entityManager.find(Dates.class, id);
        daoImpl.removeDates(date);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(@PathParam("id") int id, Dates date) {
        entityManagerHelper.beginTransaction();
        daoImpl.addDates(id, date);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Dates date) {
        entityManagerHelper.beginTransaction();
        daoImpl.updateDates(date);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
    }
}

