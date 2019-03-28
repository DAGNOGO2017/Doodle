package fr.istic.sir.rest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import DAOImpl.PersonneDaoImpl;
import Entities.Personne;
import jpa.EntityManagerHelper;
@JsonAutoDetect
@JsonIgnoreProperties
@Path("/Personne")
public class PersonneService {
    private Personne personne;
    private PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl();
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public PersonneService() {
        super();
        this.personne = new Personne();
    }

    @GET
    @Path("/personne")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> list(){
        entityManagerHelper.beginTransaction();
        List<Personne> personne = personneDaoImpl.getList();
        entityManagerHelper.closeEntityManager();
        return personne;
    }

   
    @POST
    @Path("add/")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  void Add(Personne personne){
        entityManagerHelper.beginTransaction();
        personneDaoImpl.addPersonne(personne);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

}

