//package jpa;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Date;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import Entities.*;
//
//@WebServlet(name="sondagelieuform",
//        urlPatterns={"/SondageLieuInfo"})
//
//public class SondageLieuInfo extends HttpServlet {
//    private EntityManager manager;
//
//
//    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
//        response.setContentType("text/html");
//        EntityManagerFactory factory = Persistence
//                .createEntityManagerFactory("sir_tp2v1");
//        EntityManager manager = factory.createEntityManager();
//        //JpaTest jpa = new JpaTest(manager);
//        EntityTransaction tx = manager.getTransaction();
//        tx.begin();
//        PrintWriter out = response.getWriter();
//        try {
//            Sondage sondage = new SondageLieu();
//            out.println("<HTML>\n<BODY>\n" +
//                    "<H1>Recapitulatif des informations</H1>\n" +
//                    "<UL>\n" +
//                    " <LI>Date: "
//                    + request.getParameter("date") + "\n" +
//                    " <LI>Sondage: "
//                    + request.getParameter("sondage") + "\n" +
//                    " <LI>Type: "
//                    + request.getParameter("type") + "\n" +
//                    "</BODY></HTML>");
//
//            sondage.setDateCloture(request.getParameter("date"));
//            sondage.setLibelleSondage(request.getParameter("sondage"));
//            sondage.setType(request.getParameter("type"));
//            manager.persist(sondage);
//            //jpa.createUser();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        tx.commit();
//
//
//        manager.close();
//        EntityManagerHelper.closeEntityManagerFactory();
//        //		factory.close();
//
//
//
//    }
//
//
//
//}
