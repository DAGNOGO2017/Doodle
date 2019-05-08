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

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import DAOImpl.ParticipantDaoImpl;
import Entities.Participant;
@JsonAutoDetect
@JsonIgnoreProperties
@Path("/Participant")
public class ParticipantServ {
    private EntityManager em;
    private ParticipantDaoImpl participantDaoImpl = new ParticipantDaoImpl();
    public ParticipantServ() {
        super();
        
    }

    @GET
    @Path("/participant")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Participant> list(){
        List<Participant> participants = participantDaoImpl.getList();
        return participants;
    }

    @GET
    @Path("/participant/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Participant Search(@PathParam("id") String id){
        Participant participant = new Participant();
        
        participant=em.find(Participant.class, Integer.parseInt(id) );
        return participant;
    }

    @DELETE @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public  void Delete(@PathParam("id") String id){
        Participant participant = new Participant();
        participant=em.find(Participant.class, Integer.parseInt(id));
        participantDaoImpl.removeParticipant(participant);

    }

    @POST
    @Path("add/")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  void Add(Participant participant){
        participantDaoImpl.addParticipant(participant);

    }

    @PUT
    @Path("update")
    @Consumes({MediaType.APPLICATION_JSON})
    public void  Update(Participant participant){
        participantDaoImpl.updateParticipant(participant);
    }
}

