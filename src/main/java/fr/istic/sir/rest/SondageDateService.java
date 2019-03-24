package fr.istic.sir.rest;

import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import DAOImpl.SondageDateDaoImpl;
import Entities.SondageDate;

import java.util.List;

@Path("/SondageDate")
public class SondageDateService {
    private SondageDate sondageDate;
    private SondageDateDaoImpl sondageDateDaoImpl = new SondageDateDaoImpl(); 
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public SondageDateService() {
        super();
        this.sondageDate = new SondageDate();
    }
    @GET
    @Path("/sondageDate")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SondageDate> list(){
        entityManagerHelper.beginTransaction();
        List<SondageDate> sondageDates = sondageDateDaoImpl.getList();
        return sondageDates;
    }
    @GET
    @Path("/sondadeDate/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    public SondageDate Search(@PathParam("emailParticipant") String id){
        entityManagerHelper.beginTransaction();
        sondageDate=entityManager.find(SondageDate.class, Integer.parseInt(id) );
        entityManagerHelper.closeEntityManager();
        return sondageDate;
    }

    @DELETE
    @Path("delete/{emailParticipant}")
    @Produces({MediaType.APPLICATION_JSON})
    public  void Delete(@PathParam("emailParticipant") String id){
        entityManagerHelper.beginTransaction();
        sondageDate=entityManager.find(SondageDate.class, Integer.parseInt(id));
        sondageDateDaoImpl.removeSd(sondageDate);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    public  void Add(@PathParam("emailParticipant") String id, SondageDate sondageDate){
        entityManagerHelper.beginTransaction();
        sondageDateDaoImpl.addSd(id, sondageDate);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{emailParticipant}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void  Update(SondageDate sondageDate){
        entityManagerHelper.beginTransaction();
        sondageDateDaoImpl.updateSd(sondageDate);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

}

