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

import DAOImpl.LieuReunionDaoImpl;
import Entities.LieuReunion;
import jpa.EntityManagerHelper;

@Path("/LieuReunion")
public class LieuReunionService {
    private LieuReunion lieuReunion;
    LieuReunionDaoImpl lieuReunionDaoImpl = new LieuReunionDaoImpl();
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public LieuReunionService() {
        super();
        this.lieuReunion = new LieuReunion();
    }
    @GET
    @Path("/lieuReunion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LieuReunion> list(){
        entityManagerHelper.beginTransaction();
        List<LieuReunion> lieuReunions = lieuReunionDaoImpl.getList();
        entityManagerHelper.commit();
        return lieuReunions;
    }
    @GET
    @Path("/lieuReunion/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LieuReunion Search(@PathParam("id") String id) {
    	LieuReunion lieuReunion = new LieuReunion();
        entityManagerHelper.beginTransaction();
        lieuReunion = entityManager.find(LieuReunion.class, Integer.parseInt(id));
        entityManagerHelper.closeEntityManager();
        return lieuReunion;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("id") String id) {
    	LieuReunion lieuReunion = new LieuReunion();
        entityManagerHelper.beginTransaction();
        lieuReunion = entityManager.find(LieuReunion.class, Integer.parseInt(id));
        lieuReunionDaoImpl.removeReunion(lieuReunion);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(@PathParam("id") int id, LieuReunion LieuReunion) {
        entityManagerHelper.beginTransaction();
        lieuReunionDaoImpl.addReunion(id, lieuReunion);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(LieuReunion lieuReunion) {
        entityManagerHelper.beginTransaction();
        lieuReunionDaoImpl.updateReunion(lieuReunion);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
    }
}

