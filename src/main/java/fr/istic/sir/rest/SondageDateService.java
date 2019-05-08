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

import DAOImpl.SondageDateDaoImpl;
import Entities.SondageDate;

@Path("/SondageDate")
public class SondageDateService {
    private SondageDate sondageDate;
    private SondageDateDaoImpl sondageDateDaoImpl = new SondageDateDaoImpl(); 
    EntityManager entityManager;
    public SondageDateService() {
        super();
        this.sondageDate = new SondageDate();
    }
    @GET
    @Path("/sondageDate")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SondageDate> list(){
        List<SondageDate> sondageDates = sondageDateDaoImpl.getList();
        return sondageDates;
    }
    @GET
    @Path("/sondadeDate/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    public SondageDate Search(@PathParam("emailParticipant") String id){
        sondageDate=entityManager.find(SondageDate.class, Integer.parseInt(id) );
        return sondageDate;
    }

    @DELETE
    @Path("delete/{emailParticipant}")
    @Produces({MediaType.APPLICATION_JSON})
    public  void Delete(@PathParam("emailParticipant") String id){
        sondageDate=entityManager.find(SondageDate.class, Integer.parseInt(id));
        sondageDateDaoImpl.removeSd(sondageDate);
    }

    @POST
    @Path("add/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    public  void Add(@PathParam("emailParticipant") String id, SondageDate sondageDate){
        sondageDateDaoImpl.addSd(id, sondageDate);
    }

    @PUT
    @Path("update/{emailParticipant}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void  Update(SondageDate sondageDate){
        sondageDateDaoImpl.updateSd(sondageDate);
    }

}

