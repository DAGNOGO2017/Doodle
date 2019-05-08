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

import DAOImpl.AllergieDaoImpl;
import Entities.Allergie;

@Path("/Allergie")
public class AllergieService {
    AllergieDaoImpl allergieDaoImpl = new AllergieDaoImpl();
    private EntityManager em;
    public AllergieService() {
        super();
        
    }
    @GET
    @Path("/allergie")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Allergie> list(){
        List<Allergie> allergies = allergieDaoImpl.getList();
        return allergies;
    }
    @GET
    @Path("/allergie/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    public Allergie Search(@PathParam("emailParticipant") String id) {
        Allergie allergie = new Allergie();
        allergie = em.find(Allergie.class, Integer.parseInt(id));
        return allergie;
    }

    @DELETE
    @Path("delete/{emailParticipant}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("emailParticipant") String id) {
        Allergie allergie = new Allergie();
        allergie = em.find(Allergie.class, Integer.parseInt(id));
        allergieDaoImpl.removeAllergie(allergie);
    }

    @POST
    @Path("add/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(@PathParam("emailParticipant") String id, Allergie allergie) {
        allergieDaoImpl.addAllergie(id, allergie);
    }

    @PUT
    @Path("update/{emailParticipant}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Allergie allergie) {
        allergieDaoImpl.updateAllergie(allergie);
    }
}

