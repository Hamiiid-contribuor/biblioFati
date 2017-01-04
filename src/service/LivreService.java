/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.GuideVoyage;
import bean.Livre;
import dao.LivreDao;
import java.util.List;

/**
 *
 * @author hamid
 */
public class LivreService {

    LivreDao livreDao = new LivreDao();

    public int ajouterLivre(Livre livre) throws Exception {

        return livreDao.save(livre);
    }

    public List<Livre> listLivres() throws Exception {
        return livreDao.findAll();
    }

    public int supprimerLivre(Livre livre) throws Exception {
        return livreDao.delete(livre);
    }

    public int modifierLivre(Livre livre) throws Exception {
        return livreDao.update(livre);
    }

    public List<Livre> rechercheLivres(String isbn, String titre, String auteur, String editeur) throws Exception {

        String requette = "SELECT  * FROM livre WHERE 1=1 ";
        if (isbn != null && !isbn.equals("")) {
            requette += " AND id like '" + isbn + "%'";
        }
        if (titre != null && !titre.equals("")) {
            requette += " AND titre like '" + titre + "%'";
        }
        if (auteur != null && !auteur.equals("")) {
            requette += " AND auteur like '" + auteur + "%'";
        }
        if (editeur != null && !editeur.equals("")) {
            requette += " AND editeur like '" + editeur + "%'";
        }
       

        return livreDao.load(requette);
    }

    public List<Livre> findByISBN(String isbn) throws Exception {

        String requette = "SELECT * FROM livre WHERE 1=1 ";
        if (isbn != null && !isbn.equals("")) {
            requette += "AND id like '" + isbn + "%'";
        }
        return livreDao.load(requette);
    }
}
