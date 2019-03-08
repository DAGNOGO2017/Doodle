package fr.istic.sir.rest;
import jpa.EntityManagerHelper;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import test.testjpa.domain.Participant;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@JsonAutoDetect
@JsonIgnoreProperties
@Path("/Participant")
public class ParticipantServ {
    private Participant participant;
    private Participant participantDAO = new Participant();
    EntityManagerHelper entityManagerHelper = new EntityManagerHelper();
    EntityManager entityManager = entityManagerHelper.getEntityManager();
    public ParticipantServ() {
        super();
        this.participant = new Participant();
    }

    @GET
    @Path("/participant")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Participant> list(){
        Participant participant = new Participant();
        entityManagerHelper.beginTransaction();
        String req = "Select p from Participant p";
        Query query = entityManager.createQuery(req,Participant.class );
        List<Participant> participants = (List<Participant>) query.getResultList();
        entityManagerHelper.closeEntityManager();
        return participants;
    }

    @GET
    @Path("/participant/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Participant Search(@PathParam("id") String id){
        Participant participant = new Participant();
        entityManagerHelper.beginTransaction();
        participant=entityManager.find(Participant.class, Integer.parseInt(id) );
        entityManagerHelper.closeEntityManager();
        return participant;
    }

    @DELETE @Path("delete/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public  void Delete(@PathParam("id") String id){
        Participant participant = new Participant();
        entityManagerHelper.beginTransaction();
        participant=entityManager.find(Participant.class, Integer.parseInt(id));
        entityManager.remove(participant);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @POST
    @Path("add/")
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public  void Add(Participant participant){
        entityManagerHelper.beginTransaction();
        entityManager.merge(participant);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }

    @PUT
    @Path("update/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void  Update(Participant participant){
        entityManagerHelper.beginTransaction();
        entityManager.merge(participant);
        entityManagerHelper.commit();
        entityManagerHelper.closeEntityManager();

    }
}

