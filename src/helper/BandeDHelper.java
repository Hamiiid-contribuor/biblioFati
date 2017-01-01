/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.BandeDessine;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author hamid
 */
public class BandeDHelper extends AbstractHelper<BandeDessine> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem(" ISBN ", "id"),
            new AbstractHelperItem("Titre", "titre"),
            new AbstractHelperItem("Auteur ", "auteur"),
            new AbstractHelperItem("Couleur ", "couleur"),
            new AbstractHelperItem("Collection", "collection"),};
    }

    public BandeDHelper(JTable jTable, List<BandeDessine> list) {
        super(titres, jTable, list);
    }

    public BandeDHelper(JTable jTable) {
        super(titres, jTable);

    }
}
