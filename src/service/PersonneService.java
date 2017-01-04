/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Personne;
import dao.PersonneDao;
import java.util.List;

/**
 *
 * @author hamid
 */
public class PersonneService {

    PersonneDao personneDao = new PersonneDao();

    public int ajouterPersonne(Personne personne) throws Exception {

        return personneDao.save(personne);
    }

    public int modifiererPersonne(Personne personne) throws Exception {

        return personneDao.update(personne);
    }

    public List<Personne> listPersonne() throws Exception {
        return personneDao.findAll();
    }

    public int supprimerPersonne(Personne personne) throws Exception {
        return personneDao.delete(personne);
    }

    public Personne findById(String id) throws Exception {
        return personneDao.findById(id);
    }

    public List<Personne> rechercheParId(String id) throws Exception {

        String requette = "SELECT * FROM  personne  WHERE type='Adherent' AND  1=1 ";
        if (id != null && !id.equals("")) {
            requette += " AND id like '" + id + "%'";
        }
        System.out.println("ha res de recherche -->"+personneDao.load(requette));
        return personneDao.load(requette);
    }

    public List<Personne> rechercheAdherent(String id, String nom, String prenom, String email, String tel) throws Exception {

        String requette = "SELECT  * FROM personne WHERE type='Adherent' AND  1=1 ";

        if (id != null && !id.equals("")) {
            requette += "AND id like '" + id + "%' ";
        }
        if (nom != null && !nom.equals("")) {
            requette += "AND nom like '" + nom + "%' ";
        }
        if (prenom != null && !prenom.equals("")) {
            requette += "AND prenom like '" + prenom + "%' ";
        }
        if (email != null && !email.equals("")) {
            requette += "AND email like '" + email + "%' ";
        }
        if (tel != null && !tel.equals("")) {
            requette += "AND telephone like '" + tel + "%' ";
        }

        return personneDao.load(requette);
    }

    public List<Personne> rechercheAssistant(String id, String nom, String prenom, String email, String tel) throws Exception {

        String requette = "SELECT  * FROM personne WHERE type='Assistant' AND  1=1 ";

        if (id != null && !id.equals("")) {
            requette += "AND id like '" + id + "%' ";
        }
        if (nom != null && !nom.equals("")) {
            requette += "AND nom like '" + nom + "%' ";
        }
        if (prenom != null && !prenom.equals("")) {
            requette += "AND prenom like '" + prenom + "%' ";
        }
        if (email != null && !email.equals("")) {
            requette += "AND email like '" + email + "%' ";
        }
        if (tel != null && !tel.equals("")) {
            requette += "AND telephone like '" + tel + "%' ";
        }

        return personneDao.load(requette);
    }

    public List<Personne> listAdherent() throws Exception {
        String requette = "SELECT * FROM  personne WHERE type='Adherent' ";
        return personneDao.load(requette);
    }

    public List<Personne> listAssistant() throws Exception {
        String requette = "SELECT * FROM  personne WHERE type='Assistant' ";
        return personneDao.load(requette);
    }

    //methode de connexion au systeme 
    public Personne seConnecter(String login, String password) throws Exception {

        String requette = "SELECT * from personne WHERE login ='" + login + "' AND password ='" + password + "'";
        System.out.println(requette);
        if (!personneDao.load(requette).isEmpty()) {
            return personneDao.load(requette).get(0);
        }

        return null;

    }
}
