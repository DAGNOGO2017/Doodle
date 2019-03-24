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
import jpa.EntityManagerHelper;

@Path("/Allergie")
public class AllergieService {
    private Allergie allergie;
    AllergieDaoImpl allergieDaoImpl = new AllergieDaoImpl();
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
        entityManagerHelper.beginTransaction();
        List<Allergie> allergies = allergieDaoImpl.getList();
        entityManagerHelper.commit();
        return allergies;
    }
    @GET
    @Path("/allergie/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    public Allergie Search(@PathParam("emailParticipant") String id) {
        Allergie allergie = new Allergie();
        entityManagerHelper.beginTransaction();
        allergie = entityManager.find(Allergie.class, Integer.parseInt(id));
        entityManagerHelper.closeEntityManager();
        return allergie;
    }

    @DELETE
    @Path("delete/{emailParticipant}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("emailParticipant") String id) {
        Allergie allergie = new Allergie();
        entityManagerHelper.beginTransaction();
        allergie = entityManager.find(Allergie.class, Integer.parseInt(id));
        allergieDaoImpl.removeAllergie(allergie);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(@PathParam("emailParticipant") String id, Allergie allergie) {
        entityManagerHelper.beginTransaction();
        allergieDaoImpl.addAllergie(id, allergie);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{emailParticipant}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(Allergie allergie) {
        entityManagerHelper.beginTransaction();
        allergieDaoImpl.updateAllergie(allergie);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
    }
}

