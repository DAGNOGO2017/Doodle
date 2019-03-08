package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Createur;
import test.testjpa.domain.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Createur")
public class CreateurService {
    private Utilisateur createur;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();

    public CreateurService() {
        super();
        this.createur = new Createur();
    }

    @GET
    @Path("/createur")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Createur> list() {
        Createur createur = new Createur();
        entityManagerHelper.beginTransaction();
        String req = "Select c from Createur c";
        Query query = entityManager.createQuery(req, Createur.class);
        List<Createur> createurs = (List<Createur>) query.getResultList();
        return createurs;
    }

    @GET
    @Path("/createur/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Createur Search(@PathParam("id") String id) {
        Createur createur = new Createur();
        entityManagerHelper.beginTransaction();
        createur = entityManager.find(Createur.class, Integer.parseInt(id));
        entityManagerHelper.closeEntityManager();
        return createur;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("id") String id) {
        Createur createur = new Createur();
        entityManagerHelper.beginTransaction();
        createur = entityManager.find(Createur.class, Integer.parseInt(id));
        entityManager.remove(createur);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(Createur createur) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(createur);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Createur createur) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(createur);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
    }

}