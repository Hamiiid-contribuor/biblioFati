/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Revus;
import bean.Roman;
import dao.RevusDao;
import java.util.List;

/**
 *
 * @author hamid
 */
public class RevusService {

    RevusDao revusDao = new RevusDao();

    public int ajouterRevus(Revus revus) throws Exception {

        return revusDao.save(revus);
    }

    public List<Revus> listRevus() throws Exception {
        return revusDao.findAll();
    }

    public int supprimerRevus(Revus revus) throws Exception {
        return revusDao.delete(revus);
    }

    public int modifierRevus(Revus revus) throws Exception {
        return revusDao.update(revus);
    }
    
     public List<Revus> rechercheRevus (String isbn, String titre, String auteur, String editeur) throws Exception {

        String  requette  = "SELECT  * FROM revus WHERE 1=1 " ;
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
        
        return revusDao.load(requette);
    }
}
