/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cg.yekolab.lab.model;

/**
 *
 * @author ricken07
 */
public class Livre {
    //identifiant unique et obligatoire
    private int id;
    /**
     * propietes obligatoire
     */
    private String nom;
    private String dateEdition;
    private String auteur;
    private String nombrePage;
    private String editeur;

    public Livre() {
    }

    public Livre(int id, String nom, String dateEdition, String auteur, 
            String nombrePage, String editeur) {
        this.id = id;
        this.nom = nom;
        this.dateEdition = dateEdition;
        this.auteur = auteur;
        this.nombrePage = nombrePage;
        this.editeur = editeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(String dateEdition) {
        this.dateEdition = dateEdition;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getNombrePage() {
        return nombrePage;
    }

    public void setNombrePage(String nombrePage) {
        this.nombrePage = nombrePage;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }
    
}
