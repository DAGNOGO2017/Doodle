package fr.istic.sir.rest;

import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import Entities.Allergie;

import java.util.List;

@Path("/Allergie")
public class AllergieService {
    private Allergie allergie;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public AllergieService() {
        super();
        this.allergie = new Allergie();
    }
    @GET
    @Path("/allergie")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Allergie> list(){
        Allergie allergie = new Allergie();
        entityManagerHelper.beginTransaction();
        String req = "Select a from Allergie a";
        Query query = entityManager.createQuery(req,Allergie.class );
        List<Allergie> allergies = (List<Allergie>) query.getResultList();
        return allergies;
    }
    @GET
    @Path("/allergie/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Allergie Search(@PathParam("id") String id) {
        Allergie allergie = new Allergie();
        entityManagerHelper.beginTransaction();
        allergie = entityManager.find(Allergie.class, Integer.parseInt(id));
        entityManagerHelper.closeEntityManager();
        return allergie;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("id") String id) {
        Allergie allergie = new Allergie();
        entityManagerHelper.beginTransaction();
        allergie = entityManager.find(Allergie.class, Integer.parseInt(id));
        entityManager.remove(allergie);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(Allergie allergie) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(allergie);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Allergie allergie) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(allergie);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
    }
}

