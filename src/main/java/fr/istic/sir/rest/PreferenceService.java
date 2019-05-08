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

import DAOImpl.PrefAlimentaireDaoImpl;
import Entities.PreferenceAlimentaire;
import jpa.EntityManagerHelper;

@Path("/Preference")
public class PreferenceService {
    PrefAlimentaireDaoImpl prefAlimentaireDaoImpl = new PrefAlimentaireDaoImpl();
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager;
    public PreferenceService() {
        super();
    }
    @GET
    @Path("/preference")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PreferenceAlimentaire> list(){
        List<PreferenceAlimentaire> preferenceAlimentaires = prefAlimentaireDaoImpl.getList();
        return preferenceAlimentaires;
    }
    @GET
    @Path("/preference/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    public PreferenceAlimentaire Search(@PathParam("emailParticipant") String id) {
        PreferenceAlimentaire preferenceAlimentaire = new PreferenceAlimentaire();
        preferenceAlimentaire = entityManager.find(PreferenceAlimentaire.class, Integer.parseInt(id));
        return preferenceAlimentaire;
    }

    @DELETE
    @Path("delete/{emailParticipant}")
    @Produces({MediaType.APPLICATION_JSON})
    public void Delete(@PathParam("emailParticipant") String id) {
        PreferenceAlimentaire preferenceAlimentaire = new PreferenceAlimentaire();
        preferenceAlimentaire = entityManager.find(PreferenceAlimentaire.class, Integer.parseInt(id));
        prefAlimentaireDaoImpl.removeprefAlimentaire(preferenceAlimentaire);
    }

    @POST
    @Path("add/{emailParticipant}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Add(@PathParam("emailParticipant")String id, PreferenceAlimentaire preferenceAlimentaire) {
        prefAlimentaireDaoImpl.addprefAlimentaire(id, preferenceAlimentaire);
    }

    @PUT
    @Path("update/{emailParticipant}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void Update(@PathParam("emailParticipant") int id, PreferenceAlimentaire pref) {
       // preferenceAlimentaire = entityManager.find(PreferenceAlimentaire.class, id);
        prefAlimentaireDaoImpl.updatePrefAlimentaire(id, pref);
    }
}

