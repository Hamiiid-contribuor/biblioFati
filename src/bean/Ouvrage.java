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
public class Ouvrage {

    private String id; /// on considere  que  c'est le  ISBN 
    private String titre;
    private String auteur;
    private String editeur;
    private Date dateEdition;
    private String couverture;
    private int quantiteStock;

    public Ouvrage() {
    }

    public Ouvrage(String id, String titre, String auteur, String editeur, Date dateEdition, int quantiteStock) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.dateEdition = dateEdition;
        this.quantiteStock = quantiteStock;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    @Override
    public String toString() {
        return "Ouvrage{" + "id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", editeur=" + editeur + ", dateEdition=" + dateEdition + ", couverture=" + couverture + ", quantiteStock=" + quantiteStock + '}';
    }

}
