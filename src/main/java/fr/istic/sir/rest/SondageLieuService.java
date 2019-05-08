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

import DAOImpl.SondageLieuDaoImpl;
import Entities.SondageLieu;
import jpa.EntityManagerHelper;

@Path("/SondageLieu")
public class SondageLieuService {
    private SondageLieu sondageLieu;
    private SondageLieuDaoImpl sondageLieuDaoImpl = new SondageLieuDaoImpl();
    EntityManager entityManager;
    public SondageLieuService() {
        super();
        this.sondageLieu = new SondageLieu();
    }
    @GET
    @Path("/sondageLieu")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SondageLieu> list(){
        List<SondageLieu> sondageLieux = sondageLieuDaoImpl.getList();
        return sondageLieux;
    }
    @GET
    @Path("/sondageLieu/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    public SondageLieu Search(@PathParam("emailParticipant") String id){
        sondageLieu=entityManager.find(SondageLieu.class, Integer.parseInt(id) );
        return sondageLieu;
    }

    @DELETE
    @Path("delete/{emailParticipant}")
    @Produces({MediaType.APPLICATION_JSON})
    public  void Delete(@PathParam("emailParticipant") String id){
        SondageLieu sondageLieu = new SondageLieu();
        sondageLieu=entityManager.find(SondageLieu.class, Integer.parseInt(id));
        sondageLieuDaoImpl.removeSl(sondageLieu);
    }

    @POST
    @Path("add/{emailParticipant}")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  void Add(@PathParam("emailParticipant") String id, SondageLieu sondageLieu){
        sondageLieuDaoImpl.addSl(id, sondageLieu);
    }

    @PUT
    @Path("update/{emailParticipant}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void  Update(SondageLieu sondageLieu){
        entityManager.merge(sondageLieu);
    }
}

