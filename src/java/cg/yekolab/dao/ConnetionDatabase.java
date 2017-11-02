/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg.yekolab.dao;

import cg.yekolab.lab.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HP Notebook
 */
public class ConnetionDatabase {

    private String url = "jdbc:mysql://localhost:3306/yekolab_db";
    private String username = "root";
    private String password = "";
    private static Connection connexion = null;
    private static Statement stm = null;

    private ConnetionDatabase() {
        try {

            //Chargemnt des pilotes 
            Class.forName("com.mysql.jdbc.Driver");
            //recuperation de la connexion à la bdd
            connexion = DriverManager.getConnection(url, username, password);
            //Création du statement 
            stm = connexion.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initConnection() {
        if (connexion == null) {
            new ConnetionDatabase();

        }
    }

    public static void addUserDatabase(User user) {
        try {
            String requete = "INSERT INTO membres (nom,prenom,age) "
                    + "VALUES('" + user.getNom() + "','" + user.getPrenom() + "'"
                    + ",'" + user.getAge() + "')";
            //execution de la requete
            stm.executeUpdate(requete);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static User selectUser(String id){
       String requete = "SELECT * FROM membres WHERE id='"+id+"'";
                User us = new User();
              try {
              ResultSet result = stm.executeQuery(requete);
                while (result.next()) {
                    
                    us.setId(result.getInt("id"));
                    us.setNom(result.getString("nom"));
                    us.setPrenom(result.getString("prenom"));
                    us.setAge(result.getInt("age"));
                    
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
              return  us;
        
    }

    public static void removeUserDatabase(String id) {
        try {
            String requete = "DELETE FROM membres WHERE id='" + id + "'";
            stm.executeUpdate(requete);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void updateUserDatabase(User user) {
        try {
            String requete = "UPDATE membres SET nom='" + user.getNom() + "'"
                    + " ,prenom='" + user.getPrenom() + "'"
                    + " ,age='" + user.getAge() + "' WHERE id='" + user.getId() + "'";

            stm.executeUpdate(requete);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<User> SelectAllUserDatabase() {
        ArrayList<User> user = new ArrayList<>();
        try {
            String requete = "SELECT * FROM membres";

            ResultSet result = stm.executeQuery(requete);
            while (result.next()) {
                User us = new User();
                us.setId(result.getInt("id"));
                us.setNom(result.getString("nom"));
                us.setPrenom(result.getString("prenom"));
                us.setAge(result.getInt("age"));
                user.add(us);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}
