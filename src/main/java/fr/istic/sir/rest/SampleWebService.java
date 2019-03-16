package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Entities.Createur;
import Entities.Participant;
import Entities.Utilisateur;

import java.util.List;

@Path("/hello")
public class SampleWebService {
   // private Utilisateur createurs = new Participant();
    @GET
    @Produces(MediaType.TEXT_PLAIN)

    public String sayHello() {
        return "Hello, how are you?";
    }

}

