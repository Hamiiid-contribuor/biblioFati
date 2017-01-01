/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Roman;
import dao.RomanDao;
import java.util.List;

/**
 *
 * @author hamid
 */
public class RomanService {

    RomanDao romanDao = new RomanDao();

    public int ajouterRoman(Roman roman) throws Exception {
        return romanDao.save(roman);
    }

    public List<Roman> listRomans() throws Exception {
        return romanDao.findAll();
    }
    
    public int supprimerRoman(Roman roman) throws Exception{
        return romanDao.delete(roman);
    }
    
    public int modifierRoman (Roman roman) throws Exception{
        return romanDao.update(roman);
    }
    
     public List<Roman> rechercheRomans (String isbn, String titre, String auteur, String editeur) throws Exception {

        String  requette  = "SELECT  * FROM roman WHERE 1=1 " ;
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
        
        return romanDao.load(requette);
    }
}
