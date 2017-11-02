/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg.yekolab.servlet;

import cg.yekolab.dao.ConnetionDatabase;
import cg.yekolab.lab.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Orion WAMBERT
 */
@WebServlet(value = "/")
public class RegisterController extends HttpServlet {

    // Information  de la bdd
    private String url = "jdbc:mysql://localhost:3306/yekolab_db";
    private String username = "root";
    private String password = "";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/RegisterJsp.jsp")
                .forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        ConnetionDatabase.initConnection();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            /* String requete = "";
            //Chargemnt des pilotes 
            Class.forName("com.mysql.jdbc.Driver");
            //recuperation de la connexion à la bdd
            Connection connexion = DriverManager.getConnection(url, username, password);
            //Création du statement 
            Statement stm = connexion.createStatement();
             */
            //Ecriture de la requete
            if (req.getParameter("btn1").equalsIgnoreCase("1")) {
                //insertion des données
                /* requete = "INSERT INTO membres (nom,prenom,age) "
                        + "VALUES('" + req.getParameter("nom") + "','" + req.getParameter("prenom") + "'"
                        + ",'" + req.getParameter("age") + "')";
                //execution de la requete
                stm.executeUpdate(requete);*/

                User user = new User();

                user.setNom(req.getParameter("nom"));
                user.setPrenom(req.getParameter("prenom"));
                user.setAge(Integer.parseInt(req.getParameter("age")));
                ConnetionDatabase.addUserDatabase(user);

            } else if (req.getParameter("btn1").equalsIgnoreCase("remove")) {
                //supression des données
                /* requete="DELETE FROM membres WHERE id='"+req.getParameter("id")+"'";
                stm.executeUpdate(requete);*/
                ConnetionDatabase.removeUserDatabase(req.getParameter("id"));

            } else if (req.getParameter("btn1").equalsIgnoreCase("3")) {
                //supression des données
                /* requete="UPDATE membres SET nom='"+req.getParameter("nom")+"'"
                        + " ,prenom='"+req.getParameter("prenom")+"'"
                        + " ,age='"+req.getParameter("age")+"' WHERE id='"+req.getParameter("id3")+"'";
                stm.executeUpdate(requete);*/
                User user = new User();
                user.setId(Integer.parseInt(req.getParameter("id3")));

                user.setNom(req.getParameter("nom"));
                user.setPrenom(req.getParameter("prenom"));
                
                try {
                    user.setAge(Integer.parseInt(req.getParameter("age")));
                } catch (NumberFormatException e) {
                    user.setAge(10);
                    e.printStackTrace();
                }
                

                ConnetionDatabase.updateUserDatabase(user);

            } else if (req.getParameter("btn1").equalsIgnoreCase("modification")) {
                /* requete = "SELECT * FROM membres WHERE id='"+req.getParameter("id2")+"'";
                User us = new User();
                ResultSet result = stm.executeQuery(requete);
                while (result.next()) {
                    
                    us.setId(result.getInt("id"));
                    us.setNom(result.getString("nom"));
                    us.setPrenom(result.getString("prenom"));
                    us.setAge(result.getInt("age"));
                    
                }
                ;*/
              req.setAttribute("user", ConnetionDatabase.selectUser(req.getParameter("id2")));

            } else {
                //chargement des données
                /*  requete = "SELECT * FROM membres";
                ArrayList<User> user = new ArrayList<>();
                ResultSet result = stm.executeQuery(requete);
                while (result.next()) {
                    User us = new User();
                    us.setId(result.getInt("id"));
                    us.setNom(result.getString("nom"));
                    us.setPrenom(result.getString("prenom"));
                    us.setAge(result.getInt("age"));
                    user.add(us);
                }
                req.setAttribute("listUser", user);
                
                 */
                req.setAttribute("listUser", ConnetionDatabase.SelectAllUserDatabase());

            }

            this.getServletContext().getRequestDispatcher("/RegisterJsp.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
