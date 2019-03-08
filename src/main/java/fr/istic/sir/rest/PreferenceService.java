package fr.istic.sir.rest;

import jpa.EntityManagerHelper;
import test.testjpa.domain.PreferenceAlimentaire;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Preference")
public class PreferenceService {
    private PreferenceAlimentaire preferenceAlimentaire;
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public PreferenceService() {
        super();
        this.preferenceAlimentaire = new PreferenceAlimentaire();
    }
    @GET
    @Path("/preference")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PreferenceAlimentaire> list(){
        PreferenceAlimentaire preferenceAlimentaire = new PreferenceAlimentaire();
        entityManagerHelper.beginTransaction();
        String req = "Select p from PreferenceAlimentaire p";
        Query query = entityManager.createQuery(req,PreferenceAlimentaire.class );
        List<PreferenceAlimentaire> preferenceAlimentaires = (List<PreferenceAlimentaire>) query.getResultList();
        return preferenceAlimentaires;
    }
    @GET
    @Path("/preference/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PreferenceAlimentaire Search(@PathParam("id") String id) {
        PreferenceAlimentaire preferenceAlimentaire = new PreferenceAlimentaire();
        entityManagerHelper.beginTransaction();
        preferenceAlimentaire = entityManager.find(PreferenceAlimentaire.class, Integer.parseInt(id));
        entityManagerHelper.closeEntityManager();
        return preferenceAlimentaire;
    }

    @DELETE
    @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("id") String id) {
        PreferenceAlimentaire preferenceAlimentaire = new PreferenceAlimentaire();
        entityManagerHelper.beginTransaction();
        preferenceAlimentaire = entityManager.find(PreferenceAlimentaire.class, Integer.parseInt(id));
        entityManager.remove(preferenceAlimentaire);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(PreferenceAlimentaire preferenceAlimentaire) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(preferenceAlimentaire);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(PreferenceAlimentaire preferenceAlimentaire) {
        entityManagerHelper.beginTransaction();
        entityManager.merge(preferenceAlimentaire);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();
    }
}

