package jpa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.testjpa.domain.*;

@WebServlet(name="preferenceinfo",
        urlPatterns={"/PreferenceInfo"})

public class PreferenceInfo extends HttpServlet {
    private EntityManager manager;


    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("sir_tp2v1");
        EntityManager manager = factory.createEntityManager();
        //JpaTest jpa = new JpaTest(manager);
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        PrintWriter out = response.getWriter();
        try {
            PreferenceAlimentaire preferenceAlimentaire = new PreferenceAlimentaire();
            out.println("<HTML>\n<BODY>\n" +
                    "<H1>Recapitulatif des informations</H1>\n" +
                    "<UL>\n" +
                    " <LI>Péférence: "
                    + request.getParameter("preference") + "\n" +
                    "</BODY></HTML>");
            preferenceAlimentaire.setLibellePreferenceAlimentaire(request.getParameter("preference"));
            //participant.setEmailUtilisateur(request.getParameter("email"));
            manager.persist(preferenceAlimentaire);
            //jpa.createUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();


        manager.close();
        EntityManagerHelper.closeEntityManagerFactory();
        //		factory.close();



    }



}
