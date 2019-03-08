package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.SondageDate;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/SondageDate")
public class SondageDateService {
    private SondageDate sondageDate;
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
        SondageDate sondageDate = new SondageDate();
        entityManagerHelper.beginTransaction();
        String req = "Select s from SondageDate s";
        Query query = entityManager.createQuery(req,SondageDate.class );
        List<SondageDate> sondageDates = (List<SondageDate>) query.getResultList();
        return sondageDates;
    }
    @GET
    @Path("/sondadeDate/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SondageDate Search(@PathParam("id") String id){
        SondageDate sondageDate = new SondageDate();
        entityManagerHelper.beginTransaction();
        sondageDate=entityManager.find(SondageDate.class, Integer.parseInt(id) );
        entityManagerHelper.closeEntityManager();
        return sondageDate;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public  void Delete(@PathParam("id") String id){
        SondageDate sondageDate = new SondageDate();
        entityManagerHelper.beginTransaction();
        sondageDate=entityManager.find(SondageDate.class, Integer.parseInt(id));
        entityManager.remove(sondageDate);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("Add/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    public  void Add(SondageDate sondageDate){
        entityManagerHelper.beginTransaction();
        entityManager.merge(sondageDate);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void  Update(SondageDate sondageDate){
        entityManagerHelper.beginTransaction();
        entityManager.merge(sondageDate);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

}

