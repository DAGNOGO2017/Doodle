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

import DAOImpl.CreateurDaoImpl;
import Entities.Createur;

@Path("/Createur")
public class CreateurService {
    CreateurDaoImpl createurDaoImpl = new CreateurDaoImpl();
    Createur createur = new Createur();
    EntityManager entityManager ;

    public CreateurService() {
        super();
    }

    @GET
    @Path("/createur")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Createur> list() {
        List<Createur> createurs =createurDaoImpl.getList();
        return createurs;
    }

    @GET
    @Path("/createur/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Createur Search(@PathParam("id") String id) {
        Createur createur = new Createur();
        createur = entityManager.find(Createur.class, Integer.parseInt(id));
        return createur;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("id") int id) {
        createur = entityManager.find(Createur.class, id);
        createurDaoImpl.removeCreateur(createur);
    }

    @POST
    @Path("add/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(Createur createur) {
        createurDaoImpl.addCreateur(createur);      
    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Createur createur) {
        createurDaoImpl.updateCreateur(createur);
    }

}