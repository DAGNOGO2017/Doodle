package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Dates;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Date")
public class DateService {
    private Dates dates;
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
        Dates date = new Dates();
        entityManagerHelper.beginTransaction();
        String req = "Select d from Dates d";
        Query query = entityManager.createQuery(req,Dates.class );
        List<Dates> dates = (List<Dates>) query.getResultList();
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
    public void Delete(@PathParam("id") String id) {
        Dates date = new Dates();
        entityManagerHelper.beginTransaction();
        date = entityManager.find(Dates.class, Long.parseLong(id));
        entityManager.remove(date);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(Dates date) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(date);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Dates date) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(date);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
    }
}

