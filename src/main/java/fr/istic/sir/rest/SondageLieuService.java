package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.SondageLieu;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/SondageLieu")
public class SondageLieuService {
    private SondageLieu sondageLieu;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public SondageLieuService() {
        super();
        this.sondageLieu = new SondageLieu();
    }
    @GET
    @Path("/sondageLieu")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SondageLieu> list(){
        SondageLieu sondageLieu = new SondageLieu();
        entityManagerHelper.beginTransaction();
        String req = "Select s from SondageLieu s";
        Query query = entityManager.createQuery(req,SondageLieu.class );
        List<SondageLieu> sondageLieus = (List<SondageLieu>) query.getResultList();
        return sondageLieus;
    }
    @GET
    @Path("/sondageLieu/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public SondageLieu Search(@PathParam("id") String id){
        SondageLieu sondageLieu = new SondageLieu();
        entityManagerHelper.beginTransaction();
        sondageLieu=entityManager.find(SondageLieu.class, Integer.parseInt(id) );
        entityManagerHelper.closeEntityManager();
        return sondageLieu;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public  void Delete(@PathParam("id") String id){
        SondageLieu sondageLieu = new SondageLieu();
        entityManagerHelper.beginTransaction();
        sondageLieu=entityManager.find(SondageLieu.class, Integer.parseInt(id));
        entityManager.remove(sondageLieu);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    public  void Add(SondageLieu sondageLieu){
        entityManagerHelper.beginTransaction();
        entityManager.merge(sondageLieu);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void  Update(SondageLieu sondageLieu){
        entityManagerHelper.beginTransaction();
        entityManager.merge(sondageLieu);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }
}

