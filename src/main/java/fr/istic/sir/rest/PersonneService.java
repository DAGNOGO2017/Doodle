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
@JsonAutoDetect
@JsonIgnoreProperties
@Path("/Personne")
public class PersonneService {
    private PersonneDaoImpl personneDaoImpl = new PersonneDaoImpl();
    EntityManager entityManager;
    public PersonneService() {
        super();
        
    }

    @GET
    @Path("/personne")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> list(){
        List<Personne> personne = personneDaoImpl.getList();
        return personne;
    }

   
    @POST
    @Path("add/")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  void Add(Personne personne){   
        personneDaoImpl.addPersonne(personne);
    }

}

