package fr.istic.sir.rest;

import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import DAOImpl.CreateurDaoImpl;
import Entities.Createur;
import Entities.Utilisateur;

import java.util.List;

@Path("/Createur")
public class CreateurService {
    private Utilisateur createur;
    CreateurDaoImpl createurDaoImpl = new CreateurDaoImpl();
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
    	entityManagerHelper.beginTransaction();
        List<Createur> createurs =createurDaoImpl.getList();
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
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
    public void Delete(@PathParam("id") int id) {
        Createur createur = new Createur();
        entityManagerHelper.beginTransaction();
        createur = entityManager.find(Createur.class, id);
        createurDaoImpl.removeCreateur(createur);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(Createur createur) {
        entityManagerHelper.beginTransaction();
        createurDaoImpl.addCreateur(createur);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Createur createur) {
        entityManagerHelper.beginTransaction();
        createurDaoImpl.updateCreateur(createur);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
    }

}