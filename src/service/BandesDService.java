/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.BandeDessine;
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

}
