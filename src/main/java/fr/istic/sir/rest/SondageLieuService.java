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
        entityManagerHelper.beginTransaction();
        List<SondageLieu> sondageLieux = sondageLieuDaoImpl.getList();
        return sondageLieux;
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
        sondageLieuDaoImpl.removeSl(sondageLieu);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/{id}")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  void Add(@PathParam("id") int id, SondageLieu sondageLieu){
        entityManagerHelper.beginTransaction();
        sondageLieuDaoImpl.addSl(id, sondageLieu);
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

