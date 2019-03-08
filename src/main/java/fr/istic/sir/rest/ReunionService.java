package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Reunion;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/Reunion")
public class ReunionService {
    private Reunion reunion;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();

    public ReunionService() {
        super();
        this.reunion = new Reunion();
    }

    @GET
    @Path("/reunion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reunion> list() {
        Reunion reunion = new Reunion();
        entityManagerHelper.beginTransaction();
        String req = "Select r from Reunion r";
        Query query = entityManager.createQuery(req, Reunion.class);
        List<Reunion> reunions = (List<Reunion>) query.getResultList();
        return reunions;
    }

    @GET
    @Path("/reunion/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reunion Search(@PathParam("id") String id) {
        Reunion reunion = new Reunion();
        entityManagerHelper.beginTransaction();
        reunion = entityManager.find(Reunion.class, Integer.parseInt(id));
        entityManagerHelper.closeEntityManager();
        return reunion;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("id") String id) {
        Reunion reunion = new Reunion();
        entityManagerHelper.beginTransaction();
        reunion = entityManager.find(Reunion.class, Integer.parseInt(id));
        entityManager.remove(reunion);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(Reunion reunion) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(reunion);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Reunion reunion) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(reunion);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
    }

}
