/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.GuideVoyage;
import bean.Revus;
import dao.GuideVoyageDao;
import java.util.List;

/**
 *
 * @author hamid
 */
public class GuideService {

    GuideVoyageDao guideVoyageDao = new GuideVoyageDao();

    public int ajouterGuide(GuideVoyage guideVoyage) throws Exception {

        return guideVoyageDao.save(guideVoyage);
    }

    public List<GuideVoyage> listGuides() throws Exception {
        return guideVoyageDao.findAll();
    }

    public int supprimerGuide(GuideVoyage guideVoyage) throws Exception {
        return guideVoyageDao.delete(guideVoyage);
    }

    public int modifierGuide(GuideVoyage guideVoyage) throws Exception {
        return guideVoyageDao.update(guideVoyage);
    }
    
    public List<GuideVoyage> rechercheGuides (String isbn, String titre, String auteur, String editeur) throws Exception {

        String  requette  = "SELECT  * FROM guidevoyage WHERE 1=1 " ;
        if(isbn != null && !isbn.equals("")){
            requette += " AND id like '"+isbn+"%'"; 
        }
        if(titre != null && !titre.equals("")){
            requette += " AND titre like '"+titre+"%'"; 
        }
        if(auteur != null && !auteur.equals("")){
            requette += " AND auteur like '"+auteur+"%'"; 
        }
        if(editeur != null && !editeur.equals("")){
            requette += " AND editeur like '"+editeur+"%'"; 
        }
        
        return guideVoyageDao.load(requette);
    }
}
