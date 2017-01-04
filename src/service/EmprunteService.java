/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.BandeDessine;
import bean.Emprunter;
import bean.GuideVoyage;
import bean.Livre;
import bean.Personne;
import bean.Roman;
import dao.BandeDessineDao;
import dao.EmprunterDao;
import dao.GuideVoyageDao;
import dao.LivreDao;
import dao.RomanDao;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hamid
 */
public class EmprunteService {

    PersonneService personneService = new PersonneService();

    EmprunterDao emprunterDao = new EmprunterDao();
    RomanService romanService = new RomanService();
    LivreService livreService = new LivreService();
    GuideService guideService = new GuideService();
    BandesDService bandesDService = new BandesDService();
    BandeDessineDao bandeDessineDao = new BandeDessineDao();
    LivreDao livreDao = new LivreDao();
    RomanDao romanDao = new RomanDao();
    GuideVoyageDao guideVoyageDao = new GuideVoyageDao();

    public EmprunteService() {
    }

    public int modifierEmprunte(Emprunter emprunter) throws Exception {
        return emprunterDao.update(emprunter);
    }

    public int traitmentEmp(Emprunter emprunter) throws Exception {

        Personne p = personneService.findById(emprunter.getPersonne().getId());

        System.out.println("haaa l'abonne li bay emprunter --> " + p);

        if (p.getNbrTotaleEmprunte() < 5) {
            
            Date curentDate = new Date();

            if (emprunter.getTypeOuvrage().equals("Livre")) {

                if (p.getNbrLivreEmprunter() < 3) {

                    
                    emprunter.setDateRetour(convertUtilToSql(addDays(curentDate, 30)));

                    Livre livreEmprunter = livreDao.findById(emprunter.getIdOuvrage());
                    System.out.println("haa livre li t emprunta -->" + livreEmprunter);
                    livreEmprunter.setQuantiteStock(livreEmprunter.getQuantiteStock() - 1);
                    livreDao.update(livreEmprunter);

                    emprunterDao.save(emprunter);
                    p.setNbrLivreEmprunter(p.getNbrLivreEmprunter() + 1);
                    p.setNbrTotaleEmprunte(p.getNbrTotaleEmprunte() + 1);
                    personneService.modifiererPersonne(p);
                    emprunter.setPersonne(p);
                    this.modifierEmprunte(emprunter);

                    return 1;
                } else {
                    return -1;
                }
            }
            if (emprunter.getTypeOuvrage().equals("Roman")) {

                if (p.getNbrRomanEmprunter() < 3) {

                    
                   emprunter.setDateRetour(convertUtilToSql(addDays(curentDate, 30)));


                    Roman romanAEmprunter = romanDao.findById(emprunter.getIdOuvrage());
                    romanAEmprunter.setQuantiteStock(romanAEmprunter.getQuantiteStock() - 1);
                    romanAEmprunter.setCouverture(romanAEmprunter.getCouverture());
                    romanDao.update(romanAEmprunter);

                    emprunterDao.save(emprunter);
                    p.setNbrRomanEmprunter(p.getNbrRomanEmprunter() + 1);
                    p.setNbrTotaleEmprunte(p.getNbrTotaleEmprunte() + 1);
                    personneService.modifiererPersonne(p);
                    emprunter.setPersonne(p);
                    this.modifierEmprunte(emprunter);

                    return 2;
                } else {
                    return -2;
                }
            }
            if (emprunter.getTypeOuvrage().equals("Guide")) {

                if (p.getNbrRomanEmprunter() < 2) {

                    emprunter.setDateRetour(convertUtilToSql(addDays(curentDate, 21)));


                    GuideVoyage guideEmprunter = guideVoyageDao.findById(emprunter.getIdOuvrage());
                    guideEmprunter.setQuantiteStock(guideEmprunter.getQuantiteStock() - 1);
                    guideVoyageDao.update(guideEmprunter);
                    emprunterDao.save(emprunter);
                    p.setNbrRomanEmprunter(p.getNbrRomanEmprunter() + 1);
                    p.setNbrTotaleEmprunte(p.getNbrTotaleEmprunte() + 1);
                    personneService.modifiererPersonne(p);
                    emprunter.setPersonne(p);
                    this.modifierEmprunte(emprunter);

                    return 4;
                } else {
                    return -4;
                }
            }
            if (emprunter.getTypeOuvrage().equals("BandeDessine")) {

                if (p.getNbrBandeDesinesEmprunter() < 5) {

                   emprunter.setDateRetour(convertUtilToSql(addDays(curentDate, 15)));


                    BandeDessine bandeEmprunter = bandeDessineDao.findById(emprunter.getIdOuvrage());
                    bandeEmprunter.setQuantiteStock(bandeEmprunter.getQuantiteStock() - 1);
                    bandeDessineDao.update(bandeEmprunter);
                    emprunterDao.save(emprunter);
                    p.setNbrBandeDesinesEmprunter(p.getNbrRomanEmprunter() + 1);
                    p.setNbrTotaleEmprunte(p.getNbrTotaleEmprunte() + 1);
                    personneService.modifiererPersonne(p);
                    emprunter.setPersonne(p);
                    this.modifierEmprunte(emprunter);

                    return 5;
                } else {
                    return -5;
                }
            }

        }
        //pas de droit d'emprunter nbTotale >5
        return -3;
    }

    public Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public List<Emprunter> ficheAdherent(String idPersonne) throws Exception {

        String requete = "SELECT  * FROM emprunter WHERE personne = '" + idPersonne + "' AND retourner =0";
        System.out.println("ha requette  --->" + requete);
        System.out.println("haaaaaa lista -->"+emprunterDao.load(requete));
        return emprunterDao.load(requete);

    }

//convertir la date de java a une date sql 
    private static java.sql.Date convertUtilToSql(java.util.Date utilDate) {
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    //convertir la date sql  a une date comprehensible par java  
    public static java.util.Date convertSqlToUtil(java.sql.Date sqlDate) {
        java.util.Date javaDate = new Date(sqlDate.getTime());
        return javaDate;
    }

}
