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
public class BandeDessine extends Ouvrage {

    private String scenaroi;
    private String couleur;
    private String dessin;
    private String collection;

   

    public BandeDessine() {
    }

    public String getScenaroi() {
        return scenaroi;
    }

    public void setScenaroi(String scenaroi) {
        this.scenaroi = scenaroi;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getDessin() {
        return dessin;
    }

    public void setDessin(String dessin) {
        this.dessin = dessin;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

}
