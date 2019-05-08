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

@Path("/LieuReunion")
public class LieuReunionService {
    LieuReunionDaoImpl lieuReunionDaoImpl = new LieuReunionDaoImpl();
    EntityManager entityManager;
    public LieuReunionService() {
        super();
    }
    @GET
    @Path("/lieuReunion")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LieuReunion> list(){
        List<LieuReunion> lieuReunions = lieuReunionDaoImpl.getList();
        return lieuReunions;
    }
    @GET
    @Path("/lieuReunion/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public LieuReunion Search(@PathParam("id") String id) {
    	LieuReunion lieuReunion = new LieuReunion();
        lieuReunion = entityManager.find(LieuReunion.class, Integer.parseInt(id));

        return lieuReunion;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("id") long id) {
    	LieuReunion lieuReunion = new LieuReunion();
        lieuReunion = entityManager.find(LieuReunion.class, id);
        lieuReunionDaoImpl.removeReunion(lieuReunion);
    }

    @POST
    @Path("add/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(@PathParam("id") int id, LieuReunion lieuReunion) {
        lieuReunionDaoImpl.addReunion(id, lieuReunion);
    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(LieuReunion lieuReunion) {
        lieuReunionDaoImpl.updateReunion(lieuReunion);
    }
}

