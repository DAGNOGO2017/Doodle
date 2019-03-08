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

import test.testjpa.domain.Reunion;
import test.testjpa.domain.Utilisateur;

@WebServlet(name="reunioninfo",
        urlPatterns={"/ReunionInfo"})

public class ReunionInfo extends HttpServlet {
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
            Reunion reunion = new Reunion();
            out.println("<HTML>\n<BODY>\n" +
                    "<H1>Recapitulatif des informations</H1>\n" +
                    "<UL>\n" +
                    " <LI>Nom: "
                    + request.getParameter("intitule") + "\n" +
                    " <LI>Prenoms: "
                    + request.getParameter("resume") + "\n" +
                    "</BODY></HTML>");
            reunion.setIntitule(request.getParameter("intitule"));
            reunion.setResume(request.getParameter("resume"));
            manager.persist(reunion);
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
