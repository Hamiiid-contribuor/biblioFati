/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author hamid
 */
public class Emprunter {

    private int id; // on va  le mettre auto  dans la base  
    private Personne personne;
    private Date datePret;
    private Date DateRetour;
    private String EtatOuvrage;

    private String idOuvrage;
    private String typeOuvrage;
    private int retourner  ; 

    public Emprunter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Date getDatePret() {
        return datePret;
    }

    public void setDatePret(Date datePret) {
        this.datePret = datePret;
    }

    public Date getDateRetour() {
        return DateRetour;
    }

    public void setDateRetour(Date DateRetour) {
        this.DateRetour = DateRetour;
    }

    public String getEtatOuvrage() {
        return EtatOuvrage;
    }

    public void setEtatOuvrage(String EtatOuvrage) {
        this.EtatOuvrage = EtatOuvrage;
    }

    public String getIdOuvrage() {
        return idOuvrage;
    }

    public void setIdOuvrage(String idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public String getTypeOuvrage() {
        return typeOuvrage;
    }

    public void setTypeOuvrage(String typeOuvrage) {
        this.typeOuvrage = typeOuvrage;
    }

    public int getRetourner() {
        return retourner;
    }

    public void setRetourner(int retourner) {
        this.retourner = retourner;
    }
    
    

    @Override
    public String toString() {
        return "Emprunter{" + "id=" + id + ", personne=" + personne + ", datePret=" + datePret + ", DateRetour=" + DateRetour + ", EtatOuvrage=" + EtatOuvrage + ", idOuvrage=" + idOuvrage + ", typeOuvrage=" + typeOuvrage + '}';
    }
    
    

}
