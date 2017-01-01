/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Emprunter;
import bean.Personne;
import dao.EmprunterDao;

/**
 *
 * @author hamid
 */
public class EmprunteService {

    PersonneService personneService = new PersonneService();
    EmprunterDao emprunterDao = new EmprunterDao();

    public EmprunteService() {
    }

    public int modifierEmprunte(Emprunter emprunter) throws Exception {
        return emprunterDao.update(emprunter);
    }

    public int traitmentEmp(Emprunter emprunter) throws Exception {

        Personne p = personneService.findById(emprunter.getPersonne().getId());
        System.out.println("haaa l'abonne li bay emprunter --> " + p);

        if (p.getNbrTotaleEmprunte() < 5) {

            if (emprunter.getTypeOuvrage().equals("Livre")) {

                if (p.getNbrLivreEmprunter() < 3) {
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

        }
        //pas de droit d'emprunter nbTotale >5
        return -3;
    }
}
