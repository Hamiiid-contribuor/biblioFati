/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.BandeDessine;
import bean.Livre;
import bean.Revus;
import bean.Roman;
import dao.BandeDessineDao;
import java.util.List;

/**
 *
 * @author hamid
 */
public class BandesDService {

    BandeDessineDao bandeDessineDao = new BandeDessineDao();

    public int ajouterBande(BandeDessine bandeDessine) throws Exception {

        return bandeDessineDao.save(bandeDessine);
    }

    public List<BandeDessine> listBandes() throws Exception {
        return bandeDessineDao.findAll();
    }

    public int supprimerBande(BandeDessine bandeDessine) throws Exception {
        return bandeDessineDao.delete(bandeDessine);
    }

    public int modifierBandeD(BandeDessine bandeDessine) throws Exception {
        return bandeDessineDao.update(bandeDessine);
    }
    
  
    
    
    
    
    public List<BandeDessine> rechercheBandes (String isbn, String titre, String auteur, String editeur) throws Exception {

        String  requette  = "SELECT  * FROM bandeDessine WHERE 1=1 " ;
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
        
        return bandeDessineDao.load(requette);
    }
    
     public List<BandeDessine> findByISBN(String isbn) throws Exception {

        String requette = "SELECT * FROM bandedessine WHERE 1=1 ";
        if (isbn != null && !isbn.equals("")) {
            requette += "AND id like '" + isbn + "%'";
        }
        return bandeDessineDao.load(requette);
    }
   

}

